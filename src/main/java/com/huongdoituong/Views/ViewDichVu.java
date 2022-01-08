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
        try {
            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("------------------------------------");
                    ThueCaSi dichVu = new ThueCaSi();
                    System.out.print("Ten Ca Si: ");
                    dichVu.setTenCaSi(scanner.nextLine());
                    System.out.print("So Bai Hat: ");
                    dichVu.setSoLuongBai(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Gia: ");
                    dichVu.setGia(new BigDecimal(scanner.nextLine()));

                    if (quanLyDichVu.them(dichVu)) {
                        System.out.println("------------------------------------");
                        System.out.println("Them thanh cong!");
                    }

                    break;
                }
                case "2": {
                    System.out.println("------------------------------------");
                    Karaoke dichVu = new Karaoke();
                    System.out.print("Thoi luong: ");
                    dichVu.setThoiGianThue(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Gia: ");
                    dichVu.setGia(new BigDecimal(scanner.nextLine()));

                    if (quanLyDichVu.them(dichVu)) {
                        System.out.println("------------------------------------");
                        System.out.println("Them thanh cong!");
                    }

                    break;
                }
                case "3": {
                    System.out.println("------------------------------------");
                    DichVu dichVu = new DichVu();
                    System.out.print("Ten: ");
                    dichVu.setTen(scanner.nextLine());
                    System.out.println("Them chi tiet( neu khong co nhan phim 0) neu co nhan phim 1: ");
                    int isThem = Integer.parseInt(scanner.nextLine());
                    while (isThem != 0) {
                        System.out.print("Ten chi tiet: ");
                        String ten = scanner.nextLine();
                        System.out.print("Noi dung: ");
                        String noiDung = scanner.nextLine();
                        dichVu.setLuaChonDieuKien(ten, noiDung);
                        System.out.print("Nhan phim 0 de thoat hoac bam bat ki phim de tiep tuc: ");
                        isThem = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("Gia: ");
                    dichVu.setGia(new BigDecimal(scanner.nextLine()));

                    if (quanLyDichVu.them(dichVu)) {
                        System.out.println("------------------------------------");
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
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }

        System.out.println("====================================");
    }

    @Override
    public void capNhatView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        quanLyDichVu.hienThiDS(quanLyDichVu.getDSDichVu());

        System.out.print("Nhap ma dich vu: ");
        DichVu dichVu = quanLyDichVu.timById(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------------------");

        if (dichVu == null) {
            System.out.println("====================================");
            System.out.println("Thuc uong khong ton tai!");
            System.out.println("====================================");

            return;
        }

        dichVu.capNhat(scanner);
        if (quanLyDichVu.capNhatDS()) {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Cap nhat khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void xoaView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        quanLyDichVu.hienThiDS(quanLyDichVu.getDSDichVu());

        System.out.print("Nhap ma dich vu: ");
        
        if (quanLyDichVu.xoa(scanner.nextLine())) {
            System.out.println("------------------------------------");
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Xoa khong thanh cong!");
        }

        System.out.println("====================================");
    }

    @Override
    public void traCuuView(Scanner scanner, QuanLyDichVu quanLyDichVu) {
        System.out.print("Nhap tu khoa can tim: ");
        List<DichVu> dichVu = quanLyDichVu.traCuuByTen(scanner.nextLine());
        System.out.println("------------------------------------");

        if (dichVu.size() == 0) {
            System.out.println("====================================");
            System.out.println("Dich vu khong ton tai!");
            System.out.println("====================================");
            quanLyDichVu.hienThiDS(quanLyDichVu.getDSDichVu());
        } else {
            quanLyDichVu.hienThiDS(dichVu);
        }
    }
}
