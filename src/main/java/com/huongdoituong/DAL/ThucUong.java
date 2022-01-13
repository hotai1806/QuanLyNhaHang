package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.Scanner;

public class ThucUong extends Mon {
    private static int maThucUong = 0;

    private String hangSanXuat;

    // public ThucUong(String ten, BigDecimal gia, String hangSX) {
    // super(ten, gia);

    // this.hangSanXuat = hangSX;
    // }

    // public ThucUong(String ten, BigDecimal gia) {
    // super(ten, gia);
    // }

    public ThucUong() {

    }

    protected int nextId() {
        return ++maThucUong;
    }

    public void capNhat(Scanner scanner) {
        System.out.print("Ten: ");
        this.setTen(scanner.nextLine());

        System.out.print("Hang san xuat:");
        this.setHangSanXuat(scanner.nextLine());

        System.out.print("Gia: ");
        this.setGia(new BigDecimal(scanner.nextLine()));
    }

    public void hienThi() {
        System.out.println("Ma: " + this.ma);
        System.out.println("Ten: " + this.ten);
        System.out.println("Hang San Xuat: " + this.hangSanXuat);
        System.out.println("Gia: " + this.gia);
        System.out.println("------------------------------------");
    }

    public static void setMaThucUong(int maTU) {
        maThucUong = maTU;
    }

    public String getHangSanXuat() {
        return this.hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
}