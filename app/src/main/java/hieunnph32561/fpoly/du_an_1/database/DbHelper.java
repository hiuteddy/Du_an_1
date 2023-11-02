package hieunnph32561.fpoly.du_an_1.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "duan1";
    public static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createLoaiSeriTable = "CREATE TABLE LoaiSeriDienThoai " +
                "(maLoaiSeries INTEGER PRIMARY KEY," +
                " tenLoaiSeries TEXT)";

        String createDienThoaiTable = "CREATE TABLE DienThoai" +
                " (maDT INTEGER PRIMARY KEY," +
                " maLoaiSeries INTEGER," +
                " tenDT TEXT, " +
                "giaTien REAL, " +
                "moTa TEXT, FOREIGN KEY (maLoaiSeri) REFERENCES LoaiSeriDienThoai(maLoaiSeri))";

        String createTaiKhoanTable = "CREATE TABLE TaiKhoan " +
                "(maTk INTEGER PRIMARY KEY," +
                " tenDN TEXT UNIQUE, matKhau TEXT)";

        String createKhachHangTable = "CREATE TABLE KhachHang " +
                "(maKh INTEGER PRIMARY KEY," +
                " hoTen TEXT," +
                " dienThoai INTEGER," +
                " diaChi TEXT)";

        String createHoaDonTable = "CREATE TABLE HoaDon " +
                "(maHD INTEGER PRIMARY KEY," +
                " maKH INTEGER," +
                " maSP INTEGER, " +
                "tongTien INTEGER," +
                " ngay DATE, " +
                "soLuong INTEGER," +
                " trangThai INTEGER, " +
                "FOREIGN KEY (maKH) REFERENCES KhachHang(maKh), " +
                "FOREIGN KEY (maSP) REFERENCES SanPham(maSp))";

        db.execSQL(createLoaiSeriTable);
        db.execSQL(createDienThoaiTable);
        db.execSQL(createTaiKhoanTable);
        db.execSQL(createKhachHangTable);
        db.execSQL(createHoaDonTable);

        // Thêm dữ liệu mẫu
        db.execSQL("INSERT INTO LoaiSeriDienThoai (maLoaiSeries, tenLoaiSeri) VALUES (1, 'Loại seri 1')");
        db.execSQL("INSERT INTO LoaiSeriDienThoai (maLoaiSeries, tenLoaiSeri) VALUES (2, 'Loại seri 2')");

        db.execSQL("INSERT INTO DienThoai (maDT, maLoaiSeries, tenDT, giaTien, moTa) VALUES (1, 1, 'Điện thoại 1', 1000, 'Mô tả 1')");
        db.execSQL("INSERT INTO DienThoai (maDT, maLoaiSeries, tenDT, giaTien, moTa) VALUES (2, 2, 'Điện thoại 2', 2000, 'Mô tả 2')");

        db.execSQL("INSERT INTO TaiKhoan (maTk, tenDN, matKhau) VALUES (1, 'admin', 'admin')");
        db.execSQL("INSERT INTO TaiKhoan (maTk, tenDN, matKhau) VALUES (2, 'user', '123')");

        db.execSQL("INSERT INTO KhachHang (maKh, hoTen, dienThoai, diaChi) VALUES (1, 'Nguyễn Văn A', 123456789, 'Địa chỉ A')");
        db.execSQL("INSERT INTO KhachHang (maKh, hoTen, dienThoai, diaChi) VALUES (2, 'Nguyễn Văn B', 987654321, 'Địa chỉ B')");

        db.execSQL("INSERT INTO HoaDon (maHD, maKH, maSP, tongTien, ngay, soLuong, trangThai) VALUES (1, 1, 1, 5000, '2023-09-21', 2, 1)");
        db.execSQL("INSERT INTO HoaDon (maHD, maKH, maSP, tongTien, ngay, soLuong, trangThai) VALUES (2, 2, 2, 8000, '2023-09-23', 3, 2)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("drop table if exists ThuThu");
            db.execSQL("drop table if exists ThanhVien");
            db.execSQL("drop table if exists LoaiSach");
            db.execSQL("drop table if exists Sach");
            db.execSQL("drop table if exists PhieuMuon");
            onCreate(db);
        }
    }
}
