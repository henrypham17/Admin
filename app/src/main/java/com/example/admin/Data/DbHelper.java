package com.example.admin.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    public DbHelper(@Nullable Context context) {
        super(context, "Phim8.sqlite", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sqlcreate2 = "CREATE TABLE IF NOT EXISTS " +
                "TheLoai(MaTheLoai Text PRIMARY KEY, " +
                "TenTheLoai Text)";

        db.execSQL(sqlcreate2);

        String sqlcreate3 = "CREATE TABLE IF NOT EXISTS " +
                "TinhTrang(MaTinhTrang Text PRIMARY KEY, " +
                "TenTinhTrang Text)";

        db.execSQL(sqlcreate3);

        String sqlcreate4 = "CREATE TABLE IF NOT EXISTS " +
                "XuatXu(MaXuatXu Text PRIMARY KEY, " +
                "TenXuatXu Text)";

        db.execSQL(sqlcreate4);

        String sqlcreate8 = "CREATE TABLE IF NOT EXISTS " +
                "PhanLoai(MaPhanLoai Text PRIMARY KEY, " +
                "TenPhanLoai Text)";

        db.execSQL(sqlcreate8);

        String sqlcreate1 = "CREATE TABLE IF NOT EXISTS " +
                "Phim(MaPhim Text PRIMARY KEY, " +
                "MaTheLoai Text, " +
                "MaXuatXu Text, " +
                "MaTinhTrang Text, " +
                "TenPhim Text, " +
                "LuotXem INTEGER, " +
                "MoTa Text, " +
                "ThoiLuong INTEGER, " +
                "DaoDien Text, " +
                "NamPhatHanh INTEGER, " +
                "DienVien Text, " +
                "MaPhanLoai Text, " +
                "AnhPhim Text, "+
                "FOREIGN KEY (MaTheLoai) REFERENCES TheLoai(MaTheLoai) ON DELETE CASCADE, " +
                "FOREIGN KEY (MaXuatXu) REFERENCES XuatXu(MaXuatXu) ON DELETE CASCADE, " +
                "FOREIGN KEY (MaPhanLoai) REFERENCES PhanLoai(MaPhanLoai) ON DELETE CASCADE, " +
                "FOREIGN KEY (MaTinhTrang) REFERENCES TinhTrang(MaTinhTrang) ON DELETE CASCADE)";

        db.execSQL(sqlcreate1);

        String sqlcreate5 = "CREATE TABLE IF NOT EXISTS " +
                "TapPhim(MaPhim Text , " +
                "MaTap Text, " +
                "Video Text, " +
                "Tap Text, " +
                "FOREIGN KEY (MaPhim) REFERENCES Phim(MaPhim) ON DELETE CASCADE)";

        db.execSQL(sqlcreate5);

        String sqlcreate6 = "CREATE TABLE IF NOT EXISTS " +
                "KhachHang(MaKhachHang INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "HoTen Text, " +
                "Email Text, " +
                "TenDangNhap Text, " +
                "MatKhau Text )";

        db.execSQL(sqlcreate6);

        String sqlcreate7 = "CREATE TABLE IF NOT EXISTS " +
                "LichSuXem(MaKhachHang INTEGER , " +
                "MaPhim Text, " +
                "TenPhim Text, " +
                "TapPhim INTEGER, " +
                "FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang) ON DELETE CASCADE, " +
                "FOREIGN KEY (MaPhim) REFERENCES Phim(MaPhim) ON DELETE CASCADE)";

        db.execSQL(sqlcreate7);

        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('TC','Tình cảm')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('HD','Hành động')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('CT','Cổ trang')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('VT','Viễn tưởng')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('PHD','Phim hiện đại')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('TX','Thanh xuân')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('HH','Hài')");
        db.execSQL("INSERT INTO TheLoai(MaTheLoai,TenTheLoai) VALUES('PL','Phiêu lưu')");

        db.execSQL("INSERT INTO TinhTrang(MaTinhTrang,TenTinhTrang) VALUES('DF','Đã full')");
        db.execSQL("INSERT INTO TinhTrang(MaTinhTrang,TenTinhTrang) VALUES('DCN','Đang cập nhật')");
        db.execSQL("INSERT INTO TinhTrang(MaTinhTrang,TenTinhTrang) VALUES('SRM','Sắp ra mắt')");

        db.execSQL("INSERT INTO XuatXu(MaXuatXu,TenXuatXu) VALUES('US','Hoa Kỳ')");
        db.execSQL("INSERT INTO XuatXu(MaXuatXu,TenXuatXu) VALUES('TQ','Trung Quốc')");
        db.execSQL("INSERT INTO XuatXu(MaXuatXu,TenXuatXu) VALUES('HQ','Hàn Quốc')");
        db.execSQL("INSERT INTO XuatXu(MaXuatXu,TenXuatXu) VALUES('TL','Thái Lan')");
        db.execSQL("INSERT INTO XuatXu(MaXuatXu,TenXuatXu) VALUES('NB','Nhật bản')");

        db.execSQL("INSERT INTO PhanLoai(MaPhanLoai,TenPhanLoai) VALUES('PB','Phim bộ')");
        db.execSQL("INSERT INTO PhanLoai(MaPhanLoai,TenPhanLoai) VALUES('PL','Phim lẻ')");
        db.execSQL("INSERT INTO PhanLoai(MaPhanLoai,TenPhanLoai) VALUES('HH','Hoạt hình')");

        // data khách hàng
        db.execSQL("INSERT INTO KhachHang(MaKhachHang, HoTen, Email, TenDangNhap, MatKhau) " +
                "VALUES(1, 'Nguyễn Thùy Dương', 'nguyenthuyduong@gmail.com', 'duongnt', 'Duong2k3')");
        db.execSQL("INSERT INTO KhachHang(MaKhachHang, HoTen, Email, TenDangNhap, MatKhau) " +
                "VALUES(2, 'Nguyễn Gia Phú', 'phung@gmail.com', 'phung', 'Phu2k3')");
        db.execSQL("INSERT INTO KhachHang(MaKhachHang, HoTen, Email, TenDangNhap, MatKhau) " +
                "VALUES(3, 'Phạm Hữu Quang', 'quangph@gmail.com', 'quangph', 'Quang2k3')");
        db.execSQL("INSERT INTO KhachHang(MaKhachHang, HoTen, Email, TenDangNhap, MatKhau) " +
                "VALUES(4, 'Hoàng Dương', 'hduong@gmail.com', 'hduong', 'Duong2k3')");
        db.execSQL("INSERT INTO KhachHang(MaKhachHang, HoTen, Email, TenDangNhap, MatKhau) " +
                "VALUES(5, 'Phạm Minh Hiếu', 'hieupm@gmail.com', 'hieupm', 'Hieu2k3')");

        //data phim Hàn
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P61','TC','HQ','DF','Trái tim mùa thu',304041,'Chuyện phim là câu chuyện tình ngọt ngào nhưng cũng thấm đẫm nước mắt của Joon Suh (Song Seung Hun) và Eun Suh (Song Hye Kyo)'," +
                "16,'Yoon Seok-ho',2000,'Song Seung Hun ,Song Hye Kyo','PB','https://static2.vieon.vn/vieplay-image/poster_v4/2022/03/15/9qpv9jn8_660x946-traitimmuathu.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P62','TX','HQ','DF','Why her ?',304041,'Một nữ luật sư lạnh lùng với trái tim sắc đá chỉ một lòng theo đuổi thành công'," +
                "14,'Oh Soo Jae',2022,'Seo Hyun Jin, Hwang In Yeop, Heo Joon Ho,Bae In Hyuk','PB','https://static2.vieon.vn/vieplay-image/poster_v4/2022/06/27/5eoyt01w_660x946-taisaolailaohsoojae9f0efb2b5269cad69db9d2343a02e27c.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P63','PHD','HQ','DF','Thiên Nga',304041,'Phim kể về Lee Rael, người đã âm thầm chuẩn bị trong 13 năm để trả thù cho cái chết của cha mình. Mục tiêu của cô là Kang Yoon Gyeom, người điều hành tập đoàn LY.'," +
                "14,'Park Bong-seop',2021,'Seo Ye-ji, Park Byung-eun, Yoo Sun, Lee Sang-yeob','PB','https://bizweb.dktcdn.net/100/438/408/files/phim-han-quoc-hay-yody-vn-7.jpg?v=1689219637986')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P64','TC','HQ','DF','Thế giới hôn nhân',304041,'Phim xoay quanh cuộc sống của bác sĩ Ji Sun Woo (do chị đại Kim Hee Ae đóng) sau khi li hôn.'," +
                "16,'Mo Wan-il',2022,'Kim Hee-ae, Park Hae-joon, Han So-hee','PB','https://admin.vov.gov.vn/UploadFolder/KhoTin/Images/UploadFolder/VOVVN/Images/w800/uploaded/9eqrbt2uv7o/2020_04_23/2_15867684724561311053373_sony.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P65','HD','HQ','DF','Tầng lớp Itaewon',304041,'Phim xoay quanh câu chuyện về hành trình trở thành một doanh nhân thành đạt của Park Sae Ro Yi'," +
                "16,'Kim Sung-yoon',2021,'Park Seo-joon,Kim Da-mi, Kwon Nara','PB','https://imagev3.vietnamplus.vn/w1000/Uploaded/2024/hotnnz/2020_03_10/itaewonclass2.jpg.webp')");

        // data Tập phim Hàn
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1711861431/Phim/Trai_tim_mua_dong/1_1_sekec2.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1711882695/Phim/Trai_tim_mua_dong/1_2_nsmkxt.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1711892366/Phim/Trai_tim_mua_dong/1_3_b5mjxw.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1711898956/Phim/Trai_tim_mua_dong/1_4_jujjxx.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712133735/Phim/Trai_tim_mua_dong/1_5_pxy8fg.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1711884510/Phim/Trai_tim_mua_dong/1_6_sxvkfa.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712135115/Phim/Trai_tim_mua_dong/1_7_jmj4op.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712138039/Phim/Trai_tim_mua_dong/1_8_cmx5sp.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712138343/Phim/Trai_tim_mua_dong/1_9_wepxvs.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712139325/Phim/Trai_tim_mua_dong/1_10_i9hlpl.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712139717/Phim/Trai_tim_mua_dong/1_11_i4buiv.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712157845/Phim/Trai_tim_mua_dong/1_12_wrlyj3.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712158061/Phim/Trai_tim_mua_dong/1_13_hbosx7.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712159260/Phim/Trai_tim_mua_dong/1_14_n6j6hb.mp4','Tập 14')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T15','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712159666/Phim/Trai_tim_mua_dong/1_15_ugnak1.mp4','Tập 15')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P61','T16','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712160269/Phim/Trai_tim_mua_dong/1_16_vfohpc.mp4','Tập 16')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712160824/Phim/Why%20her/2_1_vzatub.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712161597/Phim/Why%20her/2_2_o8prnb.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213333/Phim/Why%20her/2_3_r9ehr9.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213498/Phim/Why%20her/2_4_vrafve.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213524/Phim/Why%20her/2_5_p1i9yx.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213564/Phim/Why%20her/2_6_w6odie.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213590/Phim/Why%20her/2_7_pbmi4y.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213616/Phim/Why%20her/2_8_m8ybtb.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213643/Phim/Why%20her/2_9_dpdsy9.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213670/Phim/Why%20her/2_10_wj3lkd.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213697/Phim/Why%20her/2_11_jgmwn5.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213726/Phim/Why%20her/2_12_njcrjw.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213752/Phim/Why%20her/2_13_h17rtm.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P62','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213780/Phim/Why%20her/2_14_yzt8zs.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213855/Phim/Thien_nga_bong_dem/3_1_carwlt.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213886/Phim/Thien_nga_bong_dem/3_2_bdnoqm.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213915/Phim/Thien_nga_bong_dem/3_3_pytiho.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213944/Phim/Thien_nga_bong_dem/3_4_uad1pe.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712213973/Phim/Thien_nga_bong_dem/3_5_sufkf3.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214002/Phim/Thien_nga_bong_dem/3_6_hqwoa9.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214037/Phim/Thien_nga_bong_dem/3_7_ilcbpk.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214066/Phim/Thien_nga_bong_dem/3_8_d8hgcz.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214092/Phim/Thien_nga_bong_dem/3_9_mzijnr.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214120/Phim/Thien_nga_bong_dem/3_10_g9zbuz.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214149/Phim/Thien_nga_bong_dem/3_11_lva6sm.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214167/Phim/Thien_nga_bong_dem/3_12_tag7f6.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214180/Phim/Thien_nga_bong_dem/3_13_vblgvb.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P63','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214213/Phim/Thien_nga_bong_dem/3_14_xufiqe.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214267/Phim/The_gioi_hon_nhan/4_1_jf6uud.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214298/Phim/The_gioi_hon_nhan/4_2_goqn42.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214298/Phim/The_gioi_hon_nhan/4_3_qtefq4.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214296/Phim/The_gioi_hon_nhan/4_4_n3m385.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214319/Phim/The_gioi_hon_nhan/4_5_r9mn8f.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214305/Phim/The_gioi_hon_nhan/4_6_xr06t4.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214923/Phim/The_gioi_hon_nhan/4_7_lvhn5y.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214946/Phim/The_gioi_hon_nhan/4_8_bq7epg.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712214976/Phim/The_gioi_hon_nhan/4_9_stfdqw.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215001/Phim/The_gioi_hon_nhan/4_10_mvy9o3.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215029/Phim/The_gioi_hon_nhan/4_11_eex96g.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215052/Phim/The_gioi_hon_nhan/4_12_wtevwr.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215079/Phim/The_gioi_hon_nhan/4_13_sddrdb.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215111/Phim/The_gioi_hon_nhan/4_14_wfzdbo.mp4','Tập 14')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T15','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215170/Phim/The_gioi_hon_nhan/4_15_sj62w7.mp4','Tập 15')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P64','T16','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215192/Phim/The_gioi_hon_nhan/4_16_ocxptc.mp4','Tập 16')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215217/Phim/Tang_lop_itewon/5_1_zfw6vn.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215237/Phim/Tang_lop_itewon/5_2_stmwzu.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215259/Phim/Tang_lop_itewon/5_3_bblxwm.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215280/Phim/Tang_lop_itewon/5_4_igmf29.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215339/Phim/Tang_lop_itewon/5_5_enrazy.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215359/Phim/Tang_lop_itewon/5_6_klmpb2.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215379/Phim/Tang_lop_itewon/5_7_c2tmlf.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215403/Phim/Tang_lop_itewon/5_8_zxjqrz.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215451/Phim/Tang_lop_itewon/5_9_xzjbhx.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215858/Phim/Tang_lop_itewon/5_10_hzn6gb.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712215940/Phim/Tang_lop_itewon/5_11_xzvh11.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216009/Phim/Tang_lop_itewon/5_12_aguztq.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216094/Phim/Tang_lop_itewon/5_13_aaqcce.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216178/Phim/Tang_lop_itewon/5_14_yw2o3b.mp4','Tập 14')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T15','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216233/Phim/Tang_lop_itewon/5_15_uxbq5j.mp4','Tập 15')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P65','T16','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216297/Phim/Tang_lop_itewon/5_16_ew2sbf.mp4','Tập 16')");

        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P81','TC','TQ','DF','Em Biết Em Yêu Anh',304041,'Bộ phim kể về tình yêu giữa chàng bác sĩ thú y Zhao Jin " +
                "và cô nàng nghệ nhân cắm hoa Xu Nuo'," +
                "14,'Lữ Duật Lai',2024,'Tôn Di, Trương Vãn Ý','PB','https://bloganchoi.com/wp-content/uploads/2023/12/review-phim-toi-biet-toi-yeu-em-7.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P82','CT','TQ','DCN','Hoa Gian Lệnh',304041,'Hoa Gian Lệnh là câu chuyện kịch tính về mối tình giữa đôi phu thê Phan Việt và Dương Thái Vi. " +
                "Trong đêm tân hôn, tân nương Dương Thái Vi bị sát hại và ngay sau đó tái sinh với danh tính mới Thượng Quan Chỉ. Cô quyết tâm điều tra vụ án để tìm ra hung " +
                "thủ đằng sau cái chết của mình, bắt đầu từ kẻ khả nghi nhất: Phan Việt.'," +
                "14,'Chung Thanh',2024,'Cúc Tịnh Y, Lưu Học Nghĩa','PB','https://i.mydramalist.com/WPdgPX_4f.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P83','CT','TQ','DF','Liên Hoa Lâu',304041,'Lý Tương Di, môn chủ Tứ Cố Môn nổi tiếng trong võ lâm, từ sau khi bị trọng thương trong một trận chiến lớn " +
                "đã lui về làm một lang trung dưới tên Lý Liên Hoa. Số phận đưa đẩy cho Liên Hoa gặp gỡ người bạn mới Phương Đa Bệnh và kẻ thù cũ Địch Phi Thanh. Trải qua hành trình " +
                "cùng sát cánh phá những vụ án hiểm hóc, giữa ba người họ đã dần dần hình thành một tình bạn sâu sắc.'," +
                "14,'Quách Hổ',2023,'Thành Nghị, Tăng Thuấn Hi','PB','https://i.pinimg.com/736x/1b/95/1a/1b951a03d9dae2664cb684deaca871db.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P84','CT','TQ','DF','Trường Nguyệt Tẫn Minh',304041,'Vì muốn cứu chúng sinh khỏi sự thống trị tàn bạo của Đạm Đài Tẫn, Lê Tô Tô quay trở lại thời điểm 500 năm " +
                "trước và hóa thân thành Diệp Tịch Vụ để ngăn cản hắn trở thành ma thần. Không ngờ số phận trêu đùa, Đạm Đài Tẫn lại chính là phu quân trên danh nghĩa của Diệp Tịch Vụ. " +
                "Từ đây, mối tình bi thương kéo dài hàng trăm năm của họ bắt đầu, làmthay đổi vận mệnh của Đạm Đài Tẫn và cả tam giới.'," +
                "14,'Cúc Giác Lượng',2023,'Bạch Lộc, La Vân Hi','PB','https://wiki.d-addicts.com/images/thumb/d/dc/Till_the_End_of_the_Moon.jpg/600px-Till_the_End_of_the_Moon.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P85','TC','TQ','DF','Chiếc bật lửa và váy công chúa',304041,'Kể về mối tình giữa thủ khoa khối tự nhiên của tỉnh Lý Tuân và cô nàngcán sự môn Chu Vận, trải qua" +
                " biết bao sóng gió và biến cố khitrưởng thành thì cuối cùng hai người đã quay trở về với nhau.'," +
                "14,'Lưu Tuấn Kiệt',2022,'Trần Phi Vũ, Trương Tịnh Nghi','PB','https://static2.vieon.vn/vieplay-image/poster_v4/2022/10/21/jd2x8trd_660x946-chiecbatluavavaycongchua.png')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216844/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_1_t6putk.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712216979/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_2_hw6d8a.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217002/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_3_v88mvj.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217040/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_4_vafelh.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217071/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_5_z3sgpn.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217173/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_6_hg5jzr.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217200/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_7_ls3prm.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217225/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_8_nmgfux.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217251/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_9_adf7ly.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217279/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_10_rki6rh.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217306/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_11_drazbb.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217334/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_12_gn3lvz.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217363/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_13_bcwjee.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P81','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217393/Phim/Em%20bi%E1%BA%BFt%20em%20y%C3%AAu%20anh/6_14_vbsjvy.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T1','https://vod04-cdn.fptplay.net/POVOD/encoded/2024/03/23/inblossom-2024-cn-multias-001-1711177053/media-video-avc1-1.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T2','https://vod04-cdn.fptplay.net/POVOD/encoded/2024/03/25/inblossom-2024-cn-multias-002-1711373956/media-video-avc1-2.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T3','https://vod06-cdn.fptplay.net/POVOD/encoded/2024/03/25/inblossom-2024-cn-multias-003-1711374258/media-video-avc1-3.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T4','https://vod03-cdn.fptplay.net/POVOD/encoded/2024/03/26/inblossom-2024-cn-multias-004-1711417534/media-video-avc1-3.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T5','https://vod04-cdn.fptplay.net/POVOD/encoded/2024/03/26/inblossom-2024-cn-multias-005-1711469487/media-video-avc1-3.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712222022/Phim/Hoa_gian_lenh/7_1_wztdkq.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712222286/Phim/Hoa_gian_lenh/7_2_ndgodm.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712222712/Phim/Hoa_gian_lenh/7_3_lyugin.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712223144/Phim/Hoa_gian_lenh/7_4_w880sa.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712229896/Phim/Hoa_gian_lenh/7_5_yr8ghk.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712230044/Phim/Hoa_gian_lenh/7-6_rrjmwi.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712230180/Phim/Hoa_gian_lenh/7_7_awbjvn.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712230311/Phim/Hoa_gian_lenh/7-8_nqdfoq.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P82','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712230399/Phim/Hoa_gian_lenh/7_9_f0re2x.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218821/Phim/Lien_hoa_lau/8_1_k0quti.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218853/Phim/Lien_hoa_lau/8_2_axtg56.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218886/Phim/Lien_hoa_lau/8_3_tuyvdy.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218916/Phim/Lien_hoa_lau/8_4_ii8xxp.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218951/Phim/Lien_hoa_lau/8_5_f3fc5r.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218986/Phim/Lien_hoa_lau/8_6_u7lqh2.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712219017/Phim/Lien_hoa_lau/8_7_anezrk.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712219050/Phim/Lien_hoa_lau/8_8_uil5cl.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712219082/Phim/Lien_hoa_lau/8_9_qgy47i.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712220400/Phim/Lien_hoa_lau/8_10_ub6bmo.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712220700/Phim/Lien_hoa_lau/8_11_bha03i.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712220986/Phim/Lien_hoa_lau/8_12_pb5uey.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712221334/Phim/Lien_hoa_lau/8_13_mrqj38.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P83','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712221570/Phim/Lien_hoa_lau/8_14_dgclw7.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218313/Phim/Truong_nguyet_tan_minh/9_1_p9xxgv.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218349/Phim/Truong_nguyet_tan_minh/9_2_x9wmef.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218403/Phim/Truong_nguyet_tan_minh/9_3_xjfgh6.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218441/Phim/Truong_nguyet_tan_minh/9_4_cr5z8x.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218479/Phim/Truong_nguyet_tan_minh/9_5_wxmwou.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218517/Phim/Truong_nguyet_tan_minh/9_6_yopigf.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218559/Phim/Truong_nguyet_tan_minh/9_7_suwmxt.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218588/Phim/Truong_nguyet_tan_minh/9_8_jmpkvn.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218620/Phim/Truong_nguyet_tan_minh/9_9_knr9bc.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218658/Phim/Truong_nguyet_tan_minh/9_10_rjlyc0.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218689/Phim/Truong_nguyet_tan_minh/9_11_f3rkzb.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218722/Phim/Truong_nguyet_tan_minh/9_12_crvx46.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218753/Phim/Truong_nguyet_tan_minh/9_13_y65xxk.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P84','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218781/Phim/Truong_nguyet_tan_minh/9_14_cm7pq5.mp4','Tập 14')");

        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T1','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217458/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_1_zdozqk.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T2','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217510/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_2_sbkadv.mp4','Tập 2')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T3','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217551/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_3_ejlhqr.mp4','Tập 3')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T4','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217604/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_4_tqygkq.mp4','Tập 4')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T5','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217683/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_5_pmecni.mp4','Tập 5')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T6','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217834/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_6_lpm1ya.mp4','Tập 6')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T7','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217917/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_7_lf0xlo.mp4','Tập 7')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T8','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712217943/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_8_aobq72.mp4','Tập 8')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T9','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218003/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_9_piggvu.mp4','Tập 9')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T10','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218033/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_10_vsdjr2.mp4','Tập 10')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T11','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218061/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_11_jovcyt.mp4','Tập 11')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T12','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218099/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_12_itb4ht.mp4','Tập 12')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T13','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218193/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_13_vf0765.mp4','Tập 13')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P85','T14','https://res.cloudinary.com/dkdv1yrvn/video/upload/v1712218234/Phim/Chi%E1%BA%BFc%20b%E1%BA%ADt%20l%E1%BB%ADa%20v%C3%A0%20v%C3%A1y%20c%C3%B4ng%20ch%C3%BAa/10_14_iz2ht3.mp4','Tập 14')");


        // phim hoạt hình
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P20','HH','US','DF','Kung Fu Panda 4',10000,'Sau khi Po được chọn trở thành Thủ lĩnh tinh thần của Thung lũng Hòa bình, anh cần tìm và huấn luyện một Chiến binh " +
                "Rồng mới, trong khi một mụ phù thủy độc ác lên kế hoạch triệu hồi lại tất cả những kẻ phản diện bậc thầy mà Po đã đánh bại về cõi linh hồn.'," +
                "1,'Mike Mitchell',2024,'Jack đen','HH','https://preview.redd.it/i-thought-id-try-to-modify-a-probable-kung-fu-panda-4-v0-1ptxcb2rjw7c1.jpeg?auto=webp&s=ec725f3ba8c26a65b427177c37c8d4d16308fb27')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P21','HH','US','DF','Nhím Sonic 2',10000,'Háo hức trở thành anh hùng, Sonic bắt tay với bạn mới Tails để ngăn tiến sĩ Robotnik và Knuckles tộc Echidna có được viên ngọc lục bảo toàn năng'," +
                "1,'Jeff Fowler',2024,'Cúc Tịnh Y, Lưu Học Nghĩa','HH','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/3/image/1800x/71252117777b696995f01934522c402d/n/h/nh_m_sonic_2_poster_1_.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P22','HH','US','DF','Hầu Vương',10000,'Một chú khỉ chuyên dùng gậy đồng hành cùng một cô bé trên hành trình tìm kiếm sự bất tử, chiến đấu với quỷ, rồng, thần cũng như chính bản ngã của chú.'," +
                "1,'Anthony Stacchi',2023,'Jimmy O.Yang','HH','https://hhtq.xyz/assets/upload/hau-vuong_250x350.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P23','HH','US','DF','Nimona',10000,'Bị đổ oan tội ác bi thảm, hiệp sĩ nọ bắt tay với một thiếu nữ kiên cường, có khả năng thay đổi hình dạng để minh oan. Nhưng sẽ ra sao nếu cô là con quái vật anh thề sẽ tiêu diệt?'," +
                "1,'Troy Quane, Nick Bruno',2023,'Eugene Lee Yang','HH','https://vfx-animation.vn/wp-content/uploads/2023/06/1-hoat-hinh-trong-diem-cua-netflix.png')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P24','HH','US','DF','The boy and the heron',10000,'Sau cái chết của mẹ và cuộc tái hôn của cha mình, một cậu bé cứng đầu tên Mahito dấn thân vào một thế giới mộng mơ được chia sẻ bởi cả người sống và người chết.'," +
                "1,'Miyazaki Hayao',2023,'Robert Pattinson','HH','https://www.vfx-animation.vn/wp-content/uploads/2024/02/MV5BNmI2MzJkYzYtM2Y2My00NmJmLTgxZDAtODAwNjBmM2RlZjRhXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P25','HH','US','DF','My neighbor Totoro',10000,'Những ngày cùng cha nghỉ hè tại miền quê thuộc đất nước Nhật Bản, hai chị em bé nhỏ đã kết bạn với những sinh vật huyền bí sống trong khu rừng gần đó.'," +
                "1,'Miyazaki Hayao',1988,'Dakota Fanning','HH','https://sachhay24h.com/uploads/images/hang-xom-toi-la-totoro-my-neighbor-totoro-0.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P26','TC','US','DF','Coco',3600,'Câu chuyện trong bộ phim hoạt hình Coco xoay quanh một cậu bé tên Miguel Rivera sống ở thị trấn Santa Cecilia México. Miguel từ lâu đã đam mê âm nhạc và hâm mộ một huyền thoại âm nhạc là Ernesto de la Cruz. Tuy nhiên gia đình cậu không chấp nhận đam mê của anh vì một" +
                " sự việc lịch sử – Miguel không được phép làm nhạc vì ông cố cha của mình từng là nhạc sĩ nhưng rời bỏ gia đình để theo đuổi sự nổi tiếng. Vì vậy Miguel bị cấm sử dụng nhạc trong gia đình.\n" +
                "Vào lễ hội Ngày Đám Ma Miguel vô tình xuyên qua cánh cửa thế giới ngầm và bị giữ lại bên kia. Ở đó anh gặp gỡ các người anh hùng đã mất và tổ tông của mình. Họ chỉ ra cho Miguel biết rằng anh cần lấy lấy sự chấp nhận của gia đình trong nhất thời điểm cuộc đời họ ngừng lại để có thể trở về thế giới thật.'," +
                "1,'Adrian Molina',2017,'Keanu Reeves','HH','https://image.tmdb.org/t/p/original/gGEsBPAijhVUFoiNpgZXqRVWJt2.jpg')");


        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P20','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415331/KUNG_FU_PANDA_4___Official_Trailer_yyhd1x.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P21','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415468/Sonic_the_Hedgehog_2_2022_-__Final_Trailer__-_Paramount_Pictures_kjq531.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P22','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415583/Ha%CC%82%CC%80u_vu%CC%9Bo%CC%9Bng___Trailer_chi%CC%81nh_thu%CC%9B%CC%81c___Netflix_zhjmy2.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P23','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415654/Nimona___Official_Trailer___Netflix_hmudfy.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P24','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415754/THE_BOY_AND_THE_HERON___Official_English_Trailer_akvkug.mp4','Tập 1')");
        db.execSQL("INSERT INTO TapPhim(MaPhim,MaTap,Video,Tap) " +
                "VALUES('P25','T1','https://res.cloudinary.com/dne04jobr/video/upload/v1712415816/My_Neighbour_Neighbor_Totoro_Trailer_English_i8oqbw.mp4','Tập 1')");


        // phim lẻ
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P41','HD','US','DF','JohnWick',3600,'Khi con trai của một tay xã hội đen ăn trộm xe ô tô và giết chú chó của anh, cựu sát thủ không biết sợ John Wick đối đầu với toàn bộ băng đảng có liên quan để trả thù.'," +
                "1,'Chad Stahelski',2014,'Keanu Reeves','PL','https://image.tmdb.org/t/p/original/nCzzQKGijVzfGFg42id7uDLOjY5.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P43','TC','HQ','DF','Love Reset',3600,'Cặp vợ chồng trẻ No Jung Yeol (Kang Ha-neul) và Hong Na Ra (Jung So-min) từ cuộc sống hôn nhân màu hồng dần “hiện nguyên hình” trở thành cái gai trong mắt đối phương với vô vàn thói hư, tật xấu. Không thể đi đến tiếng nói chung, Jung Yeol và Na Ra quyết định " +
                "ra toà ly dị. Tuy nhiên, họ phải chờ 30 ngày cho đến khi mọi thủ tục chính thức được hoàn tất. Trong khoảng thời gian này, một vụ tai nạn xảy ra khiến cả hai mất đi ký ức và không nhớ người kia là ai. 30 ngày chờ đợi để được “đường ai nấy đi” nhưng nhiều tình huống trớ trêu khiến cả hai bắt đầu nảy sinh tình " +
                "cảm trở lại. Liệu khi nhớ ra mọi thứ, họ vẫn sẽ ký tên vào tờ giấy ly hôn?'," +
                "1,'Nam Dae-jung',2023,'Kang Ha-neul','PL','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/l/r/lr-main-poster-printing.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P44','TC','TQ','DF','Em của thời niên thiếu',3600,'Em Của Thời Niên Thiếu kể về một sự cố ngoài ý muốn xảy ra trong ngôi trường trung học vào đêm trước ngày thi đại học đã làm thay đổi số mệnh của hai con người. Trần Niệm là một cô gái có tính cách hướng nội, là một học sinh ưu tú trong trường. Cô luôn cố gắng " +
                "nỗ lực học tập với mong muốn thi đỗ vào một trường đại học tốt.Nhưng tai nạn ngã lầu của một bạn học sinh cùng lớp xảy ra đã gây ra hàng loạt những sự việc phức tạp sau đó.'," +
                "1,'Tăng Quốc Cường',2019,'Châu Đông Vũ','PL','https://i.mpcdn.top/poster/em-cua-thoi-nien-thieu-7500.jpg?1576409524')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P45','HD','HQ','DF','The call - Cuộc gọi',3600,'Chuyện phim bắt đầu khi Seo‑yeon (do Park Shin‑hye thủ vai) trên đường về thăm căn biệt thự của gia đình mình vùng ngoại ô thì bị mất điện thoại, cô phải dùng điện thoại bàn ở nhà để liên lạc. Tình cờ, Seo‑yeon nhận được một cú điện thoại cầu cứu từ một người lạ" +
                " mặt. Tại đây, cô ta phát hiện ra cầu thang bí mật dẫn xuống một căn hầm ngay trong nhà mình, đồng thời, đây là nơi từng xảy ra một vụ án mạng kinh hoàng vào 20 năm trước.'," +
                "1,'Lee Chung-hyun',2020,'Park Shin-hye','PL','https://tintuc-divineshop.cdn.vccloud.vn/wp-content/uploads/2022/03/review-va-giai-thich-phim-the-call-2020-cuoc-goi-ve-qua-khu_623803aa5f554.jpeg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P46','VT','US','DF','Terminator 2: Judgment Day',3600,'Kẻ Hủy Diệt 2: Ngày Phán Xét Terminator 2: Judgment Day 1991 Full HD Vietsub Thuyết Minh Kẻ hủy diệt 2: Ngày phán xét, Kẻ hủy diệt 2: Ngày phán xét 1991 Sau khi thất bại ở phần 1, Skynet đã cử một người máy khác mạnh hơn để tiêu diệt Sarah Connor và đứa con của " +
                "cô, John Connor. Tuy nhiên, lần này hai mẹ con được bảo vệ bởi chính Kẻ hủy diệt trong phần 1, bị quân kháng chiến sửa chữa và gửi về từ tương lai.'," +
                "1,' James Cameron',1991,' Arnold Schwarzenegger Edward Furlong','PL','https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg')");


        // phim thái
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P1','TC','TL','DCN','Oan Gia Phòng Cấp Cứu',3600,'Được làm lại từ phim Hàn cùng tên, Oan Gia Phòng Cấp Cứu (Bản Thái) xoay quanh chuyện tình lẫn chuyện nghề của Pun và Pan. Họ từng yêu nhau, cưới nhau nhưng " +
                "rồi lại bỏ nhau vì nhiều mâu thuẫn trong hôn nhân. Vài năm sau, họ gặp lại với tư cách đồng nghiệp khi cùng về làm tại khoa cấp cứu ở một bệnh viện. Giờ đã trưởng thành hơn xưa, liệu họ có thể tháo gỡ những khúc mắc cũ để hợp tác tốt trong công việc và thậm chí là yêu lại từ đầu?'," +
                "18,'Rattapong Pinyosopon',2024,'Bua Nalinthip Sakulongumpa, Sean Jindachot','PB','https://images.fptplay.net/media/OTT/VOD/2024/03/08/oan-gia-phong-cap-cuu-ban-thai-fpt-play-1709867105139_Landscape.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P2','CT','TL','DF','Ngược dòng thời gian để yêu anh',3600,'Ngược dòng thời gian để yêu anh\" xoay quanh câu chuyện về cô nàng sinh viên khảo cổ Kadesurang (Bella Ranee) thông minh, vô tình xuyên không về quá khứ và nhập vào thân xác của tiểu thư Karakade. Karekade nổi " +
                "tiếng là cô nàng đanh đá, xấu tính, bị chính hôn phu Muen Suntorndewa (Pope Thanawat) căm ghét. Với sự hiếu kỳ của một cô gái thuộc thế kỷ 21, Kadesurang trong thân xác mới hành động một cách khó hiểu khiến những người xung quanh bất ngờ. Sự lương thiện, chất phác của cô cũng thành công giúp Karakade thoát" +
                " mác ác độc và cảm hóa được trái tim lạnh lùng của vị hôn phu Muen. Bất chấp sự khác biệt về thời gian, cả hai tạo ra một mối tình vô cùng lãng mạn. '," +
                "40,'Pawat Panangkasri',2018,'Ranee Campen','PB','https://static2.vieon.vn/vieplay-image/carousel_web_v4/2022/10/10/do1wnrag_1920x1080-nguocdongthoigian.png')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P3','TC','TL','DF','Sinaeha Saree ',3600,'Saree Yêu Dấu (Sinaeha Saree) vietsub kể về Nuannuerkaew Jaz, một cô gái xinh đẹp chưa bao giờ nghĩ đến việc đến Ấn Độ, nhưng bây giờ cô phải bay đến nơi đây vì em gái Nilapat, người sẽ kết hôn với Chaithat, hoàng tử của thành phố " +
                "nhỏ Muntra Putra ở Ấn Độ. Thế nhưng, đối với Sasiprapai, mẹ của Chaithat, lại không chấp nhận con gái xứ Thái làm Vương Hậu tương lai nên đã âm thầm sắp đặt Savitree cho Chaithat, người sẵn sàng phá hoại đám cưới của cả hai. Đồng thời, sự xuất hiện của Giris, anh trai hoàng tử " +
                "Chaithat, đã khiến Nuannuerkaew Jaz phải lòng ngay từ cái nhìn đầu tiên. Nuannuerkaew Jaz sẽ phải làm gì tiếp theo?'," +
                "28,'Jariwat Uppakharnchaiyaphat',2022,'Baifern Pimchanok Luevisadpaibul • Sean Jindachot • Richy Oranate ','PB','https://cms.dmpcdn.com/movie/2022/09/07/e87712d0-2e81-11ed-9d17-151d764e0cf5_webp_original.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P4','HH','TL','DF','46 Ngày - San Bằng Đám Cưới',3600,'46 Ngày - San Bằng Đám Cưới là câu chuyện kể về chỉ còn 46 ngày nữa là crush của cô bạn thân sẽ kết hôn. Ying Ying phải lập ra kế hoạch để giúp Noina giành lấy người tình trong mộng. Nhưng dường như kế hoạch đã có lỗ hổng, khiến cho Ying Ying ngã bổ nhào vào “tình yêu”.'," +
                "18,'Koo Ekkasit Trakulkasemsuk',2021,'Baifern Pimchanok Luevisadpaibul, Non Chanon Santinatornkul','PB','https://upload.wikimedia.org/wikipedia/vi/f/fd/46days.jpg')");
        db.execSQL("INSERT INTO Phim(MaPhim,MaTheLoai,MaXuatXu,MaTinhTrang,TenPhim,LuotXem,MoTa,ThoiLuong,DaoDien,NamPhatHanh,DienVien,MaPhanLoai,AnhPhim) " +
                "VALUES('P5','PHD','TL','DF','Chiếc Lá Cuốn Bay',3600,'Sau thành công lớn của dự án phim điện ảnh “Mối tình đầu” đóng cặp cùng mỹ nam Mario, nữ diễn viên Baifern Pimchanok một bước vụt sáng thành sao lớn của điện ảnh Thái Lan, cô liên tiếp góp mặt trong nhiều tác phẩm đáng chú ý" +
                " khác, không chỉ có sắc đẹp mà diễn xuất của cô luôn được đánh giá cao, tuy nhiên bởi những scandal mà sự nghiệp sau đó dần đi xuống. Thế nhưng, cũng chính thực lực đã giúp cô vực dậy để rồi thời gian gần đây liên tiếp có những vai diễn xuất sắc mà đáng nói nhất chính là bộ phim Chiếc Lá Cuốn Bay vốn được chuyển thể từ tiểu thuyết cùng tên.'," +
                "21,'Koo Ekkasit Trakulkasemsuk',2019,'Aun Witaya, Baifern Pimchanok, Gypsy Keerati, Push Puttichai','PB','https://media.saodaily.com/resize/1200x627/storage/files/quynhtrang/2022/10/27/chieclacuonbay1-111448.jpg')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addPhim(Phim contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("MaTheLoai",contact.getMaTheLoai());
        values.put("MaXuatXu",contact.getMaXuatXu());
        values.put("MaTinhTrang",contact.getMaTinhTrang());
        values.put("TenPhim",contact.getTenPhim());
        values.put("LuotXem",contact.getLuotXem());
        values.put("MoTa",contact.getMoTa());
        values.put("DaoDien",contact.getDaoDien());
        values.put("DienVien",contact.getDienVien());
        values.put("AnhPhim",contact.getAnhPhim());
        values.put("ThoiLuong",contact.getThoiLuong());
        values.put("MaPhanLoai",contact.getMaPhanLoai());
        values.put("NamPhatHanh",contact.getNamPhatHanh());
        db.insert("Phim",null,values);
        db.close();
    }
    public void updatePhim(String maphim,Phim contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("MaTheLoai",contact.getMaTheLoai());
        values.put("MaXuatXu",contact.getMaXuatXu());
        values.put("MaTinhTrang",contact.getMaTinhTrang());
        values.put("TenPhim",contact.getTenPhim());
        values.put("LuotXem",contact.getLuotXem());
        values.put("MoTa",contact.getMoTa());
        values.put("DaoDien",contact.getDaoDien());
        values.put("DienVien",contact.getDienVien());
        values.put("AnhPhim",contact.getAnhPhim());
        values.put("ThoiLuong",contact.getThoiLuong());
        values.put("MaPhanLoai",contact.getMaPhanLoai());
        values.put("NamPhatHanh",contact.getNamPhatHanh());
        db.update("Phim",values,"MaPhim" + "=?",
                new String[]{maphim});
        db.close();
    }
    public void deletePhim(String maphim){
        SQLiteDatabase db = getWritableDatabase();

        db.delete("Phim","MaPhim " +"=?",new String[]{maphim});
        db.delete("TapPhim","MaPhim " +"=?",new String[]{maphim});
        db.delete("LichSuXem","MaPhim " +"=?",new String[]{maphim});
        db.close();
    }
    public void addKhachHang(KhachHang contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",contact.getHoTen());
        values.put("Email",contact.getEmail());
        values.put("TenDangNhap",contact.getTenDangNhap());
        values.put("MatKhau",contact.getMatKhau());
        values.put("MaKhachHang",contact.getMaKhachHang());

        db.insert("KhachHang",null,values);
        db.close();
    }
    public void updateKhachHang(String maphim,KhachHang contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",contact.getHoTen());
        values.put("Email",contact.getEmail());
        values.put("TenDangNhap",contact.getTenDangNhap());
        values.put("MatKhau",contact.getMatKhau());
        values.put("MaKhachHang",contact.getMaKhachHang());
        db.update("KhachHang",values,"MaKhachHang" + "=?",
                new String[]{maphim});
        db.close();
    }
    public void deleteKhachhang(int makachhang){
        SQLiteDatabase db = getWritableDatabase();

        db.delete("KhachHang","MaKhachHang" +"=?",new String[]{String.valueOf(makachhang)});
        db.delete("LichSuXem","MaKhachHang" +"=?",new String[]{String.valueOf(makachhang)});
        db.close();
    }
    public void addLichSuXem(LichSuXem contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("TenPhim",contact.getTenPhim());
        values.put("TapPhim",contact.getTapPhim());
        values.put("MaKhachHang",contact.getMaKhachHang());

        db.insert("LichSuXem",null,values);
        db.close();
    }
    public void updateLichSuXem(String maphim,LichSuXem contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("TenPhim",contact.getTenPhim());
        values.put("TapPhim",contact.getTapPhim());
        db.update("LichSuXem",values,"MaPhim" + "=?",
                new String[]{maphim});
        db.close();
    }
    public void deleteLichSuXem(String maphim){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("LichSuXem","MaPhim" +"=?",new String[]{maphim});
        db.close();
    }
    public void addTapPhim(TapPhim contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("MaTap",contact.getMaTap());
        values.put("Video",contact.getVideo());
        values.put("TapPhim",contact.getTap());

        db.insert("TapPhim",null,values);
        db.close();
    }
    public void updateTapPhim(String maphim,TapPhim contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhim",contact.getMaPhim());
        values.put("MaTap",contact.getMaTap());
        values.put("Video",contact.getVideo());
        db.update("TapPhim",values,"MaPhim" + "=?",
                new String[]{maphim});
        db.close();
    }
    public void deleteTapPhim(String maphim){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("TapPhim","MaPhim" +"=?",new String[]{maphim});
        db.close();
    }
    public void addTheLoai(TheLoai contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenTheLoai",contact.getTenTheLoai());
        values.put("MaTheLoai",contact.getMaTheLoai());

        db.insert("TheLoai",null,values);
        db.close();
    }
    public void updateTheLoai(String matheloai,TheLoai contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenTheLoai",contact.getTenTheLoai());
        values.put("MaTheLoai",contact.getMaTheLoai());
        db.update("TheLoai",values,"MaTheLoai" + "=?",
                new String[]{matheloai});
        db.close();
    }
    public void deleteTheLoai(String matheloai){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("TheLoai","MaTheLoai " +"=?",new String[]{matheloai});
        db.delete("Phim","MaTheLoai " +"=?",new String[]{matheloai});
        db.close();
    }
    public void addTinhTrang(TinhTrang contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTinhTrang",contact.getMaTinhTrang());
        values.put("TenTinhTrang",contact.getTenTinhTrang());

        db.insert("TinhTrang",null,values);
        db.close();
    }
    public void updateTinhTrang(String matinhtrang,TinhTrang contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTinhTrang",contact.getMaTinhTrang());
        values.put("TenTinhTrang",contact.getTenTinhTrang());

        db.update("TinhTrang",values,"MaTinhTrang" + "=?",
                new String[]{matinhtrang});
        db.close();
    }
    public void deleteTinhTrang(String matinhtrang){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("TinhTrang","MaTinhTrang " +"=?",new String[]{matinhtrang});
        db.delete("Phim","MaTinhTrang " +"=?",new String[]{matinhtrang});
        db.close();
    }
    public void addXuatXu(XuatXu contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaXuatXu",contact.getMaXuatXu());
        values.put("TenXuatXu",contact.getTenXuatXu());

        db.insert("XuatXu",null,values);
        db.close();
    }
    public void updateXuatXu(String maxuatxu,XuatXu contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaXuatXu",contact.getMaXuatXu());
        values.put("TenXuatXu",contact.getTenXuatXu());

        db.update("XuatXu",values,"MaXuatXu" + "=?",
                new String[]{maxuatxu});
        db.close();
    }
    public void deleteXuatXu(String maxuatxu){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("XuatXu","MaXuatXu " +"=?",new String[]{maxuatxu});
        db.delete("Phim","MaXuatXu " +"=?",new String[]{maxuatxu});
        db.close();
    }
}
