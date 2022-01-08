package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.Scanner;

public class ThucAn extends Mon {
    // private static int autoIncrement;
    private static int maThucAn = 0;

    private boolean monChay;

    public ThucAn(String ten, BigDecimal gia) {
        super(ten, gia);
    }

    public ThucAn(String ten, BigDecimal gia, boolean monChay) {
        super(ten, gia);
        this.monChay = monChay;
    }

    public ThucAn() {

    }

    protected int nextId() {
        return ++maThucAn;
    }

    public void capNhat(Scanner scanner) {
        System.out.print("Ten: ");
        this.setTen(scanner.nextLine());

        System.out.println("Mon co chay khong(1 co, 0 khong):");
        this.setMonChay(Integer.parseInt(scanner.nextLine()) == 0 ? false : true);

        System.out.print("Gia: ");
        this.setGia(new BigDecimal(scanner.nextLine()));
    }

    public void hienThi() {
        System.out.println("Ma: " + this.ma);
        System.out.println("Ten: " + this.ten);
        if (this.isMonChay()) {
            System.out.println("Mon chay");
        }
        System.out.println("Gia: " + this.gia);
        System.out.println("------------------------------------");
    }

    public boolean isMonChay() {
        return this.monChay;
    }

    public boolean getMonChay() {
        return this.monChay;
    }

    public void setMonChay(boolean monChay) {
        this.monChay = monChay;
    }

    public static void setMaThucAn(int maTA) {
        maThucAn = maTA;
    }
}