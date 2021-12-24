package com.huongdoituong.Views;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyMenu;
import com.huongdoituong.DAL.Menu;

public class ViewMenu implements ViewBase {
    private  QuanLyMenu quanLyMenu;
    private Scanner scanner;
    public ViewMenu(QuanLyMenu quanLyMenu, Scanner scanner){
        this.quanLyMenu = quanLyMenu;
        this.scanner = scanner;
    }   

    public boolean themView(){
        try {
            
            Menu menu = new Menu();
            System.out.println("Ma menu:");
            menu.setMaMenu(scanner.nextInt());
            return true   ;
        } catch (Exception e) {
            System.out.println("Loi nhap");
            return false;
        }
        }
    
    public boolean xoaView(){
        return true;
    }

    public boolean capNhatView(){
        return true;
    }
    public void traCuuView(){
        
    }
}
