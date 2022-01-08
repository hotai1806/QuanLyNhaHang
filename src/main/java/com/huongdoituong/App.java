package com.huongdoituong;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.BLL.QuanLyGiaThue;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;

import com.huongdoituong.Views.ViewDichVu;
import com.huongdoituong.Views.ViewDoanhThu;
import com.huongdoituong.Views.ViewGiaThue;
import com.huongdoituong.Views.ViewSanh;
import com.huongdoituong.Views.ViewThucAn;
import com.huongdoituong.Views.ViewThucUong;
import com.huongdoituong.Views.ViewThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static QuanLyGiaThue quanLyGiaThue = new QuanLyGiaThue();
    private static QuanLyThucAn quanLyThucAn = new QuanLyThucAn();
    private static QuanLyThucUong quanLyThucUong = new QuanLyThucUong();
    private static QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
    private static QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi(quanLyGiaThue);
    private static QuanLyThue quanLyThue = new QuanLyThue(quanLySanhCuoi, quanLyDichVu,
            quanLyThucAn, quanLyThucUong);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Quan ly nha hang");
            System.out.println("1. Thue sanh");
            System.out.println("2. Quan ly");
            System.out.println("0. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    return;
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
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void Thue() {
        ViewThue viewThue = new ViewThue(quanLySanhCuoi, quanLyDichVu,
                quanLyThucAn, quanLyThucUong, quanLyGiaThue);

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
            System.out.println("6. Gia thue");
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    menuQuanLyDoanhThu();
                    break;
                case "2":
                    System.out.println("====================================");
                    menuQuanLySanh();
                    break;
                case "3":
                    System.out.println("====================================");
                    menuQuanLyDichVu();
                    break;
                case "4":
                    System.out.println("====================================");
                    menuQuanLyThucAn();
                    break;
                case "5":
                    System.out.println("====================================");
                    menuQuanLyThucUong();
                    break;
                case "6":
                    System.out.println("====================================");
                    menuQuanLyGiaThue();
                    break;
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyDoanhThu() {
        ViewDoanhThu viewDoanhThu = new ViewDoanhThu();

        while (true) {
            System.out.println("Quan ly doanh thu");
            System.out.println("1. Xem doanh thu thang");
            System.out.println("2. Xem doanh thu quy");
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    viewDoanhThu.xemDoanhThuThangView(SCANNER, quanLyThue);

                    break;
                case "2":
                    System.out.println("====================================");
                    viewDoanhThu.xemDoanhThuQuyView(SCANNER, quanLyThue);

                    break;
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
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    viewSanh.themView(SCANNER, quanLySanhCuoi);

                    break;
                case "2":
                    System.out.println("====================================");
                    viewSanh.capNhatView(SCANNER, quanLySanhCuoi);

                    break;
                case "3":
                    System.out.println("====================================");
                    viewSanh.xoaView(SCANNER, quanLySanhCuoi);

                    break;
                case "4":
                    System.out.println("====================================");
                    viewSanh.traCuuView(SCANNER, quanLySanhCuoi);

                    break;
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
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    view.themView(SCANNER, quanLyDichVu);

                    break;
                case "2":
                    System.out.println("====================================");
                    view.capNhatView(SCANNER, quanLyDichVu);

                    break;
                case "3":
                    System.out.println("====================================");
                    view.xoaView(SCANNER, quanLyDichVu);

                    break;
                case "4":
                    System.out.println("====================================");
                    view.traCuuView(SCANNER, quanLyDichVu);

                    break;
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
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    view.themView(SCANNER, quanLyThucAn);

                    break;
                case "2":
                    System.out.println("====================================");
                    view.capNhatView(SCANNER, quanLyThucAn);

                    break;
                case "3":
                    System.out.println("====================================");
                    view.xoaView(SCANNER, quanLyThucAn);

                    break;
                case "4":
                    System.out.println("====================================");
                    view.traCuuView(SCANNER, quanLyThucAn);

                    break;
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
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    view.themView(SCANNER, quanLyThucUong);

                    break;
                case "2":
                    System.out.println("====================================");
                    view.capNhatView(SCANNER, quanLyThucUong);

                    break;
                case "3":
                    System.out.println("====================================");
                    view.xoaView(SCANNER, quanLyThucUong);

                    break;
                case "4":
                    System.out.println("====================================");
                    view.traCuuView(SCANNER, quanLyThucUong);

                    break;
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private static void menuQuanLyGiaThue() {
        ViewGiaThue view = new ViewGiaThue();

        while (true) {
            System.out.println("Quan ly gia thue");
            System.out.println("1. Them gia thue");
            System.out.println("0. Tro lai");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "0":
                    System.out.println("====================================");
                    return;
                case "1":
                    System.out.println("====================================");
                    view.themView(SCANNER, quanLyGiaThue);
                    break;
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }
}