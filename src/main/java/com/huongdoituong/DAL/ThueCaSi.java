package com.huongdoituong.DAL;

public class ThueCaSi extends DichVu {
    private String tenCaSi;
    private int soLuongBai;


    ThueCaSi(){
        this.ten="Thue Ca Si";
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
   
    
    
}
