package com.huongdoituong.Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyMenu;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;
import com.huongdoituong.DAL.Menu;

public class ViewMenu implements ViewBase<QuanLyMenu> {
    private QuanLyThucAn quanLyThucAn;
    private QuanLyThucUong quanLyThucUong;

    public ViewMenu(QuanLyThucAn quanLyThucAn, QuanLyThucUong quanLyThucUong) {
        this.quanLyThucAn = quanLyThucAn;
        this.quanLyThucUong = quanLyThucUong;
    }

    @Override
    public void themView(Scanner scanner, QuanLyMenu quanLyMenu) {
        try {
            Menu menu = new Menu();
            System.out.println("Chon mon them:");
            System.out.println("1. Thuc an:");
            System.out.println("2. Thuc uong:");
            System.out.println("3. Tro lai:");

            while (scanner.nextLine() != "0") {
                switch (scanner.nextInt()) {
                    case 1:
                        quanLyThucAn.hienThi();
                        System.out.println("Chon mon theo so:");

                        menu.themThucAn(quanLyThucAn.tim(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 2:
                        quanLyThucUong.hienThi();
                        System.out.println("Chon mon theo so:");

                        menu.themThucUong(quanLyThucUong.tim(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("====================================");
                        System.out.println("*** Lua chong khong kha dung ***");
                        System.out.println("====================================");

                        continue;
                }
            }

        } catch (Exception e) {
            System.out.println("Loi nhap");
        }
    }

    @Override
    public void xoaView(Scanner scanner, QuanLyMenu quanLyMenu) {
        System.out.println("====================================");
        quanLyMenu.hienThi();

        System.out.print("Nhap ma menu: ");
        if (quanLyMenu.xoa(scanner.nextLine())) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyMenu quanLyMenu) {
        System.out.println("====================================");
        quanLyMenu.hienThi();

        System.out.print("Nhap ma menu: ");
        // String ten = scanner.nextLine()
        if (quanLyMenu.capNhat(scanner.nextLine(), scanner)) {
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLyMenu quanLyMenu) {
        System.out.println("====================================");
        System.out.print("Nhap tu khoa can tim: ");
        List<Menu> listMenu = new ArrayList<>();
        Menu menu = quanLyMenu.timById(Integer.parseInt(scanner.nextLine()));
        listMenu.add(menu);
        if (listMenu.size() == 0) {
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
            quanLyMenu.hienThi();
        } else {
            quanLyMenu.hienThi(listMenu);
        }

    }
}
