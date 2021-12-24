package com.huongdoituong.Views;

import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyThucUong;
import com.huongdoituong.DAL.ThucUong;

public class ViewThucUong {
    private QuanLyThucUong quanLyThucUong;
    private Scanner scanner;

    public ViewThucUong(QuanLyThucUong quanLyThucUong, Scanner scanner) {
        this.quanLyThucUong = quanLyThucUong;
        this.scanner = scanner;
    }

    public boolean themView() {
        try {

            ThucUong thucAn = new ThucUong();
            System.out.print("Ten mon:");
            thucAn.setTen(scanner.nextLine());

            System.out.print("Hang san xuat:");
            thucAn.setHangSanXuat(scanner.nextLine());

            System.out.print("Set gia:");
            thucAn.setGia(scanner.nextBigDecimal());
            return quanLyThucUong.them(thucAn);
        } catch (Exception e) {
            System.out.println("Loi nhap");
            return false;
        }
    }

    public boolean xoaView() {
        System.out.println("====================================");
        quanLyThucUong.hienThi();
        System.out.print("Nhap ma mon: ");
        if (quanLyThucUong.xoa(scanner.nextInt())) {
            System.out.println("Xoa thanh cong!");
            return true;
        } else {
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
        return false;

    }

    public boolean capNhatView() {

        System.out.println("====================================");
        quanLyThucUong.hienThi();

        System.out.print("Nhap ma thuc uong: ");
        // String ten = scanner.nextLine()
        if (quanLyThucUong.capNhat(scanner.nextInt(), scanner)) {
            System.out.println("Cap nhat thanh cong!");
            return true;
        } else {
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
        return false;
    }

    public void traCuuView() {
        System.out.println("====================================");
        System.out.print("Nhap tu khoa can tim: ");
        List<ThucUong> thucUong = QuanLyThucUong.timByTen(scanner.nextLine());

        if (thucUong.size() == 0) {
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
            quanLyThucUong.hienThi();
        } else {

            quanLyThucUong.hienThi(thucUong);
        }

    }
}
