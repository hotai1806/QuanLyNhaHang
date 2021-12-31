package com.huongdoituong.DAL;

import java.math.BigDecimal;

public enum GiaThue {
    NOEL("24/12", new BigDecimal(10000000)),
    NGAY_THUONG(new BigDecimal(6000000)),
    CUOI_TUAN(new BigDecimal(8000000));

    private final String ngay;
    private final BigDecimal gia;

    private GiaThue(String ngay, BigDecimal gia) {
        this.ngay = ngay;
        this.gia = gia;
    }

    private GiaThue(BigDecimal gia) {
        this.ngay = "";
        this.gia = gia;
    }

    public String getNgay() {
        return ngay;
    }

    public BigDecimal getGia() {
        return gia;
    };
}