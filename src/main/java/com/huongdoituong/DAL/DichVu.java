package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.Hashtable;

public class DichVu {
    protected int ma = 0;
    protected String ten;
    protected BigDecimal gia;
    protected static int autoIncrement = 0;
    private Hashtable<String, String> luaChonDieuKien = new Hashtable<>();

    public DichVu(String ten, BigDecimal gia){
        this.ten =  ten;
        this.gia = gia;

    }

    public int getMa() {
        return this.ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
        
    }
    public Hashtable<String,String> getLuaChonDieuKien() {
        return this.luaChonDieuKien;
    }

    public void setLuaChonDieuKien(String key,String value) {
        this.luaChonDieuKien.put(key, value);
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

}
