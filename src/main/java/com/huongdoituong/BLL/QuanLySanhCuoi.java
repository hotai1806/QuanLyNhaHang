package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.SanhCuoi;

import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLySanhCuoi implements IDocGhi<SanhCuoi>, BaseInterfaceQuanLy<SanhCuoi> {
    private static List<SanhCuoi> dsSanhCuoi = new ArrayList<>();

    {
        doc(Path.SANH_CUOI.getPath());
    }

    @Override
    public boolean them(SanhCuoi item) {
        QuanLySanhCuoi.dsSanhCuoi.add(item);

        return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
    }

    @Override
    public boolean capNhat(String maSc, Scanner scanner) {
        SanhCuoi sc = traCuuBangMaSC(maSc);

        if (sc != null) {
            try {
                System.out.print("Ten: ");
                sc.setTenSC(scanner.nextLine());
                System.out.print("Vi tri: ");
                sc.setViTri(Integer.parseInt(scanner.nextLine()));
                System.out.print("Suc chua: ");
                sc.setSucChua(Integer.parseInt(scanner.nextLine()));

                return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }

        }

        return false;
    }

    @Override
    public boolean xoa(String ma) {
        SanhCuoi sc = traCuuBangMaSC(ma);

        if (sc != null) {
            QuanLySanhCuoi.dsSanhCuoi.remove(sc);

            return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
        }

        return false;
    }

    public List<SanhCuoi> traCuuBangTuKhoa(String tuKhoa) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getTenSC().contains(tuKhoa) ||
                        Integer.toString(p.getViTri()).contains(tuKhoa) ||
                        Integer.toString(p.getSucChua()).contains(tuKhoa))
                .collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTatCa() {
        return QuanLySanhCuoi.dsSanhCuoi;
    }

    public SanhCuoi traCuuBangTen(String tenSC) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getTenSC().equalsIgnoreCase(tenSC))
                .findFirst().orElse(null);
    }

    public static SanhCuoi traCuuBangMaSC(String maSC) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getMaSC().equalsIgnoreCase(maSC))
                .findFirst().orElse(null);
    }

    public void tangSoLanThue(SanhCuoi sanhCuoi) {
        sanhCuoi.tangSoLanThue();

        ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
    }

    @Override
    public void hienThi() {
        for (SanhCuoi sanhCuoi : QuanLySanhCuoi.dsSanhCuoi) {
            System.out.println("Ma: " + sanhCuoi.getMaSC());
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("Vi tri: " + sanhCuoi.getViTri());
            System.out.println("Suc chua: " + sanhCuoi.getSucChua());
            System.out.println("------------------------------------");
        }
    }

    @Override
    public void hienThi(List<SanhCuoi> dsSanhCuoi) {
        sapXep(dsSanhCuoi);

        for (SanhCuoi sanhCuoi : dsSanhCuoi) {
            System.out.println("Ten: " + sanhCuoi.getTenSC());
            System.out.println("So lan thue: " + sanhCuoi.getSoLanThue());
            System.out.println("------------------------------------");
        }
    }

    private void sapXep(List<SanhCuoi> dsSanhCuoi) {
        dsSanhCuoi.sort((sc1, sc2) -> sc1.compareTo(sc2));
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

                    QuanLySanhCuoi.dsSanhCuoi.add(sanhCuoi);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay 3 so cuoi tu ma sanh cuoi S*** cuoi cung lam bien dem
                SanhCuoi.setDem(getMaxDem());

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getMaxDem() {
        int maxCount = QuanLySanhCuoi.dsSanhCuoi.size() - 1;
        String maxCountString = QuanLySanhCuoi.dsSanhCuoi.get(maxCount).getMaSC().substring(1);

        return Integer.parseInt(maxCountString);
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
}