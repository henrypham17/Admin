package com.example.admin.Data;

public class LichSuXem {
    private String MaPhim,TenPhim;
    private Integer TapPhim,MaKhachHang;

    public LichSuXem(String maPhim, String tenPhim, Integer tapPhim, Integer maKhachHang) {
        MaPhim = maPhim;
        TenPhim = tenPhim;
        TapPhim = tapPhim;
        MaKhachHang = maKhachHang;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String maPhim) {
        MaPhim = maPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public Integer getTapPhim() {
        return TapPhim;
    }

    public void setTapPhim(Integer tapPhim) {
        TapPhim = tapPhim;
    }

    public Integer getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        MaKhachHang = maKhachHang;
    }
}
