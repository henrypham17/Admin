package com.example.admin.Data;

public class PhanLoai {
    private String MaPhanLoai,TenPhanLoai;

    public PhanLoai(){}

    public PhanLoai(String maPhanLoai, String tenPhanLoai) {
        MaPhanLoai = maPhanLoai;
        TenPhanLoai = tenPhanLoai;
    }

    public String getMaPhanLoai() {
        return MaPhanLoai;
    }

    public void setMaPhanLoai(String maPhanLoai) {
        MaPhanLoai = maPhanLoai;
    }

    public String getTenPhanLoai() {
        return TenPhanLoai;
    }

    public void setTenPhanLoai(String tenPhanLoai) {
        TenPhanLoai = tenPhanLoai;
    }
}
