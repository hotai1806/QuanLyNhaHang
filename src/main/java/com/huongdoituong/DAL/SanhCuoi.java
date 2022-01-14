package com.huongdoituong.DAL;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyGiaThue;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private final String ID_FORMAT = "S%03d";

    private static int dem = 0;

    private String ma;
    private String ten;
    private int viTri;
    private int soLanThue;
    private int sucChua;
    private List<GiaThue> dsGiaThue;

    {
        this.setMa(String.format(ID_FORMAT, ++dem));
    }

    public void capNhat(Scanner scanner) throws Exception {
        System.out.print("Ten: ");
        this.setTen(scanner.nextLine());

        System.out.print("Vi tri(tang 1, tang 2): ");
        this.setViTri(Integer.parseInt(scanner.nextLine()));

        System.out.print("Suc chua: ");
        this.setSucChua(Integer.parseInt(scanner.nextLine()));
    }

    public void hienThi() {
        System.out.println("Ma: " + this.getMa());
        System.out.println("Ten: " + this.getTen());
        System.out.println("Vi tri: " + this.getViTri());
        System.out.println("Suc chua: " + this.getSucChua());
        System.out.println("So lan thue: " + this.getSoLanThue());
        System.out.println("------------------------------------");
    }

    @Override
    public int compareTo(SanhCuoi sc) {
        if (this.getSoLanThue() == sc.getSoLanThue()) {
            return 0;
        }

        if (this.getSoLanThue() < sc.getSoLanThue()) {
            return 1;
        }

        return -1;
    }

    public static void setDem(int dem) {
        SanhCuoi.dem = dem;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public GiaThue getGiaThue(String ngayThue, QuanLyGiaThue quanLyGiaThue) throws ParseException {
        return quanLyGiaThue.getGiaTheoNgay(ngayThue);
    }

    public void setDsGiaThue(List<GiaThue> dsGiaThue) {
        this.dsGiaThue = dsGiaThue;
    }
}