package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.App.DichVu;
import com.huongdoituong.App.Menu;
import com.huongdoituong.App.QLDichVu;
import com.huongdoituong.App.QLThucAn;
import com.huongdoituong.App.QLThucUong;
import com.huongdoituong.App.ThucAn;
import com.huongdoituong.App.ThucUong;
import com.huongdoituong.DAL.ThongTinThue;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThue implements IDocGhi<ThongTinThue> {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy");
    private final Calendar CALENDAR = new GregorianCalendar();

    private List<ThongTinThue> listThongTinThue = new ArrayList<>();

    public QuanLyThue() {
        doc(Path.THONG_TIN_THUE.getPath());
    }

    public boolean thue(ThongTinThue thongTinThue) {
        this.listThongTinThue.add(thongTinThue);

        return ghi(Path.THONG_TIN_THUE.getPath(), this.listThongTinThue);
    }

    public void xemDoanhThuThang(String nam) throws ParseException {
        Date date = DATE_FORMATER.parse(nam);
        CALENDAR.setTime(date);

        List<ThongTinThue> dsThongTinThue = getThongTinThueTheoNam(CALENDAR.get(Calendar.YEAR));

        for (int i = 1; i <= 12; i++) {
            BigDecimal doanhThu = new BigDecimal(0);

            for (ThongTinThue thongTinThue : dsThongTinThue) {
                if (thongTinThue.getThang() == i) {
                    doanhThu = doanhThu.add(thongTinThue.getTongGia());
                }

                System.out.println("Doanh thu thang: " + i + " " + doanhThu);
            }
        }
    }

    public void xemDoanhThuQuy(String nam) throws ParseException {
        Date date = DATE_FORMATER.parse(nam);
        CALENDAR.setTime(date);

        List<ThongTinThue> dsThongTinThue = getThongTinThueTheoNam(CALENDAR.get(Calendar.YEAR));

        BigDecimal doanhThuQ1 = new BigDecimal(0);
        BigDecimal doanhThuQ2 = new BigDecimal(0);
        BigDecimal doanhThuQ3 = new BigDecimal(0);
        BigDecimal doanhThuQ4 = new BigDecimal(0);

        for (ThongTinThue thongTinThue : dsThongTinThue) {
            switch (thongTinThue.getThang()) {
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
        List<ThongTinThue> dsThongTinThue = new ArrayList<>();

        for (ThongTinThue thongTinThue : listThongTinThue) {
            if (thongTinThue.getNam() == nam) {
                dsThongTinThue.add(thongTinThue);
            }
        }

        return dsThongTinThue;
    }

    public void xuatHoaDon(ThongTinThue thongTinThue) {
        System.out.println("Ma thue: " + thongTinThue.getMaThue());
        System.out.println("Tiec: " + thongTinThue.getTenTiec());
        System.out.println("Ngay thue: " + thongTinThue.getNgayThue());
        System.out.println("Thoi diem thue: " + thongTinThue.getThoiDiemThue().toString());
        System.out.println("Sanh cuoi: " + thongTinThue.getSanhCuoi().getTenSC());
        System.out.println("Don gia thue sanh: " + thongTinThue.getDonGiaThueSanh());

        System.out.println("==============================");

        for (int i = 0; i < thongTinThue.getMenu().size(); i++) {
            System.out.println("Menu ban: " + i);

            System.out.print("Thuc an: ");
            for (ThucAn thucAn : thongTinThue.getMenu().get(i).dsThucAn) {
                System.out.print(thucAn.ten + " ");
            }

            System.out.print("\nThuc uong: ");
            for (ThucUong thucUong : thongTinThue.getMenu().get(i).dsThucUong) {
                System.out.print(thucUong.ten + " ");
            }

            System.out.println("\n------------------------------------");
        }

        System.out.println("Tong don gia menu: " + thongTinThue.getTongDonGiaMenu());

        System.out.println("==================================");

        System.out.print("Dich vu: ");
        for (DichVu dichVu : thongTinThue.getDichVu()) {
            System.out.print(dichVu.ten + " ");
        }

        System.out.println("\n------------------------------------");

        System.out.println("Tong don gia dich vu: " + thongTinThue.getDonGiaDichVu());

        System.out.println("===================================");
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
                    while (menuStringCheck.equals("Menu {")) {
                        Menu menu = new Menu();

                        while (!scanner.nextLine().equals("}")) {
                            String thucAnStringCheck = scanner.nextLine();

                            if (!thucAnStringCheck.equals(" ")) {
                                menu.dsThucAn.add(QLThucAn.getThucAnBangTen(thucAnStringCheck));
                            }
                        }

                        while (!scanner.nextLine().equals("}")) {
                            String thucUongStringCheck = scanner.nextLine();

                            if (!thucUongStringCheck.equals(" ")) {
                                menu.dsThucUong.add(QLThucUong.getThucUongBangTen(thucUongStringCheck));
                            }
                        }

                        scanner.nextLine();

                        thongTinThue.getMenu().add(menu);
                        menuStringCheck = scanner.nextLine();
                    }

                    thongTinThue.setTongDonGiaMenu(new BigDecimal(menuStringCheck));

                    while (!scanner.nextLine().equals("}")) {
                        String dichVuStringCheck = scanner.nextLine();

                        if (!dichVuStringCheck.equals(" ")) {
                            thongTinThue.getDichVu().add(QLDichVu.getDichVuBangTen(dichVuStringCheck));
                        }
                    }

                    listThongTinThue.add(thongTinThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay so cuoi tu ma thue lam bien dem
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
                        printWriter.println(thongTinThue.getThoiDiemThue());
                        printWriter.println(thongTinThue.getSanhCuoi().getMaSC());
                        printWriter.println(thongTinThue.getDonGiaThueSanh());

                        for (Menu menu : thongTinThue.getMenu()) {
                            printWriter.println("Menu {");

                            printWriter.println("Thuc an {");
                            if (!menu.dsThucAn.isEmpty()) {
                                for (ThucAn thucAn : menu.dsThucAn) {
                                    printWriter.println(thucAn.ten);
                                }
                            } else {
                                printWriter.println(" ");
                            }
                            printWriter.println("}");

                            printWriter.println("Thuc uong {");
                            if (!menu.dsThucUong.isEmpty()) {
                                for (ThucUong thucUong : menu.dsThucUong) {
                                    printWriter.println(thucUong.ten);
                                }
                            } else {
                                printWriter.println(" ");
                            }
                            printWriter.println("}");
                            printWriter.println("}");
                        }

                        printWriter.println(thongTinThue.getTongDonGiaMenu());

                        printWriter.println("Dich vu {");
                        if (!thongTinThue.getDichVu().isEmpty()) {
                            for (DichVu dichVu : thongTinThue.getDichVu()) {
                                printWriter.println(dichVu.ten);
                            }
                        } else {
                            printWriter.println(" ");
                        }
                        printWriter.println("}");

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
