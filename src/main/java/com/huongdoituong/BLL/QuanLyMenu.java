package com.huongdoituong.BLL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.Menu;

public class QuanLyMenu {
    private List<Menu> listMenu = new ArrayList<>();
    public QuanLyMenu(){

    }
    public boolean them(Menu menu){
        return this.listMenu.add(menu);
    }
    public boolean xoa(String id){
        return this.listMenu.removeIf(element-> element.getMaMenu()==id);
    }
    public BigDecimal getTongGia(){
        return this.listMenu.stream().map(p-> p.getTongGia()).reduce(new BigDecimal(0),(x,y)-> x.add(y));
    }

}
