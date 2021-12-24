package com.huongdoituong.Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyMenu;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;
import com.huongdoituong.DAL.Menu;

public class ViewMenu implements ViewBase {
    private QuanLyMenu quanLyMenu;
    private QuanLyThucAn quanLyThucAn;
    private QuanLyThucUong quanLyThucUong;

    private Scanner scanner;

    public ViewMenu(QuanLyMenu quanLyMenu, QuanLyThucAn quanLyThucAn, QuanLyThucUong quanLyThucUong, Scanner scanner) {
        this.quanLyMenu = quanLyMenu;
        this.quanLyThucAn = quanLyThucAn;
        this.quanLyThucUong = quanLyThucUong;
        this.scanner = scanner;
    }

    public boolean themView() {
        try {

            Menu menu = new Menu();
            System.out.println("Chon mon them:");
            System.out.println("1. Thuc an:");
            System.out.println("2. Thuc uong:");

            while (scanner.nextInt() != 0) {
                switch (scanner.nextInt()) {
                    case 1:
                        quanLyThucAn.hienThi();
                        System.out.println("Chon mon theo so:");
                        menu.themThucAn(quanLyThucAn.tim(scanner.nextInt()));
                        break;
                    case 2:
                        quanLyThucUong.hienThi();
                        System.out.println("Chon mon theo so:");

                        menu.themThucUong(quanLyThucUong.tim(scanner.nextInt()));
                        break;
                }
            }

            return true;
        } catch (Exception e) {
            System.out.println("Loi nhap");
            return false;
        }
    }

    public boolean xoaView() {
        System.out.println("====================================");
        quanLyMenu.hienThi();
        System.out.print("Nhap ma menu: ");
        if (quanLyMenu.xoa(scanner.nextInt())) {

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
        quanLyMenu.hienThi();

        System.out.print("Nhap ma menu: ");
        // String ten = scanner.nextLine()
        if (quanLyMenu.capNhat(scanner.nextInt(), scanner)) {
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
        List<Menu> listMenu = new ArrayList<>();
        Menu menu= quanLyMenu.timById(scanner.nextInt());
        listMenu.add(menu);
        if(listMenu.size() ==0){
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
            quanLyMenu.hienThi();
        }else{

            quanLyMenu.hienThi(listMenu);
        }

    }
}
