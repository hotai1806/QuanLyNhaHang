package com.huongdoituong.DAL;


import java.util.ArrayList;
import java.util.List;


public class Menu  {
    private String maMenu;

    private List<ThucAn> listThucAn = new ArrayList<ThucAn>();
    private List<ThucUong> listThucUong = new ArrayList<ThucUong>();
    
    public void themThucAn(ThucAn mon){
        this.listThucAn.add(mon);
    }
    public void xoaThuAn(int idMon){
        this.listThucAn.removeIf(mon-> mon.ma==idMon);

    }
    public void themThucUong(ThucUong mon){
        this.listThucUong.add(mon);
    }
    public void xoaThucUong(int idMon){
        this.listThucUong.removeIf(mon-> mon.ma==idMon);

    }
    public double getTongGia(){
        double tongGiaThucAn = listThucAn.stream().map(p->p.getGia()).reduce(0.0,(x,y)->x+y);
        double tongGiaThucUong = listThucUong.stream().map(p->p.getGia()).reduce(0.0,(x,y)->x+y);
        return tongGiaThucAn + tongGiaThucUong;
    }
    public String getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(String maMenu) {
        this.maMenu = maMenu;
    }
}