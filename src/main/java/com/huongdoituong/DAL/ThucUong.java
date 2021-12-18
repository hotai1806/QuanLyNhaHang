package com.huongdoituong.DAL;

import java.math.BigDecimal;

public class ThucUong extends Mon {
    private String hangSanXuat;

    public ThucUong(String ten, BigDecimal gia, String hangSX) {
        super(ten, gia);

        this.hangSanXuat = hangSX;
    }
    public ThucUong(String ten, BigDecimal gia) {
        super(ten, gia);
    }
    public ThucUong(){
        
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