package Repositories;

import models.SinhVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepo {
    private static final File file = new File("students.csv");

    public static List<SinhVien> readFile() {
        List<SinhVien> sinhVienList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] sinhVienString = line.split(",");
                int maSinhVien = Integer.parseInt(sinhVienString[0]);
                String tenSinhVien = sinhVienString[1];
                String ngaySinh = sinhVienString[2];
                String gioiTinh = sinhVienString[3];
                String soDienThoai = sinhVienString[4];
                int maLopHoc = Integer.parseInt(sinhVienString[5]);
                SinhVien sinhVien = new SinhVien(maSinhVien, tenSinhVien, ngaySinh, gioiTinh, soDienThoai, maLopHoc);
                sinhVienList.add(sinhVien);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sinhVienList;
    }

    public static void writeFile(List<SinhVien> sinhVienListList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder sinhVienString = new StringBuilder();
            for (SinhVien sinhVien : sinhVienListList) {
                sinhVienString.append(sinhVien.getMaSinhVien()).append(",")
                        .append(sinhVien.getTenSinhVien()).append(",")
                        .append(sinhVien.getNgaySinh()).append(",")
                        .append(sinhVien.getGioiTinh()).append(",")
                        .append(sinhVien.getSoDienThoai()).append(",")
                        .append(sinhVien.getMaLopHoc()).append("\n");
            }
            bufferedWriter.write(sinhVienString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
