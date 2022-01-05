package com.huongdoituong.Views;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.BLL.QuanLyGiaThue;
import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;
import com.huongdoituong.BLL.QuanLyThue;

import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;

public class ViewThue {
    private QuanLySanhCuoi quanLySanhCuoi;
    private QuanLyDichVu quanLyDichVu;
    private QuanLyThucAn quanLyThucAn;
    private QuanLyThucUong quanLyThucUong;
    private QuanLyGiaThue quanLyGiaThue;

    public ViewThue(QuanLySanhCuoi quanLySanhCuoi, QuanLyDichVu quanLyDichVu,
            QuanLyThucAn quanLyThucAn, QuanLyThucUong quanLyThucUong, QuanLyGiaThue quanLyGiaThue) {
        this.quanLySanhCuoi = quanLySanhCuoi;
        this.quanLyDichVu = quanLyDichVu;
        this.quanLyThucAn = quanLyThucAn;
        this.quanLyThucUong = quanLyThucUong;
        this.quanLyGiaThue = quanLyGiaThue;
    }

    public void thue(Scanner scanner, QuanLyThue quanLyThue) {
        ThongTinThue thongTinThue = new ThongTinThue();

        try {
            themTenTiec(scanner, thongTinThue);
            themNgayThue(scanner, thongTinThue);
            themThoiDiemThue(scanner, thongTinThue);

            SanhCuoi sanhCuoi = themSanhCuoiDuocThue(scanner, thongTinThue);
            themMenuMoiBan(scanner, thongTinThue, sanhCuoi);
            themDichVu(scanner, thongTinThue);

            quanLyThue.thue(thongTinThue);
            thongTinThue.xuatHoaDon();

            // Tang so lan thue sanh --------------------------------------------------
            quanLySanhCuoi.tangSoLanThue(sanhCuoi);
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("Ngay thue khong phu hop!");
            System.out.println("====================================");
        }
    }

    private void themDichVu(Scanner scanner, ThongTinThue thongTinThue) {
        while (true) {
            System.out.println("1. Them dich vu");
            System.out.println("2. Tiep tuc");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1": {
                    quanLyDichVu.hienThi();

                    System.out.print("Nhap ma dich vu: ");
                    DichVu dichVu = quanLyDichVu.timById(Integer.parseInt(scanner.nextLine()));

                    if (!thongTinThue.kiemTraDichVuTrungLap(dichVu)) {
                        thongTinThue.getDichVu().add(dichVu);
                    } else {
                        System.out.println("Dich vu bi trung!");
                    }

                    System.out.println("------------------------------------");
                    continue;
                }
                case "2": {
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

    private void themMenuMoiBan(Scanner scanner, ThongTinThue thongTinThue, SanhCuoi sanhCuoi) {
        boolean chooseCheck;

        for (int i = 0; i < sanhCuoi.getSucChua(); i++) {
            Menu menu = new Menu();

            chooseCheck = false;

            while (!chooseCheck) {
                System.out.println("Menu ban so " + i);
                System.out.println("------------------------------------");

                themThucAn(scanner, thongTinThue, menu);
                themThucUong(scanner, thongTinThue, menu);

                thongTinThue.getDSMenu().add(menu);

                chooseCheck = true;
            }
        }
    }

    private void themThucAn(Scanner scanner, ThongTinThue thongTinThue, Menu menu) {
        while (true) {
            System.out.println("Them thuc an");
            System.out.println("1. Them");
            System.out.println("2. Tiep tuc");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("------------------------------------");
                    quanLyThucAn.hienThi();

                    System.out.print("Nhap ten thuc an: ");
                    menu.themThucAn(QuanLyThucAn.timByTen(scanner.nextLine()).get(0));

                    System.out.println("------------------------------------");
                    continue;
                }
                case "2": {
                    if (menu.getListThucAn().isEmpty()) {
                        System.out.println("------------------------------------");
                        System.out.println("*** Danh sach thuc an trong ***");
                        System.out.println("------------------------------------");

                        continue;
                    } else {
                        System.out.println("====================================");
                        return;
                    }
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private void themThucUong(Scanner scanner, ThongTinThue thongTinThue, Menu menu) {
        while (true) {
            System.out.println("Them thuc uong");
            System.out.println("1. Them");
            System.out.println("2. Tiep tuc");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("------------------------------------");
                    quanLyThucUong.hienThi();

                    System.out.print("Nhap ten thuc uong: ");
                    menu.themThucUong(QuanLyThucUong.timTheoTen(scanner.nextLine()));

                    System.out.println("------------------------------------");
                    continue;
                }
                case "2": {
                    if (menu.getListThucUong().isEmpty()) {
                        System.out.println("------------------------------------");
                        System.out.println("*** Danh sach thuc uong trong ***");
                        System.out.println("------------------------------------");

                        continue;
                    } else {
                        System.out.println("====================================");
                        return;
                    }
                }
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }
    }

    private SanhCuoi themSanhCuoiDuocThue(Scanner scanner, ThongTinThue thongTinThue) throws ParseException {
        SanhCuoi sanhCuoi;
        boolean chooseCheck = false;

        while (!chooseCheck) {
            System.out.println("1. Danh sach sanh");
            System.out.println("2. Tim kiem sanh");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1":
                    quanLySanhCuoi.hienThi(quanLySanhCuoi.traCuuTatCa());
                    chooseCheck = true;

                    break;
                case "2":
                    System.out.print("Nhap tu khoa can tim(ten, suc chua, vi tri...): ");
                    List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(scanner.nextLine());

                    quanLySanhCuoi.hienThi(listSanhCuoi);
                    chooseCheck = true;

                    break;
                default:
                    System.out.println("====================================");
                    System.out.println("*** Lua chong khong kha dung ***");
                    System.out.println("====================================");

                    continue;
            }
        }

        System.out.print("Nhap ten sanh cuoi muon chon: ");
        sanhCuoi = quanLySanhCuoi.traCuuBangTen(scanner.nextLine());
        thongTinThue.setSanhCuoi(sanhCuoi);
        System.out.println("====================================");

        // Them don gia thue sanh -------------------------------------------------
        sanhCuoi.setGia(quanLyGiaThue.getGia(thongTinThue.getNgayThueString()));
        thongTinThue.setDonGiaThueSanh(sanhCuoi.getGia());

        return sanhCuoi;
    }

    private void themThoiDiemThue(Scanner scanner, ThongTinThue thongTinThue) throws Exception {
        System.out.println("Thoi diem thue: ");
        System.out.println("Sang");
        System.out.println("Chieu");
        System.out.println("Toi");
        System.out.println("------------------------------------");
        System.out.print("Nhap thoi diem muon thue: ");
        thongTinThue.setThoiDiemThue(scanner.nextLine());
        System.out.println("====================================");
    }

    private void themNgayThue(Scanner scanner, ThongTinThue thongTinThue) throws ParseException {
        System.out.print("Ngay thue: ");
        thongTinThue.setNgayThue(scanner.nextLine());
        System.out.println("====================================");
    }

    private void themTenTiec(Scanner scanner, ThongTinThue thongTinThue) {
        System.out.print("Ten tiec: ");
        thongTinThue.setTenTiec(scanner.nextLine());
        System.out.println("====================================");
    }
}