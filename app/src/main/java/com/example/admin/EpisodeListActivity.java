package com.example.admin;

import android.app.LauncherActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.admin.Adapter.EpisodeAdapter;
import com.example.admin.Adapter.ViewAdapter;
import com.example.admin.Data.Phim;
import com.example.admin.Data.PhimDAO;
import com.example.admin.Data.TapPhim;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EpisodeListActivity extends AppCompatActivity {
    FloatingActionButton buttonfab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_layout_film); // the layout that includes your RecyclerView

        ImageView backButton = findViewById(R.id.buttonback); // Replace with your actual back button ID
        backButton.setOnClickListener(v -> showExitConfirmation());


        String maPhim = getIntent().getStringExtra("MaPhim");

        // Lấy danh sách tập phim từ PhimDao
        PhimDAO phimDAO = new PhimDAO(this);
        ArrayList<TapPhim> tapPhimList = phimDAO.getTapPhim(maPhim);

        // Hiển thị danh sách tập phim trong RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerEpisode);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EpisodeAdapter adapter = new EpisodeAdapter(tapPhimList);
        recyclerView.setAdapter(adapter);
    }


    private void showExitConfirmation() {
        new AlertDialog.Builder(this)
                .setMessage("Bạn muốn rời khỏi đây?")
                .setCancelable(false)
                .setPositiveButton("Đồng ý", (dialog, id) -> {
                    // User wants to exit
                    finish(); // This will close the current activity and return to MainActivity
                })
                .setNegativeButton("Không", null)
                .show();
    }

    // Optional - Override the onBackPressed method if you want the same functionality for the device's back button
    @Override
    public void onBackPressed() {
        showExitConfirmation();
    }

}