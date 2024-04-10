package com.example.admin;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        ImageView backButton = findViewById(R.id.buttonback); // Replace with your actual back button ID
        backButton.setOnClickListener(v -> showExitConfirmation());

        setupSpinner(R.id.etMaTL, new String[]{"TC", "HD", "CT", "VT", "PHD", "TX", "HH", "Phiêu lưu"});
        setupSpinner(R.id.etMaTT, new String[]{"DF", "DCN", "SRM"});
        setupSpinner(R.id.etPL, new String[]{"PB", "PL", "HH"});

    }

    private void setupSpinner(int spinnerId, String[] options) {
        Spinner spinner = findViewById(spinnerId);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void showExitConfirmation() {
        new AlertDialog.Builder(this)
                .setMessage("Bạn muốn hủy thêm mới phim và rời khỏi đây?")
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

    // Inside your Activity that loads activity_admin.xml


}