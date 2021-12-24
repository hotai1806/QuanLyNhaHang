package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.ThucAn;
import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.DAL.ThongTinThue;

import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThue implements IDocGhi<ThongTinThue> {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy");
    private final Calendar CALENDAR = new GregorianCalendar();

    private List<ThongTinThue> dsThongTinThue = new ArrayList<>();

    public QuanLyThue() {
        doc(Path.THONG_TIN_THUE.getPath());
    }

    public boolean thue(ThongTinThue thongTinThue) {
        this.dsThongTinThue.add(thongTinThue);

        return ghi(Path.THONG_TIN_THUE.getPath(), this.dsThongTinThue);
    }

    public void xemDoanhThuThang(String nam) throws ParseException {
        CALENDAR.setTime(DATE_FORMATER.parse(nam));

        List<ThongTinThue> dsThongTinThue = getThongTinThueTheoNam(CALENDAR.get(Calendar.YEAR));

        for (int i = 1; i <= 12; i++) {
            BigDecimal doanhThu = new BigDecimal(0);

            for (ThongTinThue thongTinThue : dsThongTinThue) {
                if (thongTinThue.getThangThue() == i) {
                    doanhThu = doanhThu.add(thongTinThue.getTongGia());
                }
            }

            System.out.println("Doanh thu thang: " + i + " " + doanhThu);
        }
    }

    public void xemDoanhThuQuy(String nam) throws ParseException {
        CALENDAR.setTime(DATE_FORMATER.parse(nam));

        List<ThongTinThue> dsThongTinThue = getThongTinThueTheoNam(CALENDAR.get(Calendar.YEAR));

        BigDecimal doanhThuQ1 = new BigDecimal(0);
        BigDecimal doanhThuQ2 = new BigDecimal(0);
        BigDecimal doanhThuQ3 = new BigDecimal(0);
        BigDecimal doanhThuQ4 = new BigDecimal(0);

        for (ThongTinThue thongTinThue : dsThongTinThue) {
            switch (thongTinThue.getThangThue()) {
                case 1:
                case 2:
                case 3:
                    doanhThuQ1 = doanhThuQ1.add(thongTinThue.getTongGia());
                    break;
                case 4:
                case 5:
                case 6:
                    doanhThuQ2 = doanhThuQ2.add(thongTinThue.getTongGia());
                    break;
                case 7:
                case 8:
                case 9:
                    doanhThuQ3 = doanhThuQ3.add(thongTinThue.getTongGia());
                    break;
                case 10:
                case 11:
                case 12:
                    doanhThuQ4 = doanhThuQ4.add(thongTinThue.getTongGia());
                    break;
                default:
                    break;
            }
        }

        System.out.println("Quy 1: " + doanhThuQ1);
        System.out.println("Quy 2: " + doanhThuQ2);
        System.out.println("Quy 3: " + doanhThuQ3);
        System.out.println("Quy 4: " + doanhThuQ4);
    }

    private List<ThongTinThue> getThongTinThueTheoNam(int nam) {
        return this.dsThongTinThue.stream()
                .filter(p -> p.getNamThue() == nam)
                .collect(Collectors.toList());
    }

    public void xuatHoaDon(ThongTinThue thongTinThue) {
        System.out.println("Ma thue: " + thongTinThue.getMaThue());
        System.out.println("Tiec: " + thongTinThue.getTenTiec());
        System.out.println("Ngay thue: " + thongTinThue.getNgayThue());
        System.out.println("Thoi diem thue: " + thongTinThue.getThoiDiemThue().toString());
        System.out.println("Sanh cuoi: " + thongTinThue.getSanhCuoi().getTenSC());
        System.out.println("Don gia thue sanh: " + thongTinThue.getDonGiaThueSanh());

        System.out.println("------------------------------");

        for (int i = 0; i < thongTinThue.getMenu().size(); i++) {
            System.out.println("Menu ban: " + i);

            System.out.print("Thuc an: ");
            for (ThucAn thucAn : thongTinThue.getMenu().get(i).getListThucAn()) {
                System.out.print(thucAn.getTen() + " ");
            }

            System.out.print("\nThuc uong: ");
            for (ThucUong thucUong : thongTinThue.getMenu().get(i).getListThucUong()) {
                System.out.print(thucUong.getTen() + " ");
            }

            System.out.println("\n------------------------------------");
        }

        System.out.println("Tong don gia menu: " + thongTinThue.getTongDonGiaMenu());

        System.out.println("------------------------------");

        System.out.print("Dich vu: ");
        for (DichVu dichVu : thongTinThue.getDichVu()) {
            System.out.print(dichVu.getTen() + " ");
        }

        System.out.println("\n------------------------------------");

        System.out.println("Tong don gia dich vu: " + thongTinThue.getDonGiaDichVu());

        System.out.println("===================================");

        System.out.println("Tong don gia  " + thongTinThue.getTongGia());
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

                    String menuStringCheck = scanner.nextLine();
                    while (menuStringCheck.equals("Menu")) {
                        Menu menu = new Menu();

                        String thucAnStringCheck = scanner.nextLine();
                        while (!thucAnStringCheck.equals(".")) {
                            if (!thucAnStringCheck.equals(".") && !thucAnStringCheck.equals("Thuc an")) {
                                menu.getListThucAn().add(QuanLyThucAn.timByTen(thucAnStringCheck).get(0));
                            }

                            thucAnStringCheck = scanner.nextLine();
                        }

                        String thucUongStringCheck = scanner.nextLine();
                        while (!thucUongStringCheck.equals(".")) {
                            if (!thucUongStringCheck.equals(".") && !thucUongStringCheck.equals("Thuc uong")) {
                                menu.getListThucUong().add(QuanLyThucUong.timTheoTen(thucUongStringCheck));
                            }

                            thucUongStringCheck = scanner.nextLine();
                        }

                        scanner.nextLine();

                        thongTinThue.getMenu().add(menu);
                        menuStringCheck = scanner.nextLine();
                    }

                    thongTinThue.setTongDonGiaMenu(new BigDecimal(menuStringCheck));

                    String dichVuStringCheck = scanner.nextLine();
                    while (!dichVuStringCheck.equals(".")) {
                        if (!dichVuStringCheck.equals(".") && !dichVuStringCheck.equals("Dich vu")) {
                            thongTinThue.getDichVu().add(QuanLyDichVu.timByTen(dichVuStringCheck).get(0));
                        }

                        dichVuStringCheck = scanner.nextLine();
                    }

                    this.dsThongTinThue.add(thongTinThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay so cuoi tu ma thue lam bien dem
                ThongTinThue.dem = this.dsThongTinThue.get(this.dsThongTinThue.size() - 1).getMaThue();

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
                        printWriter.println(thongTinThue.getThoiDiemThue());
                        printWriter.println(thongTinThue.getSanhCuoi().getMaSC());
                        printWriter.println(thongTinThue.getDonGiaThueSanh());

                        for (Menu menu : thongTinThue.getMenu()) {
                            printWriter.println("Menu");

                            printWriter.println("Thuc an");
                            if (!menu.getListThucAn().isEmpty()) {
                                for (ThucAn thucAn : menu.getListThucAn()) {
                                    printWriter.println(thucAn.getTen());
                                }
                            } else {
                                printWriter.println(".");
                            }
                            printWriter.println(".");

                            printWriter.println("Thuc uong");
                            if (!menu.getListThucUong().isEmpty()) {
                                for (ThucUong thucUong : menu.getListThucUong()) {
                                    printWriter.println(thucUong.getTen());
                                }
                            }

                            printWriter.println(".");
                            printWriter.println(".");
                        }

                        printWriter.println(thongTinThue.getTongDonGiaMenu());

                        printWriter.println("Dich vu");
                        if (!thongTinThue.getDichVu().isEmpty()) {
                            for (DichVu dichVu : thongTinThue.getDichVu()) {
                                printWriter.println(dichVu.getTen());
                            }
                        } else {
                            printWriter.println(".");
                        }
                        printWriter.println(".");

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
}