package com.huongdoituong.Views;

import java.math.BigDecimal;
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

            System.out.print("Mon chay(1 co, 0 khong): ");
            thucAn.setMonChay(scanner.nextLine().equals("0") ? false : true);

            System.out.print("Gia: ");
            thucAn.setGia(new BigDecimal(scanner.nextLine()));
            if (quanLyThucAn.them(thucAn)) {
                System.out.println("------------------------------------");
                System.out.println("Them thanh cong");
            } else {
                System.out.println("------------------------------------");
                System.out.println("Them khong thanh cong");
                
            }
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }

        System.out.println("====================================");
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        quanLyThucAn.hienThiDS(quanLyThucAn.getDSThucAn());

        System.out.print("Nhap ma thuc an: ");
        ThucAn thucAn = quanLyThucAn.timById(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------------------");

        if (thucAn == null) {
            System.out.println("====================================");
            System.out.println("Thuc an khong ton tai!");
            System.out.println("====================================");

            return;
        }

        thucAn.capNhat(scanner);
        
        if (quanLyThucAn.capNhatDS()) {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void xoaView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        quanLyThucAn.hienThiDS(quanLyThucAn.getDSThucAn());
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
    public void traCuuView(Scanner scanner, QuanLyThucAn quanLyThucAn) {
        System.out.print("Nhap tu khoa can tim: ");
        ThucAn thucAn = quanLyThucAn.timByTen(scanner.nextLine());
        System.out.println("------------------------------------");

        if (thucAn == null) {
            System.out.println("====================================");
            System.out.println("Thuc an khong ton tai!");
            System.out.println("====================================");
            quanLyThucAn.hienThiDS(quanLyThucAn.getDSThucAn());
        } else {
            thucAn.hienThi();
        }
    }
}
