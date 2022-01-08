package com.huongdoituong.DAL;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Karaoke extends DichVu {
    private final String NAME = "Karaoke";

    private double thoiGianThue;

    public Karaoke() {
        this.ten = NAME;
    }

    @Override
    public void capNhat(Scanner scanner) {

        System.out.print("Thoi gian thue: ");
        this.setThoiGianThue(Double.parseDouble(scanner.nextLine()));

        System.out.print("Gia: ");
        this.setGia(new BigDecimal(scanner.nextLine()));
    }

    @Override
    public void ghi(PrintWriter printWriter) {
        super.ghi(printWriter);
        printWriter.println(this.getThoiGianThue());
    }

    public void doc(Scanner scanner, int maDichVu) {
        this.setMa(maDichVu);
        this.setGia(new BigDecimal(scanner.nextLine()));
        this.setThoiGianThue(Double.parseDouble(scanner.nextLine()));
    }

    @Override
    public void hienThi() {
        System.out.println("Ma dich vu: " + String.format("%s", this.getMa()));
        System.out.println("Ten dich vu: " + this.getTen());
        System.out.println("Thoi gian thue: " + this.getThoiGianThue());

        if (this.getStoreKey().isEmpty()) {
            for (String key : this.getStoreKey()) {
                if (key != null) {
                    System.out.println(key + ": " + this.getLuaChonDieuKien().get(key));

                }
            }
        }

        System.out.println("Gia dich vu: " + this.getGia());
    }

    public double getThoiGianThue() {
        return this.thoiGianThue;
    }

    public void setThoiGianThue(double thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }
}