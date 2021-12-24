package com.huongdoituong.Views;

import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyMenu;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.ThucAn;

public class ViewThucAn implements ViewBase {
    private QuanLyThucAn quanLyThucAn;
    private Scanner scanner;

    public ViewThucAn(QuanLyThucAn quanLyThucAn, Scanner scanner) {
        this.quanLyThucAn = quanLyThucAn;
        this.scanner = scanner;
    }

    public boolean themView() {
        try {

            ThucAn thucAn = new ThucAn();
            System.out.print("Ten mon:");
            thucAn.setTen(scanner.nextLine());

            System.out.print("Mon co chay khong(1 co, 0 khong):");
            thucAn.setMonChay(scanner.nextInt() == 0 ? false : true);

            System.out.print("Set gia:");
            thucAn.setGia(scanner.nextBigDecimal());
            return quanLyThucAn.them(thucAn);
        } catch (Exception e) {
            System.out.println("Loi nhap");
            return false;
        }
    }

    public boolean xoaView() {
        System.out.println("====================================");
        quanLyThucAn.hienThi();
        System.out.print("Nhap ma thuc an: ");
        if (quanLyThucAn.xoa(scanner.nextInt())) {
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
        quanLyThucAn.hienThi();

        System.out.print("Nhap ma thuc an: ");
        // String ten = scanner.nextLine()
        if (quanLyThucAn.capNhat(scanner.nextInt(), scanner)) {
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
        List<ThucAn> thucAn= QuanLyThucAn.timByTen(scanner.nextLine());

        if(thucAn.size() ==0){
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
            quanLyThucAn.hienThi();
        }else{

            quanLyThucAn.hienThi(thucAn);
        }

    }
}
