package com.huongdoituong.Views;

import java.math.BigDecimal;
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

            SanhCuoi sanhCuoi = themSanh(scanner, thongTinThue);
            themMenuMoiBan(scanner, thongTinThue, sanhCuoi);
            themDichVu(scanner, thongTinThue);

            quanLyThue.thue(thongTinThue);
            thongTinThue.xuatHoaDon();

            // Tang so lan thue sanh --------------------------------------------------
            sanhCuoi.setSoLanThue(sanhCuoi.getSoLanThue() + 1);

            quanLySanhCuoi.capNhatDS();
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("Loi nhap!");
            System.out.println("====================================");
        }
    }

    private void themTenTiec(Scanner scanner, ThongTinThue thongTinThue) {
        System.out.print("Ten tiec: ");
        thongTinThue.setTen(scanner.nextLine());
        System.out.println("====================================");
    }

    private void themNgayThue(Scanner scanner, ThongTinThue thongTinThue) throws ParseException {
        System.out.print("Ngay thue( DD/MM/YYYY): ");
        thongTinThue.setNgayThue(scanner.nextLine());
        System.out.println("====================================");
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

    private SanhCuoi themSanh(Scanner scanner, ThongTinThue thongTinThue) throws ParseException {
        SanhCuoi sanhCuoi;
        boolean chooseCheck = false;

        while (!chooseCheck) {
            System.out.println("1. Danh sach sanh");
            System.out.println("2. Tim kiem sanh");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1":
                    quanLySanhCuoi.hienThiDS(quanLySanhCuoi.getDSSanhCuoi());
                    chooseCheck = true;

                    break;
                case "2":
                    System.out.print("Nhap tu khoa can tim(ten, suc chua, vi tri...): ");
                    List<SanhCuoi> dsSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(scanner.nextLine());
                    System.out.println("------------------------------------");

                    if (dsSanhCuoi.size() == 0) {
                        System.out.println("====================================");
                        System.out.println("Sanh cuoi khong ton tai!");
                        System.out.println("====================================");
                        
                        quanLySanhCuoi.hienThiDS(quanLySanhCuoi.getDSSanhCuoi());
                    } else {
                        quanLySanhCuoi.hienThiDS(dsSanhCuoi);
                    }
                    
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
        sanhCuoi = quanLySanhCuoi.timByTen(scanner.nextLine());
        thongTinThue.setSanhCuoi(sanhCuoi);
        System.out.println("====================================");

        // Them don gia thue sanh -------------------------------------------------
        BigDecimal giaThue = sanhCuoi.getGiaThue(thongTinThue.getNgayThueString(), quanLyGiaThue).getGia();
        thongTinThue.setDonGiaThueSanh(giaThue);

        return sanhCuoi;
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
                    quanLyThucAn.hienThiDS(quanLyThucAn.getDSThucAn());

                    System.out.print("Nhap ten thuc an: ");
                    menu.themThucAn(quanLyThucAn.timByTen(scanner.nextLine()));

                    System.out.println("------------------------------------");
                    continue;
                }
                case "2": {
                    if (menu.getDSThucAn().isEmpty()) {
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
                    quanLyThucUong.hienThiDS(quanLyThucUong.getDSThucUong());

                    System.out.print("Nhap ten thuc uong: ");
                    menu.themThucUong(quanLyThucUong.timByTen(scanner.nextLine()));

                    System.out.println("------------------------------------");
                    continue;
                }
                case "2": {
                    if (menu.getDSThucUong().isEmpty()) {
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

    private void themDichVu(Scanner scanner, ThongTinThue thongTinThue) {
        while (true) {
            System.out.println("1. Them dich vu");
            System.out.println("2. Tiep tuc");
            System.out.println("------------------------------------");
            System.out.print("Lua chon: ");

            switch (scanner.nextLine()) {
                case "1": {
                    quanLyDichVu.hienThiDS(quanLyDichVu.getDSDichVu());

                    System.out.print("Nhap ma dich vu: ");
                    DichVu dichVu = QuanLyDichVu.timByMa(Integer.parseInt(scanner.nextLine()));
                    System.out.println("------------------------------------");

                    if (!thongTinThue.checkDichVuTrungLap(dichVu)) {
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
}