package com.huongdoituong.Views;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyThue;

public class ViewDoanhThu {
    private final String YEAR_REGEX = "^\\d{4}$";

    public void xemDoanhThuThangView(Scanner scanner, QuanLyThue quanLyThue) {
        String nam = "";

        while (!nam.matches(YEAR_REGEX)) {
            System.out.print("Nhap nam can xem doanh thu thang: ");
            nam = scanner.nextLine();
            System.out.println("------------------------------------");
        }

        quanLyThue.xemDoanhThuThang(nam);
        System.out.println("====================================");
    }

    public void xemDoanhThuQuyView(Scanner scanner, QuanLyThue quanLyThue) {
        String nam = "";

        while (!nam.matches(YEAR_REGEX)) {
            System.out.print("Nhap nam can xem doanh thu quy: ");
            nam = scanner.nextLine();
            System.out.println("------------------------------------");
        }

        quanLyThue.xemDoanhThuQuy(nam);
        System.out.println("====================================");
    }
}
