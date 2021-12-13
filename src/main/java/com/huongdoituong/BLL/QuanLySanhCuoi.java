package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLySanhCuoi implements IDocGhi<SanhCuoi> {
    private List<SanhCuoi> listSanhCuoi = new ArrayList<>();

    public QuanLySanhCuoi(Scanner scanner) {
        Doc(Path.SANH_CUOI.getPath(), scanner);
    }

    public boolean themSC(SanhCuoi sc) {
        listSanhCuoi.add(sc);

        return Ghi(Path.SANH_CUOI.getPath(), listSanhCuoi);
    }

    @Override
    public void Doc(String path, Scanner scanner) {
        File file = new File(Path.SANH_CUOI.getPath());

        if (file.exists()) {
            try {
                scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    SanhCuoi sanhCuoi = new SanhCuoi();

                    sanhCuoi.setMaSC(scanner.nextLine());
                    sanhCuoi.setTenSC(scanner.nextLine());
                    sanhCuoi.setViTri(scanner.nextInt());
                    sanhCuoi.setSoLanThue(scanner.nextInt());
                    sanhCuoi.setSucChua(scanner.nextInt());
                    sanhCuoi.setGia(scanner.nextInt());

                    listSanhCuoi.add(sanhCuoi);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean Ghi(String path, List<SanhCuoi> items) {
        if (!items.isEmpty()) {
            File f = new File(Path.SANH_CUOI.getPath());
            try (PrintWriter printWriter = new PrintWriter(f)) {
                for (SanhCuoi sanhCuoi : items) {
                    printWriter.println(sanhCuoi.getMaSC());
                    printWriter.println(sanhCuoi.getTenSC());
                    printWriter.println(sanhCuoi.getViTri());
                    printWriter.println(sanhCuoi.getSoLanThue());
                    printWriter.println(sanhCuoi.getSucChua());
                    printWriter.println(sanhCuoi.getGia());

                    return true;
                }
            } catch (FileNotFoundException ex) {
                return false;
            }
        }

        return false;
    }
}
