package com.huongdoituong.BLL;
import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.ThucAn;

public class QuanLyThucAn {
    private List<ThucAn> listThucAn = new ArrayList<>();
    
    public QuanLyThucAn(){
    }
    public ThucAn timThucUOng(int ma){
        return this.listThucAn.stream().filter(p->p.getMa()==ma).findFirst().get();

    }
    public boolean themThucUong(ThucAn thucUong){
        return this.listThucAn.add(thucUong);
    }
    public boolean xoaThucUong(int ma){
        
      return  this.listThucAn.removeIf(mon-> mon.getMa()==ma);

    }
}
