package com.huongdoituong.DAL;

import java.math.BigDecimal;

public class ThucAn extends Mon {
    private static int maThucAn = 0;

    private boolean monChay;
    static int autoIncrement;

    public ThucAn(String ten, BigDecimal gia) {
        super(ten, gia);
    }

    protected int nextId() {
        return ++maThucAn;
    }

    public ThucAn(String ten, BigDecimal gia, boolean monChay) {
        super(ten, gia);
        this.monChay = monChay;
    }

    public ThucAn() {
    }

    public void hienThi() {
        System.out.println("Ma: " + this.ma);
        System.out.println("Ten: " + this.ten);
        if (this.isMonChay()) {
            System.out.println("Mon chay");
        }
        System.out.println("Gia: " + this.gia);
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

}