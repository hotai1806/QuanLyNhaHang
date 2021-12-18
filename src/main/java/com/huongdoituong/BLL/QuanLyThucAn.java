package com.huongdoituong.BLL;
import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.ThucAn;

public class QuanLyThucAn {
    private List<ThucAn> listThucAn = new ArrayList<>();
    
    public QuanLyThucAn(){
    }
    public ThucAn timThucAn(int ma){
        return this.listThucAn.stream().filter(p->p.getMa()==ma).findFirst().get();

    }
    public boolean themThucAn(ThucAn mon){
        return this.listThucAn.add(mon);
    }
    public boolean xoaThucAn(int ma){
        
      return  this.listThucAn.removeIf(mon-> mon.getMa()==ma);

    }
}
