package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.SanhCuoi;

import com.huongdoituong.Utils.*;

public class QuanLySanhCuoi implements IDocGhi<SanhCuoi>, IBaseQuanLy<SanhCuoi> {
    private static List<SanhCuoi> dsSanhCuoi = new ArrayList<>();

    {
        doc(Path.SANH_CUOI.getPath());
    }

    public List<SanhCuoi> getDSSanhCuoi() {
        return QuanLySanhCuoi.dsSanhCuoi;
    }
    
    public List<SanhCuoi> traCuuBangTuKhoa(String tuKhoa) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getTen().contains(tuKhoa) ||
                        Integer.toString(p.getViTri()).contains(tuKhoa) ||
                        Integer.toString(p.getSucChua()).contains(tuKhoa))
                .collect(Collectors.toList());
    }

    public static SanhCuoi timByMa(String maSC) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getMa().equalsIgnoreCase(maSC))
                .findFirst().orElse(null);
    }

    public SanhCuoi timByTen(String tenSC) {
        return QuanLySanhCuoi.dsSanhCuoi.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(tenSC))
                .findFirst().orElse(null);
    }

    private List<SanhCuoi> sapXep(List<SanhCuoi> dsSanhCuoi) {
        List<SanhCuoi> dsSC = new ArrayList<>(QuanLySanhCuoi.dsSanhCuoi);
        dsSC.sort((sc1, sc2) -> sc1.compareTo(sc2));

        return dsSC;
    }

    private int getMaxDem() {
        int maxCount = QuanLySanhCuoi.dsSanhCuoi.size() - 1;
        String maxCountString = QuanLySanhCuoi.dsSanhCuoi.get(maxCount).getMa().substring(1);

        return Integer.parseInt(maxCountString);
    }

    @Override
    public boolean them(SanhCuoi item) {
        QuanLySanhCuoi.dsSanhCuoi.add(item);
        return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
    }

    @Override
    public boolean xoa(String ma) {
        SanhCuoi sc = timByMa(ma);

        if (sc != null) {
            QuanLySanhCuoi.dsSanhCuoi.remove(sc);
            return ghi(Path.SANH_CUOI.getPath(), QuanLySanhCuoi.dsSanhCuoi);
        }

        return false;
    }

    @Override
    public void hienThiDS(List<SanhCuoi> dsSanhCuoi) {
        List<SanhCuoi> dsSC = sapXep(dsSanhCuoi);

        for (SanhCuoi sanhCuoi : dsSC) {
            sanhCuoi.hienThi();
        }
    }

    @Override
    public void doc(String path) {
        File file = new File(path);

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    SanhCuoi sanhCuoi = new SanhCuoi();

                    sanhCuoi.setMa(scanner.nextLine());
                    sanhCuoi.setTen(scanner.nextLine());
                    sanhCuoi.setViTri(scanner.nextInt());
                    sanhCuoi.setSoLanThue(scanner.nextInt());
                    sanhCuoi.setSucChua(scanner.nextInt());
                    sanhCuoi.setDsGiaThue(QuanLyGiaThue.getDSGiaThue());

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

    @Override
    public boolean ghi(String path, List<SanhCuoi> dsSanhCuoi) {
        if (!dsSanhCuoi.isEmpty()) {
            File file = new File(path);

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (SanhCuoi sanhCuoi : dsSanhCuoi) {
                    printWriter.println(sanhCuoi.getMa());
                    printWriter.println(sanhCuoi.getTen());
                    printWriter.println(sanhCuoi.getViTri());
                    printWriter.println(sanhCuoi.getSoLanThue());
                    printWriter.println(sanhCuoi.getSucChua());
                }

                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }

        return false;
    }
}