package com.huongdoituong.DAL;

public class ThucAn extends Mon{
    private boolean monChay;
    public ThucAn(String ten, int gia,boolean monChay){
        this.ten = ten;
        this.gia = gia;
        this.monChay = monChay;
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