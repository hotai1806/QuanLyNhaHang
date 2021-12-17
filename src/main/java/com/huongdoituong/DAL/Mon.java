package com.huongdoituong.DAL;

public class Mon {
    protected int ma = 0;
    protected String ten;
    protected double gia;
    protected static int autoIncrement = 0;


    public int getMa() {
        return this.ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return this.gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

}
