package com.huongdoituong;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.DAL.ThongTinThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyThue quanLyThue = new QuanLyThue();

        ThongTinThue thongTinThue = new ThongTinThue();
        if (thongTinThue.Nhap(SCANNER)) {

            quanLyThue.themThongTinThue(thongTinThue);
        }
    }
}
