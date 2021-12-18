package com.huongdoituong.DAL;


import java.math.BigDecimal;
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
    public BigDecimal getTongGia(){
        BigDecimal tongGiaThucAn = listThucAn.stream().map(p->p.getGia()).reduce(new BigDecimal(0),(x,y)->x.add(y));
        BigDecimal tongGiaThucUong = listThucUong.stream().map(p->p.getGia()).reduce(new BigDecimal(0),(x,y)->x.add(y));
        return tongGiaThucAn.add(tongGiaThucUong);
    }
    public String getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(String maMenu) {
        this.maMenu = maMenu;
    }

    public List<ThucAn> getListThucAn(){
        return this.listThucAn;
    }

    public List<ThucUong> getListThucUong(){
        return this.listThucUong;
    }
}