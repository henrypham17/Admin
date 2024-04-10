package com.example.admin.Data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class PhimDAO
{

    private DbHelper dbHelper;

    DbHelper csdl;

    public PhimDAO(Context context) {

        csdl = new DbHelper(context);
    }

    public ArrayList<String> getKhuVuc(){
        String sql = "SELECT DISTINCT TenXuatXu FROM XuatXu";
        ArrayList<String> dsKhuVuc = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("TenXuatXu");
                do {
                    String khuVuc = cursor.getString(columnIndex);
                    dsKhuVuc.add(khuVuc);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsKhuVuc;
    }
    public ArrayList<String> getLoai(){
        String sql = "SELECT DISTINCT TenTheLoai FROM TheLoai";
        ArrayList<String> dsLoai = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("TenTheLoai");
                do {
                    String loai = cursor.getString(columnIndex);
                    dsLoai.add(loai);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsLoai;
    }

    public ArrayList<String> getNam(){
        String sql = "SELECT DISTINCT NamPhatHanh FROM Phim";
        ArrayList<String> dsNam = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("NamPhatHanh");
                do {
                    String nam = cursor.getString(columnIndex);
                    dsNam.add(nam);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsNam;
    }

    // Check TenDN, email, matkhau
    public boolean checkUserTM(String tenDN, String matKhau) {
        String sql = "Select * From KhachHang Where TenDangNhap = ? And MatKhau = ?";
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[] {tenDN, matKhau});
        if(cursor.getCount() > 0) {
            return true;
        }
        else return false;
    }

    public boolean checkUserEM(String email, String matKhau) {
        String sql = "Select * From KhachHang Where Email = ? And MatKhau = ?";
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[] {email, matKhau});
        if(cursor.getCount() > 0) {
            return true;
        }
        else return false;
    }

    // Lấy ngẫu nhiên 5 data cho slider đề xuất
    @SuppressLint("Range")
    public ArrayList<Phim> getDX() {
        String sql = "SELECT * FROM Phim ORDER BY RANDOM() LIMIT 5";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy ngẫu nhiên 5 data cho slider phim bộ
    @SuppressLint("Range")
    public ArrayList<Phim> getPB() {
        String sql = "SELECT * FROM Phim " +
                "WHERE MaPhanLoai = 'PB'" +
                "ORDER BY RANDOM() LIMIT 5";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy ngẫu nhiên 5 data cho slider phim lẻ
    @SuppressLint("Range")
    public ArrayList<Phim> getPL() {
        String sql = "SELECT * FROM Phim " +
                "WHERE MaPhanLoai = 'PL'" +
                "ORDER BY RANDOM() LIMIT 5";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy ngẫu nhiên 5 data cho hoạt hình
    @SuppressLint("Range")
    public ArrayList<Phim> getHH() {
        String sql = "SELECT * FROM Phim " +
                "WHERE MaPhanLoai = 'HH'" +
                "ORDER BY RANDOM() LIMIT 5";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy data Phim cho trang chi tiết phim
    @SuppressLint("Range")
    public Phim getPhim(String maPhim){
        String sql = "SELECT MaPhim, TenPhim, " +
                "TenTheLoai, TenXuatXu, TenTinhTrang, MoTa, DienVien, " +
                "AnhPhim, ThoiLuong, NamPhatHanh, DaoDien FROM Phim " +
                "JOIN TheLoai ON Phim.MaTheLoai = TheLoai.MaTheLoai " +
                "JOIN XuatXu ON Phim.MaXuatXu = XuatXu.MaXuatXu " +
                "JOIN TinhTrang ON Phim.MaTinhTrang = TinhTrang.MaTinhTrang " +
                "WHERE MaPhim = ?";
        Phim ds = null;
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{maPhim});
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String tenTheLoai = cursor.getString(cursor.getColumnIndex("TenTheLoai"));
                    String tenXuatXu = cursor.getString(cursor.getColumnIndex("TenXuatXu"));
                    String tenTinhTrang = cursor.getString(cursor.getColumnIndex("TenTinhTrang"));
                    String moTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                    String dienVien = cursor.getString(cursor.getColumnIndex("DienVien"));
                    String daoDien = cursor.getString(cursor.getColumnIndex("DaoDien"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));
                    int thoiLuong = cursor.getInt(cursor.getColumnIndex("ThoiLuong"));
                    int namPhatHanh = cursor.getInt(cursor.getColumnIndex("NamPhatHanh"));

                    // Tạo đối tượng TheLoai từ tên thể loại
                    TheLoai theLoai = new TheLoai();
                    theLoai.setTenTheLoai(tenTheLoai);

                    TinhTrang tinhTrang = new TinhTrang();
                    tinhTrang.setTenTinhTrang(tenTinhTrang);

                    XuatXu xuatXu = new XuatXu();
                    xuatXu.setTenXuatXu(tenXuatXu);

                    // Tạo đối tượng Phim và thêm vào danh sách
                    ds = new Phim(tenPhim, moTa, dienVien, daoDien, anhPhim,
                            thoiLuong, namPhatHanh, theLoai, tinhTrang, xuatXu);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    //Lấy tập phim
    @SuppressLint("Range")
    public ArrayList<TapPhim> getTapPhim(String maPhim) {
        if (maPhim != null) {
            String sql = "Select MaTap, MaPhim, Tap, Video From TapPhim Where MaPhim = ?";
            ArrayList<TapPhim> ds = new ArrayList<>();
            SQLiteDatabase db = csdl.getReadableDatabase();
            Cursor cursor = db.rawQuery(sql, new String[]{maPhim});
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        String ten = cursor.getString(cursor.getColumnIndex("Tap"));
                        String video = cursor.getString(cursor.getColumnIndex("Video"));

                        TapPhim tap = new TapPhim(ten, video);
                        ds.add(tap);
                    } while (cursor.moveToNext());
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            return ds;
        } else {
            // Xử lý trường hợp maPhim là null
            return new ArrayList<>(); // Trả về một danh sách rỗng
        }
    }


    // Lấy data phim bộ Hàn
    @SuppressLint("Range")
    public ArrayList<Phim> getPhimHan() {
        String sql = "SELECT * FROM Phim WHERE MaXuatXu = 'HQ' AND MaPhanLoai = 'PB'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Phim bộ Trung
    @SuppressLint("Range")
    public ArrayList<Phim> getPBTrung() {
        String sql = "SELECT * FROM Phim WHERE MaXuatXu = 'TQ' AND MaPhanLoai = 'PB'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy data phim cổ trang Trung
    @SuppressLint("Range")
    public ArrayList<Phim> getCTTrung() {
        String sql = "SELECT * FROM Phim WHERE MaXuatXu = 'TQ' AND MaTheLoai = 'CT'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy phim Thái
    @SuppressLint("Range")
    public ArrayList<Phim> getPhimThai() {
        String sql = "SELECT * FROM Phim WHERE MaXuatXu = 'TL' AND MaPhanLoai = 'PB'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy phim lẻ
    @SuppressLint("Range")
    public ArrayList<Phim> getPhimLe() {
        String sql = "SELECT * FROM Phim WHERE MaPhanLoai = 'PL'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy hoạt hình
    @SuppressLint("Range")
    public ArrayList<Phim> getHoatHinh() {
        String sql = "SELECT * FROM Phim WHERE MaPhanLoai = 'HH'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy data Phim với ảnh, tên, mã
    @SuppressLint("Range")
    public ArrayList<Phim> getViewphim() {
        String sql = "SELECT * FROM Phim";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String maPhim = cursor.getString(cursor.getColumnIndex("MaPhim"));
                    //String maTheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                    //String maXuatXu = cursor.getString(cursor.getColumnIndex("MaXuatXu"));
                    //String maTinhTrang = cursor.getString(cursor.getColumnIndex("MaTinhTrang"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    //String luotXem = cursor.getString(cursor.getColumnIndex("LuotXem"));
                    //String moTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                    //String dienVien = cursor.getString(cursor.getColumnIndex("DienVien"));
                    //String daoDien = cursor.getString(cursor.getColumnIndex("DaoDien"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));
                    //String maPhanLoai = cursor.getString(cursor.getColumnIndex("MaPhanLoai"));
                    //int thoiLuong = cursor.getInt(cursor.getColumnIndex("ThoiLuong"));
                    //int namPhathanh = cursor.getInt(cursor.getColumnIndex("NamPhatHanh"));


                    // Tạo đối tượng Phim và thêm vào danh sách
                   Phim phim = new Phim(maPhim, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy phim lẻ admin
    @SuppressLint("Range")
    public ArrayList<Phim> getPLe() {
        String sql = "SELECT * FROM Phim WHERE MaPhanLoai = 'PL'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    String matheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                   Phim phim = new Phim(matheLoai, tenPhim,anhPhim);
                   ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }


    // Lấy hoạt hình admin
    @SuppressLint("Range")
    public ArrayList<Phim> getHHinh() {
        String sql = "SELECT * FROM Phim WHERE MaPhanLoai = 'HH'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String matheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(matheLoai, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }

    // Lấy phim bộ admin
    @SuppressLint("Range")
    public ArrayList<Phim> getPBo() {
        String sql = "SELECT * FROM Phim WHERE MaPhanLoai = 'PB'";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String matheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("AnhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(matheLoai, tenPhim,anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }
}
