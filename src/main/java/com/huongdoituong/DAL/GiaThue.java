package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaThue {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM");

    private static int dem = 0;

    private int maGiaThue;
    private String ten;
    private Date ngayThue;
    private BigDecimal giaThue;

    {
        this.setMaGiaThue(++dem);
        this.giaThue = new BigDecimal(0);
    }

    public static void setDem(int dem) {
        GiaThue.dem = dem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getMaGiaThue() {
        return maGiaThue;
    }

    public void setMaGiaThue(int maGiaThue) {
        this.maGiaThue = maGiaThue;
    }

    public BigDecimal getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(BigDecimal giaThue) {
        this.giaThue = giaThue;
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
}