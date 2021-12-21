package com.huongdoituong.DAL;

import java.math.BigDecimal;

public class ThucAn extends Mon{
    private boolean monChay;       
    public ThucAn(String ten,BigDecimal gia) {
        super(ten,gia);
    }

    public ThucAn(String ten,BigDecimal gia,boolean monChay) {
        super(ten,gia);
        this.monChay = monChay;
    }
    public ThucAn() {
    }

    public void hienThi(){
        System.out.println("Ma" + this.ma);
        System.out.println("Ten"+ this.ten);
        System.out.println("Gia" + this.gia);
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