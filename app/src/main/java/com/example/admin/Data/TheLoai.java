package com.example.admin.Data;

public class TheLoai {
    private String MaTheLoai,TenTheLoai;

    public TheLoai(){}

    public TheLoai(String maTheLoai, String tenTheLoai) {
        MaTheLoai = maTheLoai;
        TenTheLoai = tenTheLoai;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        MaTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }
}
