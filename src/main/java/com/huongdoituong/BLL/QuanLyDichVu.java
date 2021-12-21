package com.huongdoituong.BLL;
import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.DichVu;

public class QuanLyDichVu {
    private static List<DichVu> listDichVu = new ArrayList<>();
    
    public QuanLyDichVu(){
    }
    public static DichVu tim(int ma){
        return QuanLyDichVu.listDichVu.stream().filter(p->p.getMa()==ma).findFirst().get();
    }
    public static DichVu timByTen(String ten){
        return QuanLyDichVu.listDichVu.stream().filter(p->p.getTen()==ten).findFirst().get();
    }
    public boolean them(DichVu dichVu){
        return QuanLyDichVu.listDichVu.add(dichVu);
    }
    public boolean xoa(int ma){
        
      return  QuanLyDichVu.listDichVu.removeIf(mon-> mon.getMa()==ma);

    }
}
