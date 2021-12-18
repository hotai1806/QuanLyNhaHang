package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.ThucAn;
import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.DAL.ThongTinThue;


import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThue implements IDocGhi<ThongTinThue> {
    private List<ThongTinThue> listThongTinThue = new ArrayList<>();

    public QuanLyThue() {
        doc(Path.THONG_TIN_THUE.getPath());
    }

    public boolean themThongTinThue(ThongTinThue thongTinThue) {
        this.listThongTinThue.add(thongTinThue);

        return ghi(Path.THONG_TIN_THUE.getPath(), this.listThongTinThue);
    }

    @Override
    public void doc(String path) {
        File file = new File(Path.THONG_TIN_THUE.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThongTinThue thongTinThue = new ThongTinThue();

                    thongTinThue.setMaThue(scanner.nextInt());
                    scanner.nextLine();

                    thongTinThue.setTenTiec(scanner.nextLine());
                    thongTinThue.setNgayThue(scanner.nextLine());
                    thongTinThue.setThoiDiemThue(scanner.nextLine());
                    thongTinThue.setSanhCuoi(QuanLySanhCuoi.traCuuBangMaSC(scanner.nextLine()));

                    thongTinThue.setDonGiaThueSanh(scanner.nextBigDecimal());
                    scanner.nextLine();

                    String checkMenuString = scanner.nextLine();
                    while (checkMenuString.equals("Menu {")) {
                        Menu menu = new Menu();


                        while (!scanner.nextLine().equals("}")) {
                            menu.themThucAn(QuanLyThucAn.timTheoTen(scanner.nextLine()));
                        }

                        if (scanner.nextLine().equals("Thuc uong {")) {
                            scanner.nextLine();
                        }

                        while (!scanner.nextLine().equals("}")) {
                            menu.themThucUong(QuanLyThucUong.timTheoTen(scanner.nextLine()));
                        }

                        thongTinThue.getMenu().add(menu);
                        checkMenuString = scanner.nextLine();
                    }

                    thongTinThue.setDonGiaMenu(new BigDecimal(checkMenuString));

                    while (!scanner.nextLine().equals("}")) {
                        thongTinThue.getDichVu().add(QuanLyDichVu.timByTen(scanner.nextLine()));
                    }

                    listThongTinThue.add(thongTinThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay 3 so cuoi tu ma sanh cuoi S*** cuoi cung lam bien dem
                ThongTinThue.dem = this.listThongTinThue.get(this.listThongTinThue.size() - 1).getMaThue();

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThongTinThue> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(Path.THONG_TIN_THUE.getPath());

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (ThongTinThue thongTinThue : items) {
                        printWriter.println(thongTinThue.getMaThue());
                        printWriter.println(thongTinThue.getTenTiec());
                        printWriter.println(thongTinThue.getNgayThue());
                        printWriter.println(thongTinThue.getThoiDiemThue().toInt());
                        printWriter.println(thongTinThue.getSanhCuoi().getMaSC());
                        printWriter.println(thongTinThue.getDonGiaThueSanh());

                        for (Menu menu : thongTinThue.getMenu()) {
                            printWriter.println("Menu {");

                            printWriter.println("Thuc an {");
                            for (ThucAn thucAn : menu.getListThucAn()) {
                                printWriter.println(thucAn.getTen());
                            }
                            printWriter.println("}");

                            printWriter.println("Thuc uong {");
                            for (ThucUong thucUong : menu.getListThucUong()) {
                                printWriter.println(thucUong.getTen());
                            }
                            printWriter.println("}");
                            printWriter.println("}");
                        }

                        printWriter.println(thongTinThue.getDonGiaMenu());

                        printWriter.println("Dich vu {");
                        for (DichVu dichVu : thongTinThue.getDichVu()) {
                            printWriter.println(dichVu.getTen());
                            printWriter.println("}");
                        }

                        printWriter.println(thongTinThue.getDonGiaDichVu());
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

    }

    @Override
    public void hienThi(List<ThongTinThue> items) {

    }
}
