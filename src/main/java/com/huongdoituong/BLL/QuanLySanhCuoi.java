package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLySanhCuoi implements IDocGhi<SanhCuoi> {
    private List<SanhCuoi> listSanhCuoi = new ArrayList<>();

    public QuanLySanhCuoi(Scanner scanner) {
        doc(Path.SANH_CUOI.getPath(), scanner);
    }

    public boolean themSC(SanhCuoi sc) {
        this.listSanhCuoi.add(sc);

        return ghi(Path.SANH_CUOI.getPath(), this.listSanhCuoi);
    }

    public boolean capNhatSC(String maSC, Scanner scanner) {
        SanhCuoi sc = traCuuBangMaSC(maSC);

        if (sc != null) {
            sc.Nhap(scanner);

            return ghi(Path.SANH_CUOI.getPath(), this.listSanhCuoi);
        }

        return false;
    }

    public boolean xoaSC(String maSC) {
        SanhCuoi sc = traCuuBangMaSC(maSC);

        if (sc != null) {
            this.listSanhCuoi.remove(sc);

            return ghi(Path.SANH_CUOI.getPath(), this.listSanhCuoi);
        }

        return false;
    }

    public void sapXep(List<SanhCuoi> dsSanhCuoi) {
        Collections.sort(dsSanhCuoi);
    }

    public List<SanhCuoi> traCuuBangTuKhoa(String tuKhoa) {
        List<SanhCuoi> ketQua = new ArrayList<>();

        for (SanhCuoi sanhCuoi : this.listSanhCuoi) {
            if (sanhCuoi.getTenSC().contains(tuKhoa) ||
                    Integer.toString(sanhCuoi.getViTri()).contains(tuKhoa) ||
                    Integer.toString(sanhCuoi.getSucChua()).contains(tuKhoa)) {

                ketQua.add(sanhCuoi);
            }
        }

        return ketQua;
    }

    private SanhCuoi traCuuBangMaSC(String maSC) {
        for (SanhCuoi sanhCuoi : this.listSanhCuoi) {
            if (sanhCuoi.getMaSC().contains(maSC)) {
                return sanhCuoi;
            }
        }

        return null;
    }

    @Override
    public void doc(String path, Scanner scanner) {
        File file = new File(Path.SANH_CUOI.getPath());

        if (file.exists() && file.length() > 0) {
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

                // Lay 3 so cuoi tu ma sanh cuoi S*** cuoi cung lam bien dem
                SanhCuoi.dem = Integer.parseInt(
                        this.listSanhCuoi.get(this.listSanhCuoi.size() - 1).getMaSC().substring(1));

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<SanhCuoi> items) {
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
    public void hienThi() {
        for (SanhCuoi sanhCuoi : this.listSanhCuoi) {
            System.out.println("Ma: " + sanhCuoi.getMaSC());
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("Vi tri: " + sanhCuoi.getViTri());
            System.out.println("Suc chua: " + sanhCuoi.getSucChua());
            System.out.println("------------------------------------");
        }
    }

    @Override
    public void hienThi(List<SanhCuoi> items) {
        for (SanhCuoi sanhCuoi : items) {
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("So lan thue: " + sanhCuoi.getSoLanThue());
            System.out.println("------------------------------------");
        }
    }
}