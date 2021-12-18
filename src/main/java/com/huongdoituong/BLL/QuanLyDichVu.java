package com.huongdoituong.BLL;
import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.DichVu;

public class QuanLyDichVu {
    private List<DichVu> listDichVu = new ArrayList<>();
    
    public QuanLyDichVu(){
    }
    public DichVu timDichVu(int ma){
        return this.listDichVu.stream().filter(p->p.getMa()==ma).findFirst().get();
    }
    public DichVu timDichVuByTen(String ten){
        return this.listDichVu.stream().filter(p->p.getTen()==ten).findFirst().get();
    }
    public boolean themDichVu(DichVu dichVu){
        return this.listDichVu.add(dichVu);
    }
    public boolean xoaDichVu(int ma){
        
      return  this.listDichVu.removeIf(mon-> mon.getMa()==ma);

    }
}
