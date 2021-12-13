package com.huongdoituong.DAL;

public class SanhCuoi {
    private static final String ID_FORMAT = "S%03d";

    public static int dem = 0;

    private String maSC;
    private String tenSC;
    private int viTri;
    private int soLanThue;
    private int sucChua;
    private int gia;

    {
        setMaSC(String.format(ID_FORMAT, ++dem));
    }

    public SanhCuoi() { };

    public SanhCuoi(String ten, int viTri, int sucChua) {
        this.setTenSC(ten);
        this.setViTri(viTri);
        this.setSucChua(sucChua);
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public void setViTri(int viTri) {
        if (viTri == 1 || viTri == 2) {
            this.viTri = viTri;
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