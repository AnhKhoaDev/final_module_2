package controllers;

import services.SinhVienService;

import java.util.Scanner;

public class SinhVienController {
    public static void controller(){
        Scanner sc = new Scanner(System.in);
        SinhVienService sinhVienService = new SinhVienService();
        System.out.println("Lựa chọn chức năng: ");
        int choose = Integer.parseInt(sc.nextLine());
        do {
            switch (choose){
                case 1:{
                    sinhVienService.themSinhVien();
                    sinhVienService.enterToBackMenu();
                    break;
                }
                case 2:{
                    sinhVienService.xoaSinhVien();
                    sinhVienService.enterToBackMenu();
                    break;
                }
                case 3:{
                    sinhVienService.danhSachSinhVien();
                    sinhVienService.enterToBackMenu();
                    break;
                }
                case 4:{
                    sinhVienService.timSinhVien();
                    sinhVienService.enterToBackMenu();
                    break;
                }
            }
        }while (choose != 0);
    }
}
