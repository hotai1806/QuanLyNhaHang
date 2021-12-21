package com.huongdoituong;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import BLL package
import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.BLL.QuanLyThucAn;
import com.huongdoituong.BLL.QuanLyThucUong;
import com.huongdoituong.BLL.QuanLyMenu;

// import DAL package
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;
import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Menu;
import com.huongdoituong.DAL.ThucAn;
import com.huongdoituong.DAL.ThucUong;


public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String YEAR_REGEX = "^\\d{4}$";

    private static QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
    private static QuanLyThucAn qlThucAn = new QuanLyThucAn();
    private static QuanLyThucUong qlThucUong = new QuanLyThucUong();
    private static QuanLyDichVu qlDichVu = new QuanLyDichVu();
    private static QuanLyThue quanLyThue;

    public static void main(String[] args) throws NumberFormatException, Exception {
        qlThucAn.them(new ThucAn("Ga", new BigDecimal(10)));
        qlThucAn.them(new ThucAn("Ca", new BigDecimal(20)));
        qlThucAn.them(new ThucAn("Bo", new BigDecimal(50)));

        qlThucUong.them(new ThucUong("Coca", new BigDecimal(30)));
        qlThucUong.them(new ThucUong("Pepsi", new BigDecimal(40)));
        qlThucUong.them(new ThucUong("Sting", new BigDecimal(60)));

        qlDichVu.them(new DichVu("Trang tri", new BigDecimal(10)));
        qlDichVu.them(new DichVu("Hat", new BigDecimal(20)));
        qlDichVu.them(new DichVu("Banh kem", new BigDecimal(50)));

        quanLyThue = new QuanLyThue();

        while (true) {
            System.out.println("Quan ly nha hang");
            System.out.println("1. Thue sanh");
            System.out.println("2. Quan ly");
            System.out.println("3. Thoat");
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
        ThongTinThue thongTinThue = new ThongTinThue();
        boolean chooseCheck = false;

        try {
            System.out.print("Ten tiec: ");
            thongTinThue.setTenTiec(SCANNER.nextLine());
            System.out.println("====================================");

            System.out.print("Ngay thue: ");
            String ngayThue = SCANNER.nextLine();
            thongTinThue.setNgayThue(ngayThue);
            System.out.println("====================================");

            System.out.println("Thoi diem thue: ");
            System.out.println("Sang");
            System.out.println("Chieu");
            System.out.println("Toi");
            System.out.println("------------------------------------");
            System.out.print("Nhap thoi diem muon thue: ");
            thongTinThue.setThoiDiemThue(SCANNER.nextLine());
            System.out.println("====================================");

            // Them sanh -------------------------------------------------------------
            System.out.print("Nhap tu khoa can tim: ");
            List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
            quanLySanhCuoi.hienThi(listSanhCuoi);

            System.out.print("Nhap ten sanh cuoi muon chon: ");
            SanhCuoi sanhCuoi = quanLySanhCuoi.traCuuBangTen(SCANNER.nextLine());
            thongTinThue.setSanhCuoi(sanhCuoi);
            System.out.println("====================================");

            // Them don gia thue sanh -------------------------------------------------
            sanhCuoi.setGia(ngayThue);
            thongTinThue.setDonGiaThueSanh(sanhCuoi.getGia());

            // Them menu -------------------------------------------------
            for (int i = 0; i < sanhCuoi.getSucChua(); i++) {
                Menu menu = new Menu();

                chooseCheck = false;

                while (!chooseCheck) {
                    System.out.println("Them menu cho ban so " + i);
                    System.out.println("1. Them thuc an");
                    System.out.println("2. Them thuc uong");
                    System.out.println("3. Tiep tuc");
                    System.out.println("------------------------------------");
                    String choice = SCANNER.nextLine();

                    switch (choice) {
                        case "1": {
                            System.out.print("Nhap ten thuc an: ");
                            menu.getListThucAn().add(QuanLyThucAn.timTheoTen(SCANNER.nextLine()));

                            System.out.println("------------------------------------");
                            continue;
                        }
                        case "2": {
                            System.out.print("Nhap ten thuc uong: ");
                            menu.getListThucUong().add(QuanLyThucUong.timTheoTen(SCANNER.nextLine()));

                            System.out.println("------------------------------------");
                            continue;
                        }
                        case "3": {
                            thongTinThue.getMenu().add(menu);
                            chooseCheck = true;

                            System.out.println("====================================");
                            break;
                        }
                        default:
                            System.out.println("*** Lua chong khong kha dung ***");
                            continue;
                    }
                }
            }

            // Them dich vu -------------------------------------------------
            chooseCheck = false;

            while (!chooseCheck) {
                System.out.println("1. Them dich vu");
                System.out.println("2. Tiep tuc");
                String choice = SCANNER.nextLine();

                switch (choice) {
                    case "1": {
                        System.out.print("Nhap ten dich vu: ");
                        DichVu dichVu = QuanLyDichVu.timByTen(SCANNER.nextLine());

                        if (!thongTinThue.kiemTraDichVuTrungLap(dichVu)) {
                            thongTinThue.getDichVu().add(dichVu);
                        } else {
                            System.out.println("Dich vu bi trung!");
                        }

                        System.out.println("------------------------------------");
                        continue;
                    }
                    case "2": {
                        chooseCheck = true;
                        System.out.println("====================================");
                        break;
                    }
                    default:
                        System.out.println("*** Lua chong khong kha dung ***");
                        continue;
                }
            }

            quanLyThue.thue(thongTinThue);
            quanLyThue.xuatHoaDon(thongTinThue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void menuQuanLy() throws NumberFormatException, Exception {
        while (true) {
            System.out.println("Quan ly");
            System.out.println("1. Doanh thu");
            System.out.println("2. Sanh");
            System.out.println("3. Dich vu");
            System.out.println("4. Thuc an");
            System.out.println("5. Thuc uong");
            System.out.println("6. Tro lai");
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

    private static void menuQuanLyDoanhThu() throws ParseException {
        while (true) {
            System.out.println("Quan ly doanh thu");
            System.out.println("1. Xem doanh thu thang");
            System.out.println("2. Xem doanh thu quy");
            System.out.println("3. Tro lai");
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

    private static void menuQuanLySanh() throws NumberFormatException, Exception {
        while (true) {
            System.out.println("Quan ly sanh");
            System.out.println("1. Them sanh");
            System.out.println("2. Cap nhat sanh");
            System.out.println("3. Xoa sanh");
            System.out.println("4. Tra cuu sanh");
            System.out.println("5. Tro lai");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    SanhCuoi sanhCuoi = new SanhCuoi();

                    System.out.print("Ten: ");
                    sanhCuoi.setTenSC(SCANNER.nextLine());
                    System.out.print("Vi tri: ");
                    sanhCuoi.setViTri(Integer.parseInt(SCANNER.nextLine()));
                    System.out.print("Suc chua: ");
                    sanhCuoi.setSucChua(Integer.parseInt(SCANNER.nextLine()));

                    if (quanLySanhCuoi.themSC(sanhCuoi)) {
                        System.out.print("Them thanh cong!");
                    }

                    System.out.println("====================================");
                    break;
                }
                case "2": {
                    System.out.println("====================================");
                    quanLySanhCuoi.hienThi();

                    System.out.print("Nhap ten sanh cuoi: ");
                    if (quanLySanhCuoi.capNhatSC(SCANNER.nextLine(), SCANNER)) {
                        System.out.println("Cap nhat thanh cong!");
                    } else {
                        System.out.println("Cap nhat khong thanh cong!");
                    }

                    System.out.println("====================================");
                    break;
                }
                case "3": {
                    System.out.println("====================================");
                    quanLySanhCuoi.hienThi();

                    System.out.print("Nhap ten sanh cuoi: ");
                    if (quanLySanhCuoi.xoaSC(SCANNER.nextLine())) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Xoa khong thanh cong!");
                    }

                    System.out.println("====================================");
                    break;
                }
                case "4": {
                    System.out.println("====================================");
                    
                    System.out.print("Nhap tu khoa can tim: ");
                    List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
                    quanLySanhCuoi.hienThi(listSanhCuoi);

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
        while (true) {
            System.out.println("Quan ly dich vu");
            System.out.println("1. Them dich vu");
            System.out.println("2. Cap nhat dich vu");
            System.out.println("3. Xoa dich vu");
            System.out.println("4. Tra cuu dich vu");
            System.out.println("5. Tro lai");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    break;
                }
                case "2": {
                    break;
                }
                case "3": {
                    break;
                }
                case "4": {
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
        while (true) {
            System.out.println("Quan ly thuc an");
            System.out.println("1. Them thuc an");
            System.out.println("2. Cap nhat thuc an");
            System.out.println("3. Xoa thuc an");
            System.out.println("4. Tra cuu thuc an");
            System.out.println("5. Tro lai");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    break;
                }
                case "2": {
                    break;
                }
                case "3": {
                    break;
                }
                case "4": {
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
        while (true) {
            System.out.println("Quan ly thuc uong");
            System.out.println("1. Them thuc uong");
            System.out.println("2. Cap nhat thuc uong");
            System.out.println("3. Xoa thuc uong");
            System.out.println("4. Tra cuu thuc uong");
            System.out.println("5. Tro lai");
            System.out.print("Lua chon: ");

            switch (SCANNER.nextLine()) {
                case "1": {
                    break;
                }
                case "2": {
                    break;
                }
                case "3": {
                    break;
                }
                case "4": {
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