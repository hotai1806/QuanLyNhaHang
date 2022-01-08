package com.huongdoituong.Views;

import java.math.BigDecimal;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyThucUong;

import com.huongdoituong.DAL.ThucUong;

public class ViewThucUong implements ViewBase<QuanLyThucUong> {
    @Override
    public void themView(Scanner scanner, QuanLyThucUong quanLyThucUong) {
        try {

            ThucUong thucUong = new ThucUong();
            System.out.print("Ten mon: ");
            thucUong.setTen(scanner.nextLine());

            System.out.print("Hang san xuat: ");
            thucUong.setHangSanXuat(scanner.nextLine());

            System.out.print("Gia: ");
            thucUong.setGia(new BigDecimal(scanner.nextLine()));

            if (quanLyThucUong.them(thucUong)) {
                System.out.println("------------------------------------");
                System.out.println("Them thanh cong!");
            } else {
                System.out.println("------------------------------------");
                System.out.println("Them khong thanh cong!");
            }

            System.out.println("====================================");
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyThucUong quanLyThucUong) {
        quanLyThucUong.hienThiDS(quanLyThucUong.getDSThucUong());

        System.out.print("Nhap ma thuc uong: ");
        ThucUong thucUong = quanLyThucUong.timById(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------------------");

        if (thucUong == null) {
            System.out.println("====================================");
            System.out.println("Thuc uong khong ton tai!");
            System.out.println("====================================");

            return;
        }

        thucUong.capNhat(scanner);

        if (quanLyThucUong.capNhatDS()) {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void xoaView(Scanner scanner, QuanLyThucUong quanLyThucUong) {
        quanLyThucUong.hienThiDS(quanLyThucUong.getDSThucUong());

        System.out.print("Nhap ma mon: ");
        if (quanLyThucUong.xoa(scanner.nextLine())) {
            System.out.println("------------------------------------");
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLyThucUong quanLyThucUong) {
        System.out.print("Nhap tu khoa can tim: ");
        ThucUong thucUong = quanLyThucUong.timByTen(scanner.nextLine());
        System.out.println("------------------------------------");

        if (thucUong == null) {
            System.out.println("====================================");
            System.out.println("Thuc uong khong ton tai!");
            System.out.println("====================================");
            quanLyThucUong.hienThiDS(quanLyThucUong.getDSThucUong());
        } else {
            thucUong.hienThi();
        }
    }
}
