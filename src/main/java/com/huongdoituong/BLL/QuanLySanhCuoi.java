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
        this.listSanhCuoi.add(sc);

        return Ghi(Path.SANH_CUOI.getPath(), this.listSanhCuoi);
    }

    public boolean xoaSC(String maSC) {
        SanhCuoi sc = timKiemSC(maSC);

        if (sc != null) {
            this.listSanhCuoi.remove(sc);

            return Ghi(Path.SANH_CUOI.getPath(), this.listSanhCuoi);
        }

        return false;
    }

    public SanhCuoi timKiemSC(String tuKhoa) {
        for (SanhCuoi sanhCuoi : this.listSanhCuoi) {
            if (sanhCuoi.getMaSC().contains(tuKhoa)) {
                return sanhCuoi;
            }
        }

        return null;
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
                    sanhCuoi.setGia(scanner.nextBigDecimal());

                    this.listSanhCuoi.add(sanhCuoi);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean Ghi(String path, List<SanhCuoi> items) {
        if (!items.isEmpty()) {
            File file = new File(Path.SANH_CUOI.getPath());

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (SanhCuoi sanhCuoi : items) {
                    printWriter.println(sanhCuoi.getMaSC());
                    printWriter.println(sanhCuoi.getTenSC());
                    printWriter.println(sanhCuoi.getViTri());
                    printWriter.println(sanhCuoi.getSoLanThue());
                    printWriter.println(sanhCuoi.getSucChua());
                    printWriter.println(sanhCuoi.getGia());
                }

                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }

        return false;
    }

    @Override
    public void HienThi() {
        for (SanhCuoi sanhCuoi : this.listSanhCuoi) {
            System.out.println(sanhCuoi.getMaSC() + " - " + sanhCuoi.getTenSC());
        }
    }
}
