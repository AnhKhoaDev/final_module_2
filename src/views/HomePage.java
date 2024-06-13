package views;

import controllers.SinhVienController;

public class HomePage {
    public static void viewHomePage() {
        System.out.println("---------Trang chủ----------");
        System.out.println("1.Thêm mới sinh viên");
        System.out.println("2.Xoá sinh viên");
        System.out.println("3.Xem danh sách sinh viên");
        System.out.println("4.Tìm kiếm sinh viên");
        System.out.println("0.Thoát khỏi chương trình");
        SinhVienController.controller();
    }
}
