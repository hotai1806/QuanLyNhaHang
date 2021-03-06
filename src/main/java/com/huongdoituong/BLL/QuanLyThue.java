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

    {
        doc(Path.THONG_TIN_THUE.getPath());
    }

    public boolean thue(ThongTinThue thongTinThue) {
        this.dsThongTinThue.add(thongTinThue);

        return ghi(Path.THONG_TIN_THUE.getPath(), this.dsThongTinThue);
    }

    public void getDoanhThuThang(String nam) {
        try {
            CALENDAR.setTime(DATE_FORMATER.parse(nam));
            List<ThongTinThue> dsThongTinThue = getThongTinThueTheoNam(CALENDAR.get(Calendar.YEAR));

            for (int i = 1; i <= 12; i++) {
                BigDecimal doanhThu = new BigDecimal(0);

                for (ThongTinThue thongTinThue : dsThongTinThue) {
                    if (thongTinThue.getThangThue() == i) {
                        doanhThu = doanhThu.add(thongTinThue.getTongGia());
                    }
                }

                System.out.println("Doanh thu thang: " + i + " - " + doanhThu);
            }
        } catch (ParseException e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }
    }

    public void getDoanhThuQuy(String nam) {
        try {
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
        } catch (ParseException e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }

    }

    private List<ThongTinThue> getThongTinThueTheoNam(int nam) {
        return this.dsThongTinThue.stream()
                .filter(p -> p.getNamThue() == nam)
                .collect(Collectors.toList());
    }

    @Override
    public void doc(String path) {
        File file = new File(path);

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThongTinThue thongTinThue = new ThongTinThue();

                    thongTinThue.setMa(scanner.nextInt());
                    scanner.nextLine();

                    thongTinThue.setTen(scanner.nextLine());
                    thongTinThue.setNgayThue(scanner.nextLine());
                    thongTinThue.setThoiDiemThue(scanner.nextLine());
                    thongTinThue.setSanhCuoi(QuanLySanhCuoi.timByMa(scanner.nextLine()));

                    thongTinThue.setDonGiaThueSanh(scanner.nextBigDecimal());
                    scanner.nextLine();

                    // Them menu
                    String menuStringCheck = scanner.nextLine();
                    while (menuStringCheck.equals("Menu")) {
                        Menu menu = new Menu();

                        // Them thuc an
                        String thucAnStringCheck = scanner.nextLine();
                        while (!thucAnStringCheck.equals(".")) {
                            if (!thucAnStringCheck.equals("Thuc an")) {
                                menu.themThucAn(QuanLyThucAn.timByMa(Integer.parseInt(thucAnStringCheck)));
                            }

                            thucAnStringCheck = scanner.nextLine();
                        }

                        // Them thuc uong
                        String thucUongStringCheck = scanner.nextLine();
                        while (!thucUongStringCheck.equals(".")) {
                            if (!thucUongStringCheck.equals("Thuc uong")) {
                                menu.themThucUong(QuanLyThucUong
                                        .timByMa(Integer.parseInt(thucUongStringCheck)));
                            }

                            thucUongStringCheck = scanner.nextLine();
                        }

                        thongTinThue.getDSMenu().add(menu);
                        menuStringCheck = scanner.nextLine();
                    }

                    thongTinThue.setTongDonGiaMenu(new BigDecimal(menuStringCheck));

                    String dichVuStringCheck = scanner.nextLine();
                    while (!dichVuStringCheck.equals(".")) {
                        if (!dichVuStringCheck.equals("Dich vu")) {
                            thongTinThue.getDichVu()
                                    .add(QuanLyDichVu.timByMa(Integer.parseInt(dichVuStringCheck)));
                        }

                        dichVuStringCheck = scanner.nextLine();
                    }

                    this.dsThongTinThue.add(thongTinThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThongTinThue> dsThongTinThue) {
        if (!dsThongTinThue.isEmpty()) {
            try {
                File file = new File(path);

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (ThongTinThue thongTinThue : dsThongTinThue) {
                        printWriter.println(thongTinThue.getMa());
                        printWriter.println(thongTinThue.getTen());
                        printWriter.println(thongTinThue.getNgayThueString());
                        printWriter.println(thongTinThue.getThoiDiemThue());
                        printWriter.println(thongTinThue.getSanhCuoi().getMa());
                        printWriter.println(thongTinThue.getDonGiaThueSanh());

                        for (Menu menu : thongTinThue.getDSMenu()) {
                            printWriter.println("Menu");

                            printWriter.println("Thuc an");
                            if (!menu.getDSThucAn().isEmpty()) {
                                for (ThucAn thucAn : menu.getDSThucAn()) {
                                    printWriter.println(thucAn.getMa());
                                }
                            }

                            printWriter.println(".");

                            printWriter.println("Thuc uong");
                            if (!menu.getDSThucUong().isEmpty()) {
                                for (ThucUong thucUong : menu.getDSThucUong()) {
                                    printWriter.println(thucUong.getMa());
                                }
                            }

                            printWriter.println(".");
                        }

                        printWriter.println(thongTinThue.getTongDonGiaMenu());

                        printWriter.println("Dich vu");
                        if (!thongTinThue.getDichVu().isEmpty()) {
                            for (DichVu dichVu : thongTinThue.getDichVu()) {
                                printWriter.println(dichVu.getMa());
                            }
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