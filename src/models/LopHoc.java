package models;

public abstract class LopHoc {
    private int maLopHoc;
    private String tenLopHoc;
    private int maGiaoVien;


    public LopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
        this.tenLopHoc = tenLopHoc;
        this.maGiaoVien = maGiaoVien;
    }

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public int getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(int maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public abstract void danhSachGiaoVien();

    public abstract void danhSachSinhVien();
}
