package com.huongdoituong;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String YEAR_REGEX = "^\\d{4}$";

    public static void main(String[] args) throws ParseException {
	    
	// Sanh Cuoi ==============================================================
	    
    	QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        SanhCuoi sanhCuoi = new SanhCuoi();
	
    	// //  Them
    	//     System.out.print("Ten: ");
        //     sanhCuoi.setTenSC(SCANNER.nextLine());
        //     System.out.print("Vi tri: ");
        //     sanhCuoi.setViTri(Integer.parseInt(SCANNER.nextLine()));
        //     System.out.print("Suc chua: ");
        //     sanhCuoi.setSucChua(Integer.parseInt(SCANNER.nextLine()));

        //     if (quanLySanhCuoi.themSC(sanhCuoi)) {
        //         System.out.print("Them thanh cong!");
	    
	//--------------------------------------------------------------------------
	    
	 // // Cap nhat
        // quanLySanhCuoi.hienThi();
        // System.out.print("Nhap ma sanh cuoi: ");
        // if (quanLySanhCuoi.capNhatSC(SCANNER.nextLine(), SCANNER)) {
        //     System.out.print("Cap nhat thanh cong!");
        // } else {
        //     System.out.print("Cap nhat khong thanh cong!");
        // }
        
        //--------------------------------------------------------------------------

        // // Xoa
        // quanLySanhCuoi.hienThi();
        // System.out.print("Nhap ma sanh cuoi: ");
        // if (quanLySanhCuoi.xoaSC(SCANNER.nextLine())) {
        //     System.out.print("Xoa thanh cong!");
        // } else {
        //     System.out.print("Xoa khong thanh cong!");
        // }

        //--------------------------------------------------------------------------
	    
	// // Tim kiem
        // System.out.print("Nhap tu khoa can tim: ");
        // List<SanhCuoi> listSanhCuoi = quanLySanhCuoi.traCuuBangTuKhoa(SCANNER.nextLine());
        // quanLySanhCuoi.hienThi(listSanhCuoi);
	    
	// Thue ====================================================================
	
        // QuanLyThue quanLyThue = new QuanLyThue();
        QLThucAn qlThucAn = new QLThucAn();
        QLThucUong qlThucUong = new QLThucUong();
        QLDichVu qlDichVu = new QLDichVu();

        // // Them
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
        //     System.out.println("Sang");
        //     System.out.println("Chieu");
        //     System.out.println("Toi");
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
        //                 System.out.print("Nhap ten dich vu: ");
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
        //     quanLyThue.xuatHoaDon(thongTinThue);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // --------------------------------------------------------------------------

        QuanLyThue quanLyThue = new QuanLyThue();

        // Xem doanh thu thang
        // String nam = "";
        
        // while (!nam.matches(YEAR_REGEX)) {
        //     System.out.print("Nhap nam can xem doanh thu thang: ");
        //     nam = SCANNER.nextLine();
        // }
        
        // quanLyThue.xemDoanhThuThang(nam);

        // --------------------------------------------------------------------------
        
        // Xem doanh thu quy
        // String nam = "";

        //  while (!nam.matches(YEAR_REGEX)) {
        //     System.out.print("Nhap nam can xem doanh thu quy: ");
        //     nam = SCANNER.nextLine();
        // }

        // quanLyThue.xemDoanhThuQuy(nam);
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
                tongGia = tongGia.add(thucAn.gia);
            }

            for (ThucUong thucUong : dsThucUong) {
                tongGia = tongGia.add(thucUong.gia);
            }

            return tongGia;
        }
    }

    public static class QLThucAn {
        private static List<ThucAn> dsThucAn = new ArrayList<>();

        public void them(ThucAn thucAn) {
            dsThucAn.add(thucAn);
        }

        public static ThucAn getThucAnBangTen(String tenTA) {
            for (ThucAn thucAn : dsThucAn) {
                if (thucAn.ten.equals(tenTA)) {
                    return thucAn;
                }
            }

            return null;
        }
    }

    public static class ThucAn {
        public String ten;
        public BigDecimal gia;

        {
            gia = new BigDecimal(0);
        }

        public ThucAn() {
        };

        public ThucAn(String ten, BigDecimal gia) {
            this.ten = ten;
            this.gia = gia;
        }
    }

    public static class QLThucUong {
        private static List<ThucUong> dsThucUong = new ArrayList<>();

        public void them(ThucUong thucUong) {
            dsThucUong.add(thucUong);
        }

        public static ThucUong getThucUongBangTen(String tenTU) {
            for (ThucUong thucUong : dsThucUong) {
                if (thucUong.ten.equals(tenTU)) {
                    return thucUong;
                }
            }

            return null;
        }
    }

    public static class ThucUong {
        public String ten;
        public BigDecimal gia;

        public ThucUong() {
        };

        public ThucUong(String ten, BigDecimal gia) {
            this.ten = ten;
            this.gia = gia;
        }

        {
            gia = new BigDecimal(0);
        }
    }

    public static class QLDichVu {
        private static List<DichVu> dsDichVu = new ArrayList<>();

        public void them(DichVu dichVu) {
            dsDichVu.add(dichVu);
        }

        public static DichVu getDichVuBangTen(String tenDU) {
            for (DichVu dichVu : dsDichVu) {
                if (dichVu.ten.equals(tenDU)) {
                    return dichVu;
                }
            }

            return null;
        }
    }

    public static class DichVu {
        public String ten;
        public BigDecimal gia;

        public DichVu() {
        };

        public DichVu(String ten, BigDecimal gia) {
            this.ten = ten;
            this.gia = gia;
        }
    }
}