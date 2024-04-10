package com.example.admin.Data;

public class TinhTrang {
    private String MaTinhTrang,TenTinhTrang;

    public TinhTrang(){}

    public TinhTrang(String maTinhTrang, String tenTinhTrang) {
        MaTinhTrang = maTinhTrang;
        TenTinhTrang = tenTinhTrang;
    }

    public String getMaTinhTrang() {
        return MaTinhTrang;
    }

    public void setMaTinhTrang(String maTinhTrang) {
        MaTinhTrang = maTinhTrang;
    }

    public String getTenTinhTrang() {
        return TenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        TenTinhTrang = tenTinhTrang;
    }
}
