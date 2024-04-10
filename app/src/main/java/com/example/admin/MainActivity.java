package com.example.admin;

import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.admin.Adapter.ViewAdapter;
import com.example.admin.Data.Phim;
import com.example.admin.Data.PhimDAO;
import com.example.admin.Data.TapPhim;
import com.example.admin.Domain.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView textView;
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private ArrayList<Category> categories, catePB, catePL, cateHH;
    private PhimDAO phim;

    FloatingActionButton buttonfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin); // Use your layout file name

        // Initialize components
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.etTitle);

        recyclerView = findViewById(R.id.recyclerMenuItems); // make sure this ID is correct
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // set a LayoutManager
        viewAdapter = new ViewAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(viewAdapter);

        buttonfab = findViewById(R.id.fab);
        buttonfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(i);
            }
        });

        // Set the toolbar as the action bar
        setSupportActionBar(toolbar);

        // Create the drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        // Add the toggle to the drawer layout
        drawerLayout.addDrawerListener(toggle);

        // Sync the toggle state
        toggle.syncState();

        phim = new PhimDAO(this);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            String titlePrefix = "Danh sách ";
            String selectedCategory;

            int id = menuItem.getItemId();
            if (id == R.id.single_movie) {
                selectedCategory = "phim lẻ";
                loadMovies("PL");
            } else if (id == R.id.cartoon) {
                selectedCategory = "phim hoạt hình";
                loadMovies("HH");
            } else if (id == R.id.series_movie) {
                selectedCategory = "phim bộ";
                loadMovies("PB");
            } else {
                selectedCategory = "";
            }

            // Assuming tvTitle is the ID of the TextView in the app_bar_admin.xml file
            TextView titleTextView = findViewById(R.id.etTitle);
            titleTextView.setText(titlePrefix + selectedCategory);

            // Close the drawer
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    private void loadMovies(String categoryCode) {
        ArrayList<Phim> movies;
        switch (categoryCode) {
            case "PL": // Code for "phim lẻ"
                movies = phim.getPLe();
                break;
            case "HH": // Code for "hoạt hình"
                movies = phim.getHHinh();
                break;
            case "PB": // Code for "hoạt hình"
                movies = phim.getPBo();
                break;
            default:
                movies = new ArrayList<>();
                break;
        }
        if (movies != null && !movies.isEmpty()) {
            viewAdapter.setMovies(movies);
        } else {
        }
    }

}