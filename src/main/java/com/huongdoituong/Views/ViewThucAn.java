package com.huongdoituong.Views;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyThucAn;

import com.huongdoituong.DAL.ThucAn;

public class ViewThucAn implements ViewBase<QuanLyThucAn> {
    @Override
    public void themView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        try {
            ThucAn thucAn = new ThucAn();
            System.out.print("Ten mon: ");
            thucAn.setTen(scanner.nextLine());

            System.out.print("Mon co chay khong(1 co, 0 khong): ");
            thucAn.setMonChay(scanner.nextLine().equals("0") ? false : true);

            System.out.print("Set gia:");
            thucAn.setGia(new BigDecimal(scanner.nextLine()));
            if (quanLyThucAn.them(thucAn)) {
                System.out.println("------------------------------------");
                System.out.println("Them thanh cong");
            } else {
                System.out.println("------------------------------------");
                System.out.println("Them khong thanh cong");
            }
            System.out.println("====================================");
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }
    

    }

    @Override
    public void xoaView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        System.out.println("====================================");
        quanLyThucAn.hienThi();
        System.out.print("Nhap ma thuc an: ");
        if (quanLyThucAn.xoa(scanner.nextLine())) {
            System.out.println("------------------------------------");
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyThucAn quanLyThucAn) {

        System.out.println("====================================");
        quanLyThucAn.hienThi();

        System.out.print("Nhap ma thuc an: ");
        // String ten = scanner.nextLine()
        if (quanLyThucAn.capNhat(scanner.nextLine(), scanner)) {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        System.out.println("====================================");
        System.out.print("Nhap tu khoa can tim: ");
        List<ThucAn> thucAn = QuanLyThucAn.timByTen(scanner.nextLine());

        if (thucAn.size() == 0) {
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
            quanLyThucAn.hienThi();
        } else {
            quanLyThucAn.hienThi(thucAn);
        }

    }
}
