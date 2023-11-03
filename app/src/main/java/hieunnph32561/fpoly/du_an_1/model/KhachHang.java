package hieunnph32561.fpoly.du_an_1.model;

    public class KhachHang {
        private int maKh;
        private String hoTen;
        private int dienThoai;
        private String diaChi;

        public KhachHang(int maKh, String hoTen, int dienThoai, String diaChi) {
            this.maKh = maKh;
            this.hoTen = hoTen;
            this.dienThoai = dienThoai;
            this.diaChi = diaChi;
        }

        public int getMaKh() {
            return maKh;
        }

        public String getHoTen() {
            return hoTen;
        }

        public int getDienThoai() {
            return dienThoai;
        }

        public String getDiaChi() {
            return diaChi;
        }
    }

