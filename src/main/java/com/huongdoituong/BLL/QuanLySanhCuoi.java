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
    private static List<SanhCuoi> listSanhCuoi = new ArrayList<>();

    public QuanLySanhCuoi() {
        doc(Path.SANH_CUOI.getPath());
    }

    public boolean themSC(SanhCuoi sc) {
        QuanLySanhCuoi.listSanhCuoi.add(sc);

        return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.listSanhCuoi);
    }

    public boolean capNhatSC(String maSC, Scanner scanner) {
        SanhCuoi sc = traCuuBangMaSC(maSC);

        if (sc != null) {
            try {
                System.out.print("Ten: ");
                sc.setTenSC(scanner.nextLine());
                System.out.print("Vi tri: ");
                sc.setViTri(Integer.parseInt(scanner.nextLine()));
                System.out.print("Suc chua: ");
                sc.setSucChua(Integer.parseInt(scanner.nextLine()));

                return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.listSanhCuoi);
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }

        }

        return false;
    }

    public boolean xoaSC(String maSC) {
        SanhCuoi sc = traCuuBangMaSC(maSC);

        if (sc != null) {
            QuanLySanhCuoi.listSanhCuoi.remove(sc);

            return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.listSanhCuoi);
        }

        return false;
    }

    private void sapXep(List<SanhCuoi> dsSanhCuoi) {
        Collections.sort(dsSanhCuoi);
    }

    public List<SanhCuoi> traCuuBangTuKhoa(String tuKhoa) {
        List<SanhCuoi> ketQua = new ArrayList<>();

        for (SanhCuoi sanhCuoi : QuanLySanhCuoi.listSanhCuoi) {
            if (sanhCuoi.getTenSC().contains(tuKhoa) ||
                    Integer.toString(sanhCuoi.getViTri()).contains(tuKhoa) ||
                    Integer.toString(sanhCuoi.getSucChua()).contains(tuKhoa)) {

                ketQua.add(sanhCuoi);
            }
        }

        return ketQua;
    }

    public SanhCuoi traCuuBangTen(String tenSC) {
        for (SanhCuoi sanhCuoi : QuanLySanhCuoi.listSanhCuoi) {
            if (sanhCuoi.getTenSC().equalsIgnoreCase(tenSC)) {
                return sanhCuoi;
            }
        }

        return null;
    }

    public static SanhCuoi traCuuBangMaSC(String maSC) {
        for (SanhCuoi sanhCuoi : QuanLySanhCuoi.listSanhCuoi) {
            if (sanhCuoi.getMaSC().contains(maSC)) {
                return sanhCuoi;
            }
        }

        return null;
    }

    @Override
    public void doc(String path) {
        File file = new File(Path.SANH_CUOI.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    SanhCuoi sanhCuoi = new SanhCuoi();

                    sanhCuoi.setMaSC(scanner.nextLine());
                    sanhCuoi.setTenSC(scanner.nextLine());
                    sanhCuoi.setViTri(scanner.nextInt());
                    sanhCuoi.setSoLanThue(scanner.nextInt());
                    sanhCuoi.setSucChua(scanner.nextInt());
                    sanhCuoi.setGia(scanner.nextBigDecimal());

                    QuanLySanhCuoi.listSanhCuoi.add(sanhCuoi);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay 3 so cuoi tu ma sanh cuoi S*** cuoi cung lam bien dem
                SanhCuoi.dem = Integer.parseInt(
                        QuanLySanhCuoi.listSanhCuoi.get(
                                QuanLySanhCuoi.listSanhCuoi.size() - 1).getMaSC().substring(1));

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
        for (SanhCuoi sanhCuoi : QuanLySanhCuoi.listSanhCuoi) {
            System.out.println("Ma: " + sanhCuoi.getMaSC());
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("Vi tri: " + sanhCuoi.getViTri());
            System.out.println("Suc chua: " + sanhCuoi.getSucChua());
            System.out.println("------------------------------------");
        }
    }

    @Override
    public void hienThi(List<SanhCuoi> items) {
        sapXep(items);

        for (SanhCuoi sanhCuoi : items) {
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("So lan thue: " + sanhCuoi.getSoLanThue());
            System.out.println("------------------------------------");
        }
    }
}