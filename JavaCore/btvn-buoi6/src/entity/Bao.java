package entity;


    public class Bao extends TaiLieu {
        private String ngayPhatHanh;

        public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
            super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
            this.ngayPhatHanh = ngayPhatHanh;
        }

        public String getNgayPhatHanh() {
            return ngayPhatHanh;
        }

        @Override
        public void hienThiThongTin() {
            super.hienThiThongTin();
            System.out.println(" | Ngày PH: " + ngayPhatHanh);
        }
}
