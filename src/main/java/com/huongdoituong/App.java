package com.huongdoituong;

import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.DAL.SanhCuoi;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLySanhCuoi qlSC = new QuanLySanhCuoi(SCANNER);

        SanhCuoi sanhCuoi = new SanhCuoi("a", 1, 1);
        qlSC.themSC(sanhCuoi);
    }
}
