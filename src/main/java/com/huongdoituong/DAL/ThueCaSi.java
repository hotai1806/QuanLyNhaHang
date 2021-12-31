package com.huongdoituong.DAL;

public class ThueCaSi extends DichVu {
    private String tenCaSi;
    private int soLuongBai;

    public ThueCaSi() {
        this.ten = "Thue Ca Si";
    }

    public String getTenCaSi() {
        return this.tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public int getSoLuongBai() {
        return this.soLuongBai;
    }

    public void setSoLuongBai(int soLuongBai) {
        this.soLuongBai = soLuongBai;
    }

    @Override
    public void hienThi() {
        System.out.println("Ma dich vu: " + String.format("%s", this.getMa()));
        System.out.println("Ten dich vu: " + this.getTen());
        System.out.println("Ten ca si: " + this.getTenCaSi());
        System.out.println("So bai hat: " + this.getSoLuongBai());

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
