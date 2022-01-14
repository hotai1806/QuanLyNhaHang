package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaThue {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM");

    private static int dem = 0;

    private int ma;
    private String ten;
    private Date ngayThue;
    private BigDecimal gia;

    {
        this.setMa(++dem);
        this.gia = new BigDecimal(0);
    }

    public static void setDem(int dem) {
        GiaThue.dem = dem;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayThue() {
        return this.ngayThue == null ? "null" : DATE_FORMATER.format(ngayThue);
    }

    public void setNgayThue(String ngayThue) throws ParseException {
        if (ngayThue.equals("null")) {
            this.ngayThue = null;
        } else {
            this.ngayThue = DATE_FORMATER.parse(ngayThue);
        }
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
}