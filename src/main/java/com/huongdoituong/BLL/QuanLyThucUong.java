package com.huongdoituong.BLL;

// import com.huongdoituong.Utils.IDocGhi;
// import com.huongdoituong.Utils.Path;

import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.ThucUong;

public class QuanLyThucUong {
    private List<ThucUong> listThucUong = new ArrayList<>();
    
    public QuanLyThucUong(){
    }
    public ThucUong timThucUOng(int ma){
        return this.listThucUong.stream().filter(p->p.getMa()==ma).findFirst().get();

    }
    public boolean themThucUong(ThucUong thucUong){
        return this.listThucUong.add(thucUong);
    }
    public boolean xoaThucUong(int ma){
        
      return  this.listThucUong.removeIf(mon-> mon.getMa()==ma);

    }
}
