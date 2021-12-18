package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.ThucAn;
import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyMenu implements IDocGhi<Menu> {
    private List<Menu> listMenu = new ArrayList<>();

    public QuanLyMenu() {

    }

    public boolean them(Menu menu) {
        return this.listMenu.add(menu);
    }

    public boolean xoa(String id) {
        return this.listMenu.removeIf(element -> element.getMaMenu() == id);
    }

    public BigDecimal getTongGia() {
        return this.listMenu.stream().map(p -> p.getTongGia()).reduce(new BigDecimal(0), (x, y) -> x.add(y));
    }

    @Override
    public void doc(String path) {
        File file = new File(Path.MENU.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    Menu menu = new Menu();

                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String paths, List<Menu> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(Path.THUC_AN.getPath());

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (Menu mon : items) {
                        printWriter.println(mon.getMaMenu());
                        // printWriter.println(mon.getListThucAn());
                        // printWriter.println(mon.getListThucUong());
                        printWriter.println(mon.getTongGia());
                    }

                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }

    @Override
    public void hienThi() {
        for (Menu menu : listMenu) {
            System.out.printf("-------------- Menu ----------------");

            System.out.printf("Ma Menu:", menu.getMaMenu());
            for (ThucAn thucAn : menu.getListThucAn()) {
                System.out.printf("Ma mon an:", thucAn.getMa());
                System.out.printf("Ten mon an:", thucAn.getTen());
                System.out.printf("Mon chay:", thucAn.getMonChay() == true ? "Co" : "Khong");
                System.out.printf("Gia", thucAn.getGia());
            }
            System.out.println();
            for (ThucUong thucUong : menu.getListThucUong()) {
                System.out.printf("Ma thuc uong:", thucUong.getMa());
                System.out.printf("Ten thuc uong:", thucUong.getTen());
                System.out.printf("Hang san xuat:", thucUong.getHangSanXuat());
                System.out.printf("Gia", thucUong.getGia());
            }
            System.out.printf("Tong gia Menu", menu.getTongGia());

        }

    }

    @Override
    public void hienThi(List<Menu> items) {

    }
}
