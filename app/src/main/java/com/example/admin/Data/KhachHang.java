package com.example.admin.Data;

public class KhachHang {
    private String HoTen,Email,TenDangNhap,MatKhau;
    private Integer MaKhachHang;

    public KhachHang() {
    }

    public KhachHang(String hoTen) {
        HoTen = hoTen;
    }

    public KhachHang(String hoTen, String email, String tenDangNhap, String matKhau) {
        HoTen = hoTen;
        Email = email;
        TenDangNhap = tenDangNhap;
        MatKhau = matKhau;
    }

    public KhachHang(String hoTen, String email, String tenDangNhap, String matKhau, Integer maKhachHang) {
        HoTen = hoTen;
        Email = email;
        TenDangNhap = tenDangNhap;
        MatKhau = matKhau;
        MaKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public Integer getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        MaKhachHang = maKhachHang;
    }
}
