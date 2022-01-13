package com.huongdoituong.Views;

import java.math.BigDecimal;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyGiaThue;
import com.huongdoituong.DAL.GiaThue;

public class ViewGiaThue {
    public void themView(Scanner scanner, QuanLyGiaThue quanLyGiaThue) {
        try {
            GiaThue giaThue = new GiaThue();

            System.out.print("Ten: ");
            giaThue.setTen(scanner.nextLine());

            System.out.print("Ngay thue: ");
            giaThue.setNgayThue(scanner.nextLine());
            
            System.out.print("Gia thue: ");
            giaThue.setGia(new BigDecimal(scanner.nextLine()));

            if (quanLyGiaThue.them(giaThue)) {
                System.out.println("------------------------------------");
                System.out.println("Them thanh cong!");
            }

            System.out.println("====================================");
        } catch (Exception e) {
            System.out.println("====================================");
            System.out.println("**************Loi nhap**************");
            System.out.println("====================================");
        }
    }
}
