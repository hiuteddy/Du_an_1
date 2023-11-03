package hieunnph32561.fpoly.du_an_1.model;

    public class HoaDon {
        private int maHD;
        private int maKH;
        private int maSP;
        private int tongTien;
        private String ngay;
        private int soLuong;
        private int trangThai;

        public HoaDon(int maHD, int maKH, int maSP, int tongTien, String ngay, int soLuong, int trangThai) {
            this.maHD = maHD;
            this.maKH = maKH;
            this.maSP = maSP;
            this.tongTien = tongTien;
            this.ngay = ngay;
            this.soLuong = soLuong;
            this.trangThai = trangThai;
        }

        public int getMaHD() {
            return maHD;
        }

        public int getMaKH() {
            return maKH;
        }

        public int getMaSP() {
            return maSP;
        }

        public int getTongTien() {
            return tongTien;
        }

        public String getNgay() {
            return ngay;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public int getTrangThai() {
            return trangThai;
        }
    }

