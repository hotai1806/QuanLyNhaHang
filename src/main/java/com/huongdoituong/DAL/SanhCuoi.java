package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private final String ID_FORMAT = "S%03d";
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
    
    public static int dem = 0;

    private String maSC;
    private String tenSC;
    private int viTri;
    private int soLanThue;
    private int sucChua;
    private BigDecimal gia;

    {
        this.setMaSC(String.format(ID_FORMAT, ++dem));
        this.setGia(new BigDecimal(0));
    }

    @Override
    public int compareTo(SanhCuoi sc) {
        if (this.getSoLanThue() == sc.getSoLanThue())
            return 0;
        else if (this.getSoLanThue() < sc.getSoLanThue())
            return 1;
        else
            return -1;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public void setGia(String ngayThue) throws ParseException {
        Date date = DATE_FORMATER.parse(ngayThue);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            this.gia = GiaThue.CUOI_TUAN.getGiaThue();
        } else {
            this.gia = GiaThue.NGAY_THUONG.getGiaThue();
        }
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) throws Exception {
        if (viTri == 1 || viTri == 2) {
            this.viTri = viTri;
        } else {
            throw new Exception("Chi cho phep 1 hoac 2");
        }
    }

    public String getTenSC() {
        return tenSC;
    }

    public void setTenSC(String tenSC) {
        this.tenSC = tenSC;
    }

    public String getMaSC() {
        return maSC;
    }

    public void setMaSC(String maSC) {
        this.maSC = maSC;
    }
}