package models;

public class GiaoVien extends LopHoc {
    private String tenGiaoVien;
    private  String ngaySinhGiaoVien;
    private String gioiTinh;
    private String soDienThoai;


    public GiaoVien(int maGiaoVien) {
        super(maGiaoVien);
    }

    @Override
    public void danhSachGiaoVien() {
        System.out.println("Danh sach giao viên");
    }


    public GiaoVien(int maLopHoc, String tenGiaoVien, String ngaySinhGiaoVien, String gioiTinh, String soDienThoai) {
        super(maLopHoc);
        this.tenGiaoVien = tenGiaoVien;
        this.ngaySinhGiaoVien = ngaySinhGiaoVien;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getNgaySinhGiaoVien() {
        return ngaySinhGiaoVien;
    }

    public void setNgaySinhGiaoVien(String ngaySinhGiaoVien) {
        this.ngaySinhGiaoVien = ngaySinhGiaoVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public void danhSachSinhVien() {
        System.out.println("Danh sách sinh viên");
    }
}
