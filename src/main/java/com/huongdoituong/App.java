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
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        SanhCuoi sanhCuoi = new SanhCuoi();

        // // Them
        // try {
        //     System.out.print("Ten: ");
        //     sanhCuoi.setTenSC(SCANNER.nextLine());
        //     System.out.print("Vi tri: ");
        //     sanhCuoi.setViTri(Integer.parseInt(SCANNER.nextLine()));
        //     System.out.print("Suc chua: ");
        //     sanhCuoi.setSucChua(Integer.parseInt(SCANNER.nextLine()));

        //     if (quanLySanhCuoi.themSC(sanhCuoi)) {
        //         System.out.print("Them thanh cong!");
        //     }

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
    }
}