package com.huongdoituong.DAL;

public class ThucUong extends Mon {
    private String hangSanXuat;

    public ThucUong(String ten, int gia, String hangSX) {
        this.ten = ten;
        this.gia = gia;
        this.hangSanXuat = hangSX;
    }
    public String getHangSanXuat() {
        return this.hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

   

}