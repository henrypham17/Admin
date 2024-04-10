package com.example.admin.Adapter;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.admin.Data.DbHelper;
import com.example.admin.Data.Phim;
import com.example.admin.EpisodeListActivity;
import com.example.admin.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.phimViewHolder> {

    private ArrayList<Phim> movies;
    private Context context;

    public ViewAdapter(ArrayList<Phim> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public phimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_admin_film,parent,false);

        return new phimViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull phimViewHolder holder, int position) {
        Phim movie = movies.get(position);
        Picasso.get().load(movie.getAnhPhim()).into(holder.imageView);
        holder.titleView.setText(movie.getTenPhim());
        holder.categoryView.setText(movie.getMaTheLoai());

        holder.deleteView.setOnClickListener(view -> {
            new AlertDialog.Builder(context)
                    .setMessage("Bạn có chắc chắn muốn xoá thông tin phim?")
                    .setPositiveButton("Đồng ý", (dialog, which) -> {
                        // Xoá phim từ cơ sở dữ liệu
                        DbHelper db = new DbHelper(context);
                        db.deletePhim(movie.getMaPhim());
                        // Xoá phim từ danh sách và thông báo cho RecyclerView
                        movies.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, movies.size());
                    })
                    .setNegativeButton("Huỷ", null)
                    .show();
        });

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, EpisodeListActivity.class);
            intent.putExtra("MaPhim", movie.getMaPhim());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {

        return movies.size();
    }

    public class phimViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView, deleteView;
        TextView titleView, categoryView;

        public phimViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.still_image);
            titleView = itemView.findViewById(R.id.name_text);
            categoryView = itemView.findViewById(R.id.categoty_text);

            deleteView = itemView.findViewById(R.id.delete_view);
        }

    }

    public void setMovies(ArrayList<Phim> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }
}
