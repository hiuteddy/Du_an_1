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
        // Tạo bảng LoaiMau
        String createLoaiMauTable = "CREATE TABLE LoaiMau (" +
                "maMau INTEGER PRIMARY KEY," +
                "tenMau TEXT" +
                ")";
        db.execSQL(createLoaiMauTable);

        // Tạo bảng LoaiDienThoai
        String createLoaiDienThoaiTable = "CREATE TABLE LoaiDienThoai (" +
                "maLoai INTEGER PRIMARY KEY," +
                "tenLoai TEXT" +
                ")";
        db.execSQL(createLoaiDienThoaiTable);

        // Tạo bảng DienThoai
        String createDienThoaiTable = "CREATE TABLE DienThoai (" +
                "maDt INTEGER PRIMARY KEY," +
                "maLoai INTEGER," +
                "maMau INTEGER," +
                "giaTien REAL," +
                "moTa TEXT," +
                "tenDt TEXT," +
                "soLuong INTEGER," +
                "FOREIGN KEY (maLoai) REFERENCES LoaiDienThoai(maLoai)," +
                "FOREIGN KEY (maMau) REFERENCES LoaiMau(maMau)" +
                ")";
        db.execSQL(createDienThoaiTable);

        // Tạo bảng GioHang
        String createGioHangTable = "CREATE TABLE GioHang (" +
                "maGh INTEGER PRIMARY KEY," +
                "maDt INTEGER," +
                "maKh INTEGER," +
                "soLuong INTEGER," +
                "FOREIGN KEY (maDt) REFERENCES DienThoai(maDt)," +
                "FOREIGN KEY (maKh) REFERENCES KhachHang(maKh)" +
                ")";
        db.execSQL(createGioHangTable);

        // Tạo bảng DonHangChiTiet
        String createDonHangChiTietTable = "CREATE TABLE DonHangChiTiet (" +
                "maCt INTEGER PRIMARY KEY," +
                "maDh INTEGER," +
                "maDt INTEGER," +
                "soLuong INTEGER," +
                "tongTien REAL," +
                "FOREIGN KEY (maDh) REFERENCES DonHang(maDh)," +
                "FOREIGN KEY (maDt) REFERENCES DienThoai(maDt)" +
                ")";
        db.execSQL(createDonHangChiTietTable);

        // Tạo bảng DonHang
        String createDonHangTable = "CREATE TABLE DonHang (" +
                "maDh INTEGER PRIMARY KEY," +
                "maKh INTEGER," +
                "ngayDat TEXT," +
                "trangThai TEXT," +
                "diaChi TEXT," +
                "tongTien REAL," +
                "FOREIGN KEY (maKh) REFERENCES KhachHang(maKh)" +
                ")";
        db.execSQL(createDonHangTable);

        // Tạo bảng KhachHang
        String createKhachHangTable = "CREATE TABLE KhachHang (" +
                "maKh INTEGER PRIMARY KEY," +
                "taiKhoan TEXT," +
                "soDienThoai TEXT," +
                "email TEXT," +
                "hoTen TEXT" +
                ")";
        db.execSQL(createKhachHangTable);

        // Chèn dữ liệu vào bảng LoaiMau
        String insertLoaiMauData = "INSERT INTO LoaiMau (maMau, tenMau) VALUES " +
                "(1, 'Màu Đen')," +
                "(2, 'Màu Trắng')," +
                "(3, 'Màu Xanh')";
        db.execSQL(insertLoaiMauData);

        // Chèn dữ liệu vào bảng LoaiDienThoai
        String insertLoaiDienThoaiData = "INSERT INTO LoaiDienThoai (maLoai, tenLoai) VALUES " +
                "(1, 'Smartphone')," +
                "(2, 'Tablet')," +
                "(3, 'Điện thoại cổ')";
        db.execSQL(insertLoaiDienThoaiData);

        // Chèn dữ liệu vào bảng DienThoai
        String insertDienThoaiData = "INSERT INTO DienThoai (maDt, maLoai, maMau, giaTien, moTaTEXT, tenDt TEXT, soLuong INTEGER) VALUES " +
                "(1, 1, 1, 5000000, 'Điện thoại thông minh màu đen', 'Smartphone A', 10)," +
                "(2, 1, 2, 6000000, 'Điện thoại thông minh màu trắng', 'Smartphone B', 15)," +
                "(3, 2, 3, 4000000, 'Máy tính bảng màu xanh', 'Tablet A', 5)";
        db.execSQL(insertDienThoaiData);

        // Chèn dữ liệu vào bảng GioHang
        String insertGioHangData = "INSERT INTO GioHang (maGh, maDt, maKh, soLuong) VALUES " +
                "(1, 1, 1, 2)," +
                "(2, 2, 1, 1)," +
                "(3, 3, 2, 3)";
        db.execSQL(insertGioHangData);

        // Chèn dữ liệu vào bảng DonHangChiTiet
        String insertDonHangChiTietData = "INSERT INTO DonHangChiTiet (maCt, maDh, maDt, soLuong, tongTien) VALUES " +
                "(1, 1, 1, 2, 10000000)," +
                "(2, 2, 2, 1, 6000000)," +
                "(3, 2, 3, 3, 12000000)";
        db.execSQL(insertDonHangChiTietData);

        // Chèn dữ liệu vào bảng DonHang
        String insertDonHangData = "INSERT INTO DonHang (maDh, maKh, ngayDat, trangThai, diaChi, tongTien) VALUES " +
                "(1, 1, '2023-11-01', 'Đã giao hàng', '123 Đường ABC, Thành phố XYZ', 10000000)," +
                "(2, 2, '2023-11-03', 'Đang vận chuyển', '456 Đường DEF, Thành phố UVW', 18000000)";
        db.execSQL(insertDonHangData);

        // Chèn dữ liệu vào bảng KhachHang
        String insertKhachHangData = "INSERT INTO KhachHang (maKh, taiKhoan, soDienThoai, email, hoTen) VALUES " +
                "(1, 'tkh001', '0987654321', 'khachhang1@gmail.com', 'Nguyễn Văn A')," +
                "(2, 'tkh002', '0123456789', 'khachhang2@gmail.com', 'Trần Thị B')";
        db.execSQL(insertKhachHangData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("DROP TABLE IF EXISTS LoaiMau");
            db.execSQL("DROP TABLE IF EXISTS LoaiDienThoai");
            db.execSQL("DROP TABLE IF EXISTS DienThoai");
            db.execSQL("DROP TABLE IF EXISTS GioHang");
            db.execSQL("DROP TABLE IF EXISTS DonHangChiTiet");
            db.execSQL("DROP TABLE IF EXISTS DonHang");
            db.execSQL("DROP TABLE IF EXISTS KhachHang");
            onCreate(db);
        }
    }
}