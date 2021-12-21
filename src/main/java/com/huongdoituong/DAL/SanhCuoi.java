package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
    private final Calendar CALENDAR = new GregorianCalendar();

    private final String ID_FORMAT = "S%03d";

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

    public String getMaSC() {
        return maSC;
    }

    public void setMaSC(String maSC) {
        this.maSC = maSC;
    }

    public String getTenSC() {
        return tenSC;
    }

    public void setTenSC(String tenSC) {
        this.tenSC = tenSC;
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

    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public void setGia(String ngayThue) throws ParseException {
        CALENDAR.setTime(DATE_FORMATER.parse(ngayThue));

        int day = CALENDAR.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                this.gia = GiaThue.CUOI_TUAN.getGiaThue();

                break;
            default:
                this.gia = GiaThue.NGAY_THUONG.getGiaThue();

                break;
        }
    }
}