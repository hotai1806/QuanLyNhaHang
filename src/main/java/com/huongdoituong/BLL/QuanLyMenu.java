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

public class QuanLyMenu implements IDocGhi<Menu>, BaseInterfaceQuanLy<Menu> {
    private List<Menu> listMenu = new ArrayList<>();

    public QuanLyMenu() {

    }

    public Menu timById(int ma) {
        return listMenu.stream().filter(p -> p.getMaMenu() == ma).findFirst().get();
    }

    @Override
    public boolean them(Menu menu) {
        return this.listMenu.add(menu);
    }

    @Override
    public boolean xoa(String id) {
        return this.listMenu.removeIf(element -> element.getMaMenu() == Integer.parseInt(id));
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
        if (!this.listMenu.isEmpty()) {
            for (Menu menu : this.listMenu) {
                System.out.println("-------------- Menu ----------------");
                System.out.println("Ma menu:" + String.format("%s", menu.getMaMenu()));
                if (!menu.getListThucAn().isEmpty()) {
                    for (ThucAn thucAn : menu.getListThucAn()) {
                        thucAn.hienThi();
                    }
                }

                if (!menu.getListThucUong().isEmpty()) {
                    for (ThucUong thucUong : menu.getListThucUong()) {
                        thucUong.hienThi();
                    }
                }
                System.out.println("Ma dich vu:" + String.format("%s", menu.getTongGia()));

            }
        }
    }

    @Override
    public void hienThi(List<Menu> listMenu) {
        if (!listMenu.isEmpty()) {
            for (Menu menu : listMenu) {
                System.out.println("-------------- Menu ----------------");
                System.out.println("Ma menu:" + String.format("%s", menu.getMaMenu()));
                if (!menu.getListThucAn().isEmpty()) {
                    for (ThucAn thucAn : menu.getListThucAn()) {
                        thucAn.hienThi();
                    }
                }

                if (!menu.getListThucUong().isEmpty()) {
                    for (ThucUong thucUong : menu.getListThucUong()) {
                        thucUong.hienThi();
                    }
                }
                System.out.println("Ma dich vu:" + String.format("%s", menu.getTongGia()));

            }
        }
    }

    @Override
    public boolean capNhat(String maMenu, Scanner scanner) {
        Menu menu = this.timById(Integer.parseInt(maMenu));
        if (menu != null) {
            try {
                System.out.println("Ma menu: ");
                menu.setMaMenu(Integer.parseInt(maMenu));
                for (ThucAn thucAn : menu.getListThucAn()) {
                    thucAn.hienThi();
                }

                System.out.println("Chon thuc an can cap nhat:");
                ThucAn thucAn = menu.timThucAn(scanner.nextInt());
                System.out.println("Ten cu " + thucAn.getTen());
                System.out.println("Doi ten:");
                thucAn.setTen(scanner.nextLine());
                if (thucAn.isMonChay()) {
                    System.out.println("Mon chay, doi thanh mon khong chay nhan phim 0");

                    thucAn.setMonChay(scanner.nextInt() == 1 ? true : false);
                }
                System.out.println("Doi gia(gia cu" + thucAn.getGia() + "):");

                thucAn.setGia(new BigDecimal(scanner.nextInt()));

                for (ThucUong thucUong : menu.getListThucUong()) {
                    thucUong.hienThi();
                }

                System.out.println("Chon thuc an can cap nhat:");
                ThucUong thucUong = menu.timThucUong(scanner.nextInt());
                System.out.println("Ten cu " + thucUong.getTen());
                System.out.println("Doi ten:");
                thucUong.setTen(scanner.nextLine());
                System.out.println("Hang sang xuat(" + thucUong.getHangSanXuat() + "):");
                thucUong.setHangSanXuat(scanner.nextLine());
                System.out.println("Doi gia(gia cu" + thucUong.getGia() + "):");

                thucUong.setGia(new BigDecimal(scanner.nextInt()));

            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return false;
    }

    // @Override
    // public boolean xoa(int ma) {
    // DichVu dichVu = timById(ma);
    // if (dichVu != null) {
    // QuanLyDichVu.listDichVu.remove(dichVu);
    // return ghi(Path.DICH_VU.getPath(), QuanLyDichVu.listDichVu);
    // }
    // return false;
    // }

}
