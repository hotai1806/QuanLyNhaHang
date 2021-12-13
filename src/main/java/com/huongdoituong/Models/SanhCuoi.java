package com.huongdoituong.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SanhCuoi {
    private static int dem = 0;

    private String maSC;
    private String tenSC;
    private int viTri;
    private int soLanThue;
    private int sucChua;
    private int gia;

    {
        File f = new File("src/main/resources/output.txt");

        if (!f.exists() || f.length() == 0) {
            maSC = String.format("S%03d", ++dem);
        } else {
            try {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNext()) {
                    String id = scanner.nextLine();
                    
                    dem = Integer.parseInt(id.substring(1));
                    maSC = String.format("S%03d", ++dem);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public SanhCuoi(String ten, int viTri) {
        this.tenSC = ten;
        this.viTri = viTri;
    }

    public String getMaSC() {
        return maSC;
    }

    public String getTenSC() {
        return tenSC;
    }

    public void setTenSC(String tenSC) {
        this.tenSC = tenSC;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    public int getGia() {
        return gia;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public int getSoLanThue() {
        return soLanThue;
    }
}