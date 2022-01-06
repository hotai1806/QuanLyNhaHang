package com.huongdoituong.DAL;

import java.math.BigDecimal;

public abstract class Mon {
    protected int ma = 0;
    protected String ten;
    protected BigDecimal gia;

    {
        ma = nextId();
        // this.setMa(++autoIncrement);
    }

    abstract protected int nextId();

    public Mon() {

    }

    public Mon(String ten, BigDecimal gia) {
        this.ten = ten;
        this.gia = gia;
    }

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

    public BigDecimal getGia() {
        return this.gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public abstract void hienThi();
}
