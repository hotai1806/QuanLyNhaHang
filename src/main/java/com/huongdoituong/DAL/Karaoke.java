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

}