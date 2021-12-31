package com.huongdoituong.DAL;

public class Karaoke extends DichVu {
    private double thoiGianThue;

    public Karaoke() {
        this.ten = "Karaoke";
    }

    public double getThoiGianThue() {
        return this.thoiGianThue;
    }

    public void setThoiGianThue(double thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
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

        System.out.println("Gia dich vu:" + this.getGia());
    }

}