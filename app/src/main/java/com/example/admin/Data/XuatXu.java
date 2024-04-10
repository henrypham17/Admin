package com.example.admin.Data;

public class XuatXu {
    private String MaXuatXu,TenXuatXu;

    public XuatXu(){}

    public XuatXu(String maXuatXu, String tenXuatXu) {
        MaXuatXu = maXuatXu;
        TenXuatXu = tenXuatXu;
    }

    public String getMaXuatXu() {
        return MaXuatXu;
    }

    public void setMaXuatXu(String maXuatXu) {
        MaXuatXu = maXuatXu;
    }

    public String getTenXuatXu() {
        return TenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        TenXuatXu = tenXuatXu;
    }
}
