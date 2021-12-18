package com.huongdoituong.BLL;

import java.util.ArrayList;
import java.util.List;

import com.huongdoituong.DAL.Menu;

public class QuanLyMenu {
    private List<Menu> listMenu = new ArrayList<>();
    public QuanLyMenu(){

    }
    public boolean themMenu(Menu menu){
        return this.listMenu.add(menu);
    }
    public boolean xoaMenu(String id){
        return this.listMenu.removeIf(element-> element.getMaMenu()==id);
    }
    public double getTongGia(){
        return this.listMenu.stream().map(p-> p.getTongGia()).reduce(0.0,(x,y)-> x + y);
    }

}
