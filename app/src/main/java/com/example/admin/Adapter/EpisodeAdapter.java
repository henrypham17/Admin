package com.example.admin.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.admin.Data.TapPhim;
import com.example.admin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private ArrayList<TapPhim> tapPhimList;

    public EpisodeAdapter(ArrayList<TapPhim> tapPhimList) {
        this.tapPhimList = tapPhimList;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_admin_film, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        TapPhim tapPhim = tapPhimList.get(position);
        holder.episodeTextView.setText(tapPhim.getTap());
    }

    @Override
    public int getItemCount() {
        return tapPhimList.size();
    }

    public static class EpisodeViewHolder extends RecyclerView.ViewHolder {
        TextView episodeTextView;
        ImageView episodeImage;

        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
            episodeTextView = itemView.findViewById(R.id.episode_text);
            episodeImage = itemView.findViewById(R.id.episode_image);
        }
    }
}