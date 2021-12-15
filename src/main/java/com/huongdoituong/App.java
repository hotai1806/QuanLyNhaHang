package com.huongdoituong;

import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyThue quanLyThue = new QuanLyThue();
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();

        // Them
        ThongTinThue thongTinThue = new ThongTinThue();

        try {
            System.out.print("Ten tiec: ");
            thongTinThue.setTenTiec(SCANNER.nextLine());

            System.out.print("Ngay thue: ");
            thongTinThue.setNgayThue(SCANNER.nextLine());

            System.out.println("Thoi diem thue: ");
            System.out.println("1. Sang");
            System.out.println("2. Chieu");
            System.out.println("3. Toi");
            System.out.print("Nhap thoi diem muon thue: ");
            thongTinThue.setThoiDiemThue(SCANNER.nextLine());

            System.out.print("Nhap tu khoa can tim: ");
            List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
            quanLySanhCuoi.hienThi(listSanhCuoi);
            System.out.print("Nhap ten sanh cuoi muon chon: ");
            thongTinThue.setSanhCuoi(quanLySanhCuoi.traCuuBangTen(SCANNER.nextLine()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // --------------------------------------------------------------------------
    }
}
