package com.huongdoituong.DAL;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class DichVu {
    protected static int autoIncrement = 0;

    protected int ma = 0;
    protected String ten;
    protected BigDecimal gia;
    private Hashtable<String, String> luaChonDieuKien = new Hashtable<>();
    private List<String> storeKey = new ArrayList<>();

    {
        this.setMa(++autoIncrement);
    }

    public void capNhat(Scanner scanner) {
        System.out.print("Ten: ");
        this.setTen(scanner.nextLine());

        System.out.print("Gia: ");
        this.setGia(new BigDecimal(scanner.nextLine()));

        int lenghtKey = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lenghtKey; i++) {
            this.setLuaChonDieuKien(scanner.nextLine(), scanner.nextLine());
        }
    }

    public void hienThi() {
        System.out.println("Ma dich vu: " + String.format("%s", this.getMa()));
        System.out.println("Ten dich vu: " + this.getTen());

        if (this.getStoreKey().isEmpty()) {
            for (String key : this.getStoreKey()) {
                if (key != null) {
                    System.out.println(key + ": " + this.getLuaChonDieuKien().get(key));
                }
            }
        }

        System.out.println("Gia dich vu: " + this.getGia());
    }

    public void doc(Scanner scanner, int ma, String ten) {
        this.setTen(ten);
        this.setMa(ma);

        int lenghtKey = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lenghtKey; i++) {
            this.setLuaChonDieuKien(scanner.nextLine(), scanner.nextLine());
        }

        this.setGia(new BigDecimal(scanner.nextLine()));
    }

    public void ghi(PrintWriter printWriter) {
        printWriter.println(this.getMa());
        printWriter.println(this.getTen());

        if (!this.getStoreKey().isEmpty()) {
            printWriter.println(this.getStoreKey().size());
            for (String key : this.getStoreKey()) {
                printWriter.println(key);
                printWriter.println(this.luaChonDieuKien.get(key));
            }
        }

        printWriter.println(this.getGia());
    }

    public static void setAutoIncreament(int count) {
        autoIncrement = count;
    }

    public int getMa() {
        return this.ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
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

    public Hashtable<String, String> getLuaChonDieuKien() {
        return this.luaChonDieuKien;
    }

    public void setLuaChonDieuKien(String key, String value) {
        this.storeKey.add(key);
        this.luaChonDieuKien.put(key, value);
    }

    public List<String> getStoreKey() {
        return this.storeKey;
    }

    // public void setStoreKey(List<String> storeKey) {
    //     this.storeKey = storeKey;
    // }
}
