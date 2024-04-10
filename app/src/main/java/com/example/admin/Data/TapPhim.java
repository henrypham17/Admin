package com.example.admin.Data;

public class TapPhim {
    private String MaPhim, MaTap, Video, Tap;
    private Phim phim;

    public TapPhim() {
    }

    public TapPhim(String tap, String video) {
        Tap = tap;
        Video = video;
    }

    public TapPhim(String tap, String video, Phim phim) {
        Tap = tap;
        Video = video;
        this.phim = phim;
    }

    public TapPhim(String maPhim, String maTap, String video, String tap) {
        MaPhim = maPhim;
        MaTap = maTap;
        Video = video;
        Tap = tap;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public String getTenphim() {
        return phim.getTenPhim();
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String maPhim) {
        MaPhim = maPhim;
    }

    public String getMaTap() {
        return MaTap;
    }

    public void setMaTap(String maTap) {
        MaTap = maTap;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public String getTap() {
        return Tap;
    }

    public void setTap(String tap) {
        Tap = tap;
    }
}
