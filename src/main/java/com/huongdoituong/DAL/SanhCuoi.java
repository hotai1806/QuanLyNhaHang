package com.huongdoituong.DAL;

import java.math.BigDecimal;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private final String ID_FORMAT = "S%03d";

    private static int dem = 0;

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

    public static void setDem(int dem) {
        SanhCuoi.dem = dem;
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

    public void tangSoLanThue() {
        this.setSoLanThue(this.getSoLanThue() + 1);
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
}