package com.huongdoituong;

import java.math.BigDecimal;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;

import com.huongdoituong.DAL.Karaoke;

import com.huongdoituong.Views.ViewDichVu;
import com.huongdoituong.Views.ViewSanh;
import com.huongdoituong.Views.ViewThucAn;
import com.huongdoituong.Views.ViewThucUong;
import com.huongdoituong.Views.ViewThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String YEAR_REGEX = "^\\d{4}$";

    private static QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
    private static QuanLyThucAn quanLyThucAn = new QuanLyThucAn();
    private static QuanLyThucUong quanLyThucUong = new QuanLyThucUong();
    private static QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
    private static QuanLyThue quanLyThue;

    public static void main(String[] args) {
        Karaoke karaoke = new Karaoke();
        karaoke.setThoiGianThue(1);
        karaoke.setGia(new BigDecimal(30));
        quanLyDichVu.them(karaoke);

        quanLyThue = new QuanLyThue();
        while (true) {
            System.out.println("Quan ly nha hang");
            System.out.println("1. Thue sanh");
            System.out.println("2. Quan ly");
            System.out.println("3. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    System.out.println("====================================");
                    Thue();

                    break;
                }
                case "2": {
                    System.out.println("====================================");
                    menuQuanLy();

                    break;
                }
                case "3": {
                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void Thue() {
        ViewThue viewThue = new ViewThue(quanLySanhCuoi, quanLyDichVu, quanLyThucAn, quanLyThucUong);
        viewThue.thue(SCANNER, quanLyThue);
    }

    private static void menuQuanLy() {
        while (true) {
            System.out.println("Quan ly");
            System.out.println("1. Doanh thu");
            System.out.println("2. Sanh");
            System.out.println("3. Dich vu");
            System.out.println("4. Thuc an");
            System.out.println("5. Thuc uong");
            System.out.println("6. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    System.out.println("====================================");
                    menuQuanLyDoanhThu();

                    break;
                }
                case "2": {
                    System.out.println("====================================");
                    menuQuanLySanh();

                    break;
                }
                case "3": {
                    System.out.println("====================================");
                    menuQuanLyDichVu();

                    break;
                }
                case "4": {
                    System.out.println("====================================");
                    menuQuanLyThucAn();

                    break;
                }
                case "5": {
                    System.out.println("====================================");
                    menuQuanLyThucUong();

                    break;
                }
                case "6": {
                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyDoanhThu() {
        while (true) {
            System.out.println("Quan ly doanh thu");
            System.out.println("1. Xem doanh thu thang");
            System.out.println("2. Xem doanh thu quy");
            System.out.println("3. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    String nam = "";
                    while (!nam.matches(YEAR_REGEX)) {
                        System.out.print("Nhap nam can xem doanh thu thang: ");
                        nam = SCANNER.nextLine();
                    }

                    quanLyThue.xemDoanhThuThang(nam);
                    System.out.println("====================================");

                    break;
                }
                case "2": {
                    String nam = "";

                    while (!nam.matches(YEAR_REGEX)) {
                        System.out.print("Nhap nam can xem doanh thu quy: ");
                        nam = SCANNER.nextLine();
                    }

                    quanLyThue.xemDoanhThuQuy(nam);
                    System.out.println("====================================");

                    break;
                }
                case "3": {
                    System.out.println("====================================");

                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLySanh() {
        ViewSanh viewSanh = new ViewSanh();

        while (true) {
            System.out.println("Quan ly sanh");
            System.out.println("1. Them sanh");
            System.out.println("2. Cap nhat sanh");
            System.out.println("3. Xoa sanh");
            System.out.println("4. Tra cuu sanh");
            System.out.println("5. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    viewSanh.themView(SCANNER, quanLySanhCuoi);
                    break;
                }
                case "2": {
                    viewSanh.capNhatView(SCANNER, quanLySanhCuoi);
                    break;
                }
                case "3": {
                    viewSanh.xoaView(SCANNER, quanLySanhCuoi);
                    break;
                }
                case "4": {
                    viewSanh.traCuuView(SCANNER, quanLySanhCuoi);
                    break;
                }
                case "5": {
                    System.out.println("====================================");

                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyDichVu() {
        ViewDichVu view = new ViewDichVu();

        while (true) {
            System.out.println("Quan ly dich vu");
            System.out.println("1. Them dich vu");
            System.out.println("2. Cap nhat dich vu");
            System.out.println("3. Xoa dich vu");
            System.out.println("4. Tra cuu dich vu");
            System.out.println("5. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    view.themView(SCANNER, quanLyDichVu);

                    break;
                }
                case "2": {
                    view.capNhatView(SCANNER, quanLyDichVu);
                    break;
                }
                case "3": {
                    view.xoaView(SCANNER, quanLyDichVu);
                    break;
                }
                case "4": {
                    view.traCuuView(SCANNER, quanLyDichVu);
                    break;
                }
                case "5": {
                    System.out.println("====================================");

                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyThucAn() {
        ViewThucAn view = new ViewThucAn();

        while (true) {
            System.out.println("Quan ly thuc an");
            System.out.println("1. Them thuc an");
            System.out.println("2. Cap nhat thuc an");
            System.out.println("3. Xoa thuc an");
            System.out.println("4. Tra cuu thuc an");
            System.out.println("5. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    view.themView(SCANNER, quanLyThucAn);
                    break;
                }
                case "2": {
                    view.capNhatView(SCANNER, quanLyThucAn);
                    break;
                }
                case "3": {
                    view.xoaView(SCANNER, quanLyThucAn);
                    break;
                }
                case "4": {
                    view.traCuuView(SCANNER, quanLyThucAn);
                    break;
                }
                case "5": {
                    System.out.println("====================================");

                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyThucUong() {
        ViewThucUong view = new ViewThucUong();

        while (true) {
            System.out.println("Quan ly thuc uong");
            System.out.println("1. Them thuc uong");
            System.out.println("2. Cap nhat thuc uong");
            System.out.println("3. Xoa thuc uong");
            System.out.println("4. Tra cuu thuc uong");
            System.out.println("5. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    view.themView(SCANNER, quanLyThucUong);
                    break;
                }
                case "2": {
                    view.capNhatView(SCANNER, quanLyThucUong);
                    break;
                }
                case "3": {
                    view.xoaView(SCANNER, quanLyThucUong);
                    break;
                }
                case "4": {
                    view.traCuuView(SCANNER, quanLyThucUong);
                    break;
                }
                case "5": {
                    System.out.println("====================================");

                    return;
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }
}