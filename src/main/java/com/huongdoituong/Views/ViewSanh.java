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
            sanhCuoi.setTen(scanner.nextLine());

            System.out.print("Vi tri(tang 1, tang 2): ");
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
    public void capNhatView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        quanLySanhCuoi.hienThiDS(quanLySanhCuoi.getDSSanhCuoi());

        System.out.print("Nhap ma sanh cuoi: ");
        SanhCuoi sanhCuoi = QuanLySanhCuoi.timByMa(scanner.nextLine());
        System.out.println("------------------------------------");

        if (sanhCuoi == null) {
            System.out.println("====================================");
            System.out.println("Sanh cuoi khong ton tai!");
            System.out.println("====================================");

            return;
        }

        try {
            sanhCuoi.capNhat(scanner);

            if (quanLySanhCuoi.capNhatDS()) {
                System.out.println("------------------------------------");
                System.out.println("Cap nhat thanh cong!");
            } else {
                System.out.println("------------------------------------");
                System.out.println("Cap nhat khong thanh cong!");

            }
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }

        System.out.println("====================================");
    }

    @Override
    public void xoaView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        quanLySanhCuoi.hienThiDS(quanLySanhCuoi.getDSSanhCuoi());

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
    public void traCuuView(Scanner scanner, QuanLySanhCuoi quanLySanhCuoi) {
        System.out.print("Nhap tu khoa can tim: ");
        List<SanhCuoi> dsSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(scanner.nextLine());
        System.out.println("------------------------------------");

        if (dsSanhCuoi.size() == 0) {
            System.out.println("====================================");
            System.out.println("Sanh cuoi khong ton tai!");
            System.out.println("====================================");

            quanLySanhCuoi.hienThiDS(quanLySanhCuoi.getDSSanhCuoi());
        } else {
            quanLySanhCuoi.hienThiDS(dsSanhCuoi);
        }
    }
}
