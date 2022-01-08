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
    private List<SanhCuoi> dsSanhCuoi = new ArrayList<>();
    private QuanLyGiaThue quanLyGiaThue;
    
    public QuanLySanhCuoi(QuanLyGiaThue quanLyGiaThue) {
        this.quanLyGiaThue = quanLyGiaThue;

        doc(Path.SANH_CUOI.getPath());
    }

    public List<SanhCuoi> getDSSanhCuoi() {
        return this.dsSanhCuoi;
    }

    public SanhCuoi traCuuBangMaSC(String maSC) {
        return this.dsSanhCuoi.stream()
                .filter(p -> p.getMaSC().equalsIgnoreCase(maSC))
                .findFirst().orElse(null);
    }

    public List<SanhCuoi> traCuuBangTuKhoa(String tuKhoa) {
        return this.dsSanhCuoi.stream()
                .filter(p -> p.getTenSC().contains(tuKhoa) ||
                        Integer.toString(p.getViTri()).contains(tuKhoa) ||
                        Integer.toString(p.getSucChua()).contains(tuKhoa))
                .collect(Collectors.toList());
    }

    public SanhCuoi traCuuBangTen(String tenSC) {
        return this.dsSanhCuoi.stream()
                .filter(p -> p.getTenSC().equalsIgnoreCase(tenSC))
                .findFirst().orElse(null);
    }

    private List<SanhCuoi> sapXep(List<SanhCuoi> dsSanhCuoi) {
        List<SanhCuoi> dsSC = new ArrayList<>(this.dsSanhCuoi);
        dsSC.sort((sc1, sc2) -> sc1.compareTo(sc2));

        return dsSC;
    }

    private int getMaxDem() {
        int maxCount = this.dsSanhCuoi.size() - 1;
        String maxCountString = this.dsSanhCuoi.get(maxCount).getMaSC().substring(1);

        return Integer.parseInt(maxCountString);
    }

    @Override
    public boolean them(SanhCuoi item) {
        this.dsSanhCuoi.add(item);

        return ghi(Path.SANH_CUOI.getPath(), this.dsSanhCuoi);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.SANH_CUOI.getPath(), this.dsSanhCuoi);
    }

    @Override
    public boolean xoa(String ma) {
        SanhCuoi sc = traCuuBangMaSC(ma);

        if (sc != null) {
            this.dsSanhCuoi.remove(sc);

            return ghi(Path.SANH_CUOI.getPath(), this.dsSanhCuoi);
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

                    sanhCuoi.setMaSC(scanner.nextLine());
                    sanhCuoi.setTenSC(scanner.nextLine());
                    sanhCuoi.setViTri(scanner.nextInt());
                    sanhCuoi.setSoLanThue(scanner.nextInt());
                    sanhCuoi.setSucChua(scanner.nextInt());
                    sanhCuoi.setDsGiaThue(quanLyGiaThue.getDSGiaThue());

                    this.dsSanhCuoi.add(sanhCuoi);

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
    public boolean ghi(String path, List<SanhCuoi> items) {
        if (!items.isEmpty()) {
            File file = new File(path);

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (SanhCuoi sanhCuoi : items) {
                    printWriter.println(sanhCuoi.getMaSC());
                    printWriter.println(sanhCuoi.getTenSC());
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