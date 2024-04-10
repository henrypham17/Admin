package com.example.admin.Data;


public class Phim {
    private String MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,DaoDien,DienVien,AnhPhim,MaPhanLoai;

    private Integer ThoiLuong,NamPhatHanh;
    private TheLoai theLoai;
    private TinhTrang tinhTrang;
    private XuatXu xuatXu;
    private TapPhim tapPhim;

    public Phim() {}

    public Phim(String tenPhim,
                String moTa, String daoDien, String dienVien, String anhPhim, Integer thoiLuong,
                Integer namPhatHanh, TheLoai theLoai, TinhTrang tinhTrang, XuatXu xuatXu, TapPhim tapPhim) {
        //MaPhim = maPhim;
        TenPhim = tenPhim;
        MoTa = moTa;
        DaoDien = daoDien;
        DienVien = dienVien;
        AnhPhim = anhPhim;
        ThoiLuong = thoiLuong;
        NamPhatHanh = namPhatHanh;
        this.theLoai = theLoai;
        this.tinhTrang = tinhTrang;
        this.xuatXu = xuatXu;
        this.tapPhim = tapPhim;
    }

    public Phim(String tenPhim,
                String moTa, String daoDien, String dienVien, String anhPhim, Integer thoiLuong,
                Integer namPhatHanh, TheLoai theLoai, TinhTrang tinhTrang, XuatXu xuatXu) {
        //MaPhim = maPhim;
        TenPhim = tenPhim;
        MoTa = moTa;
        DaoDien = daoDien;
        DienVien = dienVien;
        AnhPhim = anhPhim;
        ThoiLuong = thoiLuong;
        NamPhatHanh = namPhatHanh;
        this.theLoai = theLoai;
        this.tinhTrang = tinhTrang;
        this.xuatXu = xuatXu;
    }

    public Phim(String maPhim, String maTheLoai, String maXuatXu, String maTinhTrang, String tenPhim, String luotXem,
                String moTa, String daoDien, String dienVien, String anhPhim, String maPhanLoai, Integer thoiLuong,
                Integer namPhatHanh) {
        MaPhim = maPhim;
        MaTheLoai = maTheLoai;
        MaXuatXu = maXuatXu;
        MaTinhTrang = maTinhTrang;
        TenPhim = tenPhim;
        LuotXem = luotXem;
        MoTa = moTa;
        DaoDien = daoDien;
        DienVien = dienVien;
        AnhPhim = anhPhim;
        MaPhanLoai = maPhanLoai;
        ThoiLuong = thoiLuong;
        NamPhatHanh = namPhatHanh;
    }

    public Phim(String maPhim, String tenPhim, String anhPhim) {
        MaPhim = maPhim;
        TenPhim = tenPhim;
        AnhPhim = anhPhim;
    }

    public void setTapPhim(TapPhim tapPhim) {
        this.tapPhim = tapPhim;
    }

    public String getMaT() {
        return tapPhim.getMaPhim();
    }

    public String getTenTap() {
        return tapPhim.getTap();
    }

    public String getVideoUrl() {
        return tapPhim.getVideo();
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getTheLoai() {
        return theLoai.getTenTheLoai();
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() {
        return  tinhTrang.getTenTinhTrang();
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getXuatXu() {
        return xuatXu.getTenXuatXu();
    }

    public String getMaPhanLoai() {
        return MaPhanLoai;
    }

    public void setMaPhanLoai(String maPhanLoai) {
        MaPhanLoai = maPhanLoai;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String maPhim) {
        MaPhim = maPhim;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        MaTheLoai = maTheLoai;
    }

    public String getMaXuatXu() {
        return MaXuatXu;
    }

    public void setMaXuatXu(String maXuatXu) {
        MaXuatXu = maXuatXu;
    }

    public String getMaTinhTrang() {
        return MaTinhTrang;
    }

    public void setMaTinhTrang(String maTinhTrang) {
        MaTinhTrang = maTinhTrang;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public String getLuotXem() {
        return LuotXem;
    }

    public void setLuotXem(String luotXem) {
        LuotXem = luotXem;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getDaoDien() {
        return DaoDien;
    }

    public void setDaoDien(String daoDien) {
        DaoDien = daoDien;
    }

    public String getDienVien() {
        return DienVien;
    }

    public void setDienVien(String dienVien) {
        DienVien = dienVien;
    }

    public String getAnhPhim() {
        return AnhPhim;
    }

    public void setAnhPhim(String anhPhim) {
        AnhPhim = anhPhim;
    }

    public Integer getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        ThoiLuong = thoiLuong;
    }

    public Integer getNamPhatHanh() {
        return NamPhatHanh;
    }

    public void setNamPhatHanh(Integer namPhatHanh) {
        NamPhatHanh = namPhatHanh;
    }




}
