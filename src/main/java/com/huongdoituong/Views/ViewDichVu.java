package com.huongdoituong.Views;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Karaoke;
import com.huongdoituong.DAL.ThueCaSi;

public class ViewDichVu implements ViewBase<QuanLyDichVu> {
    @Override
    public void themView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        System.out.println("Chon loai dinh vu can them");
        System.out.println("1. Thue ca si");
        System.out.println("2. Karaoke");
        System.out.println("3. Khac");

        switch (scanner.nextLine()) {
            case "1": {
                ThueCaSi dichVu = new ThueCaSi();
                System.out.print("Ten Ca Si:");
                dichVu.setTenCaSi(scanner.nextLine());
                System.out.print("So Bai Hat:");
                dichVu.setSoLuongBai(scanner.nextInt());
                System.out.print("Gia:");
                dichVu.setGia(scanner.nextBigDecimal());

                if (quanLyDichVu.them(dichVu)) {
                    System.out.println("Them thanh cong!");
                }

                break;
            }
            case "2": {
                Karaoke dichVu = new Karaoke();
                System.out.print("Thoi luong:");
                dichVu.setThoiGianThue(scanner.nextInt());
                System.out.print("Gia:");
                dichVu.setGia(scanner.nextBigDecimal());

                if (quanLyDichVu.them(dichVu)) {
                    System.out.println("Them thanh cong!");
                }

                break;
            }
            case "3": {
                DichVu dichVu = new DichVu();
                System.out.print("Ten:");
                dichVu.setTen(scanner.nextLine());
                System.out.print("Gia:");

                dichVu.setGia(new BigDecimal(scanner.nextLine()));
                System.out.print("Them chi tiet( neu khong co nhan phim 0) neu co nhan phim 1:");
                while (Integer.parseInt(scanner.nextLine()) != 0) {
                    System.out.print("Ten chi tiet:");
                    String ten = scanner.nextLine();
                    System.out.print("Ten noi dung:");
                    String noiDung = scanner.nextLine();
                    dichVu.setLuaChonDieuKien(ten, noiDung);
                    System.out.print("Nhan phim khong de thoat hoac bam bat ki phim de tiep tuc:");

                }
                
                if (quanLyDichVu.them(dichVu)) {
                    System.out.println("Them thanh cong!");
                }

                break;
            }
            default: {
                System.out.println("====================================");
                System.out.println("*** Lua chon khong kha dung ***");
                System.out.println("====================================");
            }
        }

    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        System.out.println("====================================");
        quanLyDichVu.hienThi();

        System.out.print("Nhap ma dich vu: ");
        // String ten = scanner.nextLine()
        if (quanLyDichVu.capNhat(scanner.nextLine(), scanner)) {
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void xoaView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        System.out.println("====================================");
        quanLyDichVu.hienThi();

        System.out.print("Nhap ma dich vu: ");
        // String ten = scanner.nextLine()
        if (quanLyDichVu.xoa(scanner.nextLine())) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        System.out.println("====================================");
        System.out.print("Nhap tu khoa can tim: ");
        List<DichVu> dichVu = QuanLyDichVu.timByTen(scanner.nextLine());

        if (dichVu.size() == 0) {
            quanLyDichVu.hienThi();
            System.out.print("Tu khoa tim kiem khong co trong danh sach.");
        } else {
            quanLyDichVu.hienThi(dichVu);
        }
    }
}
