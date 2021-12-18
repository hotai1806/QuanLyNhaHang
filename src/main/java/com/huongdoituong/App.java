package com.huongdoituong;

import java.math.BigDecimal;
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

    public static void main(String[] args) {
        // QuanLyThue quanLyThue = new QuanLyThue();
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        QuanLyThucAn qlThucAn = new QuanLyThucAn();
        QuanLyThucUong qlThucUong = new QuanLyThucUong();
        QuanLyDichVu qlDichVu = new QuanLyDichVu();
        QuanLyMenu qlMenu = new QuanLyMenu();

        // Them
        // ThongTinThue thongTinThue = new ThongTinThue();
        // boolean chooseCheck = false;

        // try {
        //     System.out.print("Ten tiec: ");
        //     thongTinThue.setTenTiec(SCANNER.nextLine());
        //     System.out.println("------------------------------------");

        //     System.out.print("Ngay thue: ");
        //     String ngayThue = SCANNER.nextLine();
        //     thongTinThue.setNgayThue(ngayThue);
        //     System.out.println("------------------------------------");

        //     System.out.println("Thoi diem thue: ");
        //     System.out.println("1. Sang");
        //     System.out.println("2. Chieu");
        //     System.out.println("3. Toi");
        //     System.out.print("Nhap thoi diem muon thue: ");
        //     thongTinThue.setThoiDiemThue(SCANNER.nextLine());
        //     System.out.println("------------------------------------");

        //     // Them sanh -------------------------------------------------------------
        //     System.out.print("Nhap tu khoa can tim: ");
        //     List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
        //     quanLySanhCuoi.hienThi(listSanhCuoi);

        //     System.out.print("Nhap ten sanh cuoi muon chon: ");
        //     SanhCuoi sanhCuoi = quanLySanhCuoi.traCuuBangTen(SCANNER.nextLine());
        //     thongTinThue.setSanhCuoi(sanhCuoi);
        //     System.out.println("------------------------------------");

        //     // Them don gia thue sanh -------------------------------------------------
        //     sanhCuoi.setGia(ngayThue);
        //     thongTinThue.setDonGiaThueSanh(sanhCuoi.getGia());

        //     // Them menu -------------------------------------------------
            qlThucAn.them(new ThucAn("Ga", new BigDecimal(10)));
            qlThucAn.them(new ThucAn("Ca", new BigDecimal(20)));
            qlThucAn.them(new ThucAn("Bo", new BigDecimal(50)));

            qlThucUong.them(new ThucUong("Coca", new BigDecimal(30)));
            qlThucUong.them(new ThucUong("Pepsi", new BigDecimal(40)));
            qlThucUong.them(new ThucUong("Sting", new BigDecimal(60)));

        //     for (int i = 0; i < sanhCuoi.getSucChua(); i++) {
        //         Menu menu = new Menu();

        //         chooseCheck = false;

        //         while (!chooseCheck) {
        //             System.out.println("Them menu cho ban so " + i);
        //             System.out.println("1. Them thuc an");
        //             System.out.println("2. Them thuc uong");
        //             System.out.println("3. Tiep tuc");
        //             String choice = SCANNER.nextLine();
        //             switch (choice) {
        //                 case "1": {
        //                     System.out.print("Nhap ten thuc an: ");
        //                     menu.dsThucAn.add(QLThucAn.getThucAnBangTen(SCANNER.nextLine()));

        //                     System.out.println("------------------------------------");
        //                     continue;
        //                 }
        //                 case "2": {
        //                     System.out.print("Nhap ten thuc uong: ");
        //                     menu.dsThucUong.add(QLThucUong.getThucUongBangTen(SCANNER.nextLine()));

        //                     System.out.println("------------------------------------");
        //                     continue;
        //                 }
        //                 case "3": {
        //                     thongTinThue.getMenu().add(menu);
        //                     chooseCheck = true;

        //                     System.out.println("------------------------------------");
        //                     break;
        //                 }
        //                 default:
        //                     System.out.println("*** Lua chong khong kha dung ***");
        //                     continue;
        //             }
        //         }
        //     }

        //     // Them dich vu -------------------------------------------------
            qlDichVu.them(new DichVu("Trang tri", new BigDecimal(10)));
            qlDichVu.them(new DichVu("Hat", new BigDecimal(20)));
            qlDichVu.them(new DichVu("Banh kem", new BigDecimal(50)));

        //     chooseCheck = false;

        //     while (!chooseCheck) {
        //         System.out.println("1. Them dich vu");
        //         System.out.println("2. Tiep tuc");
        //         String choice = SCANNER.nextLine();

        //         switch (choice) {
        //             case "1": {
        //                 System.out.print("Nhap ten thuc uong: ");
        //                 DichVu dichVu = QLDichVu.getDichVuBangTen(SCANNER.nextLine());

        //                 if (!thongTinThue.kiemTraDichVuTrungLap(dichVu)) {
        //                     thongTinThue.getDichVu().add(dichVu);
        //                 } else {
        //                     System.out.println("Dich vu bi trung!");
        //                 }

        //                 System.out.println("------------------------------------");
        //                 continue;
        //             }
        //             case "2": {
        //                 chooseCheck = true;
        //                 System.out.println("------------------------------------");
        //                 break;
        //             }
        //             default:
        //                 System.out.println("*** Lua chong khong kha dung ***");
        //                 continue;
        //         }
        //     }

        //     quanLyThue.themThongTinThue(thongTinThue);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // --------------------------------------------------------------------------

        QuanLyThue quanLyThue = new QuanLyThue();
    }

    
}