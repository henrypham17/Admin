package com.example.admin;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView textView;
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

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            String titlePrefix = "Danh sách ";
            String selectedCategory;

            int id = menuItem.getItemId();
            if (id == R.id.single_movie) {
                selectedCategory = "Phim lẻ";
            } else if (id == R.id.cartoon) {
                selectedCategory = "Phim hoạt hình";
            } else if (id == R.id.series_movie) {
                selectedCategory = "Phim bộ";
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
}