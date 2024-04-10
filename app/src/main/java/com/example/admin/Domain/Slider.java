package com.example.admin.Domain;

public class Slider {
    private String Image;
    private String TenPhim;

    public Slider(String image, String tenphim) {
        Image = image;
        TenPhim = tenphim;
    }

    public String getImage() {
        return Image;
    }

    public String getTieude() {
        return TenPhim;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setTieude(String tenphim) {
        TenPhim = tenphim;
    }
}
