package com.huongdoituong.Views;

import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;

import com.huongdoituong.DAL.SanhCuoi;

public class ViewSanh implements ViewBase<QuanLySanhCuoi> {
    @Override
    public void themView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        try {
            SanhCuoi sanhCuoi = new SanhCuoi();

            System.out.print("Ten: ");
            sanhCuoi.setTenSC(scanner.nextLine());
            System.out.print("Vi tri: ");
            sanhCuoi.setViTri(Integer.parseInt(scanner.nextLine()));
            System.out.print("Suc chua: ");
            sanhCuoi.setSucChua(Integer.parseInt(scanner.nextLine()));

            if (quanLySanhCuoi.them(sanhCuoi)) {
                System.out.println("------------------------------------");
                System.out.println("Them thanh cong!");
            }

            System.out.println("====================================");
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }
    }

    @Override
    public void xoaView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        System.out.println("====================================");
        quanLySanhCuoi.hienThi();

        System.out.print("Nhap ma sanh cuoi: ");
        if (quanLySanhCuoi.xoa(scanner.nextLine())) {
            System.out.println("------------------------------------");
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        System.out.println("====================================");
        quanLySanhCuoi.hienThi();

        System.out.print("Nhap ma sanh cuoi: ");
        if (quanLySanhCuoi.capNhat(scanner.nextLine(), scanner)) {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        System.out.println("====================================");

        System.out.print("Nhap tu khoa can tim: ");
        List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(scanner.nextLine());
        quanLySanhCuoi.hienThi(listSanhCuoi);
    }
}
