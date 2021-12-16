package com.huongdoituong;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyThue quanLyThue = new QuanLyThue();
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();

        // Them
        ThongTinThue thongTinThue = new ThongTinThue();

        try {
            System.out.print("Ten tiec: ");
            thongTinThue.setTenTiec(SCANNER.nextLine());

            System.out.print("Ngay thue: ");
            String ngayThue = SCANNER.nextLine();
            thongTinThue.setNgayThue(ngayThue);

            System.out.println("Thoi diem thue: ");
            System.out.println("1. Sang");
            System.out.println("2. Chieu");
            System.out.println("3. Toi");
            System.out.print("Nhap thoi diem muon thue: ");
            thongTinThue.setThoiDiemThue(SCANNER.nextLine());

            // Them sanh -------------------------------------------------------------
            System.out.print("Nhap tu khoa can tim: ");
            List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
            quanLySanhCuoi.hienThi(listSanhCuoi);

            System.out.print("Nhap ten sanh cuoi muon chon: ");
            SanhCuoi sanhCuoi = quanLySanhCuoi.traCuuBangTen(SCANNER.nextLine());
            thongTinThue.setSanhCuoi(sanhCuoi);

            // Them don gia thue sanh -------------------------------------------------
            sanhCuoi.setGia(ngayThue);
            thongTinThue.setDonGiaThueSanh(sanhCuoi.getGia());

            // Them menu -------------------------------------------------
            List<ThucAn> listThucAn = new ArrayList<>();
            listThucAn.add(new ThucAn("Ga", new BigDecimal(10)));
            listThucAn.add(new ThucAn("Ca", new BigDecimal(20)));
            listThucAn.add(new ThucAn("Bo", new BigDecimal(50)));

            List<ThucUong> listThucUong = new ArrayList<>();
            listThucUong.add(new ThucUong("Coca", new BigDecimal(30)));
            listThucUong.add(new ThucUong("Pepsi", new BigDecimal(40)));
            listThucUong.add(new ThucUong("Sting", new BigDecimal(60)));

            for (int i = 0; i < sanhCuoi.getSucChua(); i++) {
                Menu menu = new Menu();

                System.out.println("Menu");
                Boolean menuCheck = false;
                
                while (!menuCheck) {
                    System.out.println("1. Them thuc an");
                    System.out.println("2. Them thuc uong");
                    System.out.println("3. Thoat");
                    String choice = SCANNER.nextLine();
                    switch (choice) {
                        case "1": {
                            menu.dsThucAn.add(listThucAn.get(Integer.parseInt(SCANNER.nextLine())));
                            continue;
                        }
                        case "2": {
                            menu.dsThucUong.add(listThucUong.get(Integer.parseInt(SCANNER.nextLine())));
                            continue;
                        }
                        case "3": {
                            thongTinThue.getMenu().add(menu);
                            menuCheck = true;
                            break;
                        }
                        default:
                            System.out.println("*** Lua chong khong kha dung ***");
                            continue;
                    }
                }
            }
            
            System.out.println(thongTinThue.getDonGiaMenu());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --------------------------------------------------------------------------
    }

    public static class Menu {
        public List<ThucAn> dsThucAn;
        public List<ThucUong> dsThucUong;
        public BigDecimal tongGia;

        {
            tongGia = new BigDecimal(0);
            dsThucAn = new ArrayList<>();
            dsThucUong = new ArrayList<>();
        }

        public BigDecimal getTongGia() {
            for (ThucAn thucAn : dsThucAn) {
                tongGia.add(thucAn.gia);
            }

            for (ThucUong thucUong : dsThucUong) {
                tongGia.add(thucUong.gia);
            }

            return tongGia;
        }
    }

    public static class ThucAn {
        public String ten;
        public BigDecimal gia;

        {
            gia = new BigDecimal(0);
        }
        
        public ThucAn(String ten, BigDecimal gia) {
            this.ten = ten;
            this.gia = gia;
        }
    }

    public static class ThucUong {
        public String ten;
        public BigDecimal gia;

        public ThucUong(String ten, BigDecimal gia) {
            this.ten = ten;
            this.gia = gia;
        }

        {
            gia = new BigDecimal(0);
        }
    }
}