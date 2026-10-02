package entity;


    public class TapChi extends TaiLieu {
        private int soPhatHanh;
        private int thangPhatHanh;

        public TapChi(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
            super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
            this.soPhatHanh = soPhatHanh;
            this.thangPhatHanh = thangPhatHanh;
        }

        public int getSoPhatHanh() {
            return soPhatHanh;
        }

        public int getThangPhatHanh() {
            return thangPhatHanh;
        }

        @Override
        public void hienThiThongTin() {
            String url ="jdbc:mysql://127.0.0.1:3306/qlcb";
            String username ="root";
            String password = "211201";

            super.hienThiThongTin();
            System.out.println(" | Số PH: " + soPhatHanh + " | Tháng PH: " + thangPhatHanh);
        }
}
