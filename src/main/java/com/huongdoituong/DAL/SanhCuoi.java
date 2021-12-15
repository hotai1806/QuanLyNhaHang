package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.Scanner;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private static final String ID_FORMAT = "S%03d";

    public static int dem = 0;

    private String maSC;
    private String tenSC;
    private int viTri;
    private int soLanThue;
    private int sucChua;
    private BigDecimal gia;

    {
        setMaSC(String.format(ID_FORMAT, ++dem));
    }

    public boolean Nhap(Scanner scanner) {
        try {
            System.out.print("Ten: ");
            this.setTenSC(scanner.nextLine());
            System.out.print("Vi tri: ");
            this.setViTri(Integer.parseInt(scanner.nextLine()));
            System.out.print("Suc chua: ");
            this.setSucChua(Integer.parseInt(scanner.nextLine()));

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
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

    public void setGia(GiaThue giaThue) {
        this.gia = giaThue.getGiaThue();
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