package entity;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private GioiTinh goitinh;
    private String diaChi;

    public CanBo(){
    }

    public CanBo(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi){
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.goiTinh = gioiTinh;
        this.diaChi = diaChi;

    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public GioiTinh getGoitinh() {
        return goitinh;
    }

    public void setGoitinh(GioiTinh goitinh) {
        this.goitinh = goitinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
