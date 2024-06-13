package services;

import Repositories.SinhVienRepo;
import models.NotFoundStudentException;
import models.SinhVien;
import views.HomePage;

import java.util.List;
import java.util.Scanner;

public class SinhVienService implements IStudentService {
    Scanner sc = new Scanner(System.in);
    private static final List<SinhVien> sinhVienList = SinhVienRepo.readFile();

    @Override
    public void themSinhVien() {
            int maSinhVien = sinhVienList.size() + 1;
            System.out.println("---------Thêm sinh viên----------");
            for (int i = 0; i < sinhVienList.size(); i++) {
                if (i + 1 != sinhVienList.get(i).getMaSinhVien()) {
                    maSinhVien = i + 1;
                }
            }

            System.out.println("Tên sinh viên: ");
            boolean nameExits = false;

            String tenSinhVien;
            String TENSINHVIEN_REGEX = "^.{4,50}$";
            boolean isMatch = false;

            do {
                System.out.println("Tên sinh viên phải từ 4 đến 50 ký tự");
                tenSinhVien = sc.nextLine();
                if (tenSinhVien.matches(TENSINHVIEN_REGEX)) {
                    isMatch = true;
                } else {
                    System.err.println("Tên sinh viên không hợp lệ!");
                }
            } while (!isMatch);
            if (nameExits) {
                System.err.println("Tên sinh viên không hợp lệ!");
                nameExits = false;
            }

            System.out.println("Ngày sinh: ");
            boolean dateExits = false;

            String ngaySinh;
            String NGAYSINH_REGEX = "^((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d))$";
            boolean isMatchs = false;

            do {
                System.out.println("Ngày sinh phải đúng định dạng ngày tháng năm dd/MM/yyyy");
                ngaySinh = sc.nextLine();
                if (ngaySinh.matches(NGAYSINH_REGEX)) {
                    isMatchs = true;
                } else {
                    System.err.println("Ngày sinh không hợp lệ!");
                }
            } while (!isMatchs);

            if (dateExits) {
                System.err.println("Ngày sinh không hợp lệ!");
                dateExits = false;
            }

            System.out.println("Giới tính sinh viên: ");
            String gioiTinh = sc.nextLine();

            System.out.println("Số điện thoại sinh viện: ");
            boolean phoneExits = false;

            String soDienThoai;
            String SODIENTHOAI_REGEX = "^(090|091)\\d{7}$";
            boolean phoneMatch = false;

            do {
                System.out.println("Số điện thoại phải là 10 số và bắt đầu bằng 090 hoặc 091");
                soDienThoai = sc.nextLine();
                if (soDienThoai.matches(SODIENTHOAI_REGEX)) {
                    phoneMatch = true;
                } else {
                    System.err.println("Số điện thoại không hợp lệ!");
                }
            } while (!phoneMatch);
            for (SinhVien sinhVien : sinhVienList) {
                if (sinhVien.getSoDienThoai().equals(soDienThoai)) {
                    phoneExits = true;
                    break;
                }
            }
            if (phoneExits) {
                System.err.println("Số điện thoại không hợp lệ!");
                phoneExits = false;
            }

            System.out.println("Mã lớp học: ");
            int maLopHoc = Integer.parseInt(sc.nextLine());

            SinhVien sinhVien = new SinhVien(maSinhVien, tenSinhVien, ngaySinh, gioiTinh, soDienThoai, maLopHoc);
            sinhVienList.add(sinhVien);
            SinhVienRepo.writeFile(sinhVienList);
            System.out.println("Sinh viên được thêm thành công!");
    }

    @Override
    public void xoaSinhVien() {
        try{
            System.out.println("__________Xóa sinh viên__________");
            System.out.print("Nhập mã sinh viên mà bạn muốn xóa: ");
            int maSinhVien = Integer.parseInt(sc.nextLine());

            boolean remove = false;
            for (int i = 0; i < sinhVienList.size(); i++) {
                if (sinhVienList.get(i).getMaSinhVien() == maSinhVien) {
                    remove = true;
                    System.out.print("Bạn có chắc chắn muốn xóa sinh viên này? (Yes/No): ");
                    String confirmation = sc.nextLine();
                    if (confirmation.equalsIgnoreCase("Yes")) {
                        sinhVienList.remove(i);
                        System.out.println("Đã xóa sinh viên thành công.");
                    } else {
                        HomePage.viewHomePage();
                        System.out.println("Đã hủy xóa sinh viên.");
                    }
                    break;
                }
            }

            if (remove) {
                SinhVienRepo.writeFile(sinhVienList);
            } else {
                throw new NotFoundStudentException("Sinh viên không tồn tại.");
            }
            System.out.println();
        }catch (NotFoundStudentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void danhSachSinhVien() {
        for(SinhVien sinhVien : sinhVienList){
            System.out.println("Thông tin của sinh viên: " +
                    sinhVien.getMaSinhVien() + ", " +
                    sinhVien.getTenSinhVien() + ", " +
                    sinhVien.getNgaySinh() + ", " +
                    sinhVien.getGioiTinh() + ", " +
                    sinhVien.getSoDienThoai() + ", " +
                    sinhVien.getMaLopHoc());
        }
    }


    @Override
    public void timSinhVien() {
        System.out.println("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        boolean isExists = false;
        for (SinhVien sinhVien : sinhVienList) {
            if (sinhVien.getTenSinhVien().trim().equalsIgnoreCase(name)) {
                System.out.println("Thông tin của sinh viên: " +
                        sinhVien.getMaSinhVien() + ", " +
                        sinhVien.getTenSinhVien() + ", " +
                        sinhVien.getNgaySinh() + ", " +
                        sinhVien.getGioiTinh() + ", " +
                        sinhVien.getSoDienThoai() + ", " +
                        sinhVien.getMaLopHoc());
                isExists = true;
            }
        }
        if (!isExists) {
            System.err.println("Không tìm thấy tên sinh viên");
        }
    }

    @Override
    public void enterToBackMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean isExcept = false;
        System.out.println("Nhấn enter để trở về trang chủ");
        scanner.nextLine();
        HomePage.viewHomePage();
    }


}
