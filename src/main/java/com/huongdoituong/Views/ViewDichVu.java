package com.huongdoituong.Views;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyDichVu;
import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Karaoke;
import com.huongdoituong.DAL.ThueCaSi;

public class ViewDichVu {

    public boolean themDichVu(QuanLyDichVu quanLyDichVu, Scanner scanner) {

        System.out.print("Chon loai dinh vu can them");
        System.out.print("1. Thue ca si");
        System.out.print("2. Karaoke");
        System.out.print("3. Khac");

        switch (scanner.nextLine()) {
            case "1": {
                ThueCaSi dichVu = new ThueCaSi();
                System.out.print("Ten Ca Si:");
                dichVu.setTenCaSi(scanner.nextLine());
                System.out.print("So Bai Hat:");
                dichVu.setSoLuongBai(scanner.nextInt());
                System.out.print("Gia:");
                dichVu.setGia(scanner.nextBigDecimal());
                return quanLyDichVu.them(dichVu);


            }
            case "2": {
                Karaoke dichVu = new Karaoke();
                System.out.print("Thoi luong:");
                dichVu.setThoiGianThue(scanner.nextInt());
                System.out.print("Gia:");
                dichVu.setGia(scanner.nextBigDecimal());
                return quanLyDichVu.them(dichVu);


            }
            case "3": {
                DichVu dichVu = new DichVu();
                System.out.print("Ten:");
                dichVu.setTen(scanner.nextLine());
                System.out.print("Gia:");
                dichVu.setGia(scanner.nextBigDecimal());
                System.out.print("Them chi tiet:");
                while (scanner.nextInt() == 0) {
                    System.out.print("Ten chi tiet:");
                    String ten = scanner.nextLine();
                    System.out.print("Ten noi dung:");
                    String noiDung = scanner.nextLine();
                    dichVu.setLuaChonDieuKien(ten, noiDung);
                    System.out.print("Nhan phim khong de thoat hoac bam bat ki phim de tiep tuc:");

                }
                return quanLyDichVu.them(dichVu);

            }
            default: {
                System.out.println("====================================");
                System.out.println("*** Lua chong khong kha dung ***");
                System.out.println("====================================");

            }
        }

        return true;
    }
    public boolean capNhatDichVu(QuanLyDichVu quanLyDichVu, Scanner scanner) {
        System.out.println("====================================");
        quanLyDichVu.hienThi();

        System.out.print("Nhap ma dich vu: ");
        // String ten = scanner.nextLine()
        if (quanLyDichVu.capNhat(scanner.nextInt(), scanner)) {
            System.out.println("Cap nhat thanh cong!");
            return true;
        } else {
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
        return false;

    }

    public boolean xoaDichVu(QuanLyDichVu quanLyDichVu, Scanner scanner){
        System.out.println("====================================");
        quanLyDichVu.hienThi();

        System.out.print("Nhap ma dich vu: ");
        // String ten = scanner.nextLine()
        if (quanLyDichVu.xoa(scanner.nextInt())) {
            System.out.println("Xoa thanh cong!");
            return true;
        } else {
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
        return false;
    }

}
