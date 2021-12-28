package com.huongdoituong.DAL;

import java.math.BigDecimal;

public class ThucUong extends Mon {
    private String hangSanXuat;
    static int autoIncrement;
    public ThucUong(String ten, BigDecimal gia, String hangSX) {
        super(ten, gia);

        this.hangSanXuat = hangSX;
    }
    public ThucUong(String ten, BigDecimal gia) {
        super(ten, gia);
    }

    public void hienThi(){
        System.out.println("Ma:" + this.ma);
        System.out.println("Ten:"+ this.ten);
        System.out.println("Hang San Xuat:" + this.hangSanXuat);
        System.out.println("Gia:" + this.gia);

    }

    public ThucUong() {
    }
    public String getHangSanXuat() {
        return this.hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

   

}