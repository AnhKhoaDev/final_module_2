package models;

import java.util.SortedMap;

public class SinhVien  extends LopHoc{
    private int maSinhVien;
    private String tenSinhVien;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;




    public SinhVien(int maSinhVien, String tenSinhVien, String ngaySinh, String gioiTinh, String soDienThoai, int maLopHoc) {
        super(maLopHoc);
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
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
    public void danhSachGiaoVien() {
        System.out.println("Danh sách giáo viên");
    }

    @Override
    public void danhSachSinhVien() {
        System.out.println("Không thể try cập");
    }
}
