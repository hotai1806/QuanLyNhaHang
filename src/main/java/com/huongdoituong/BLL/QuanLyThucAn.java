package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThucAn;

import com.huongdoituong.Utils.*;

public class QuanLyThucAn implements IDocGhi<ThucAn>, IBaseQuanLy<ThucAn> {
    private List<ThucAn> dsThucAn = new ArrayList<>();

    {
        doc(Path.THUC_AN.getPath());
    }

    public List<ThucAn> getDSThucAn() {
        return this.dsThucAn;
    }

    public ThucAn timById(int ma) {
        return this.dsThucAn.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public ThucAn timByTen(String ten) {
        return this.dsThucAn.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten)).findFirst().orElse(null);
    }

    @Override
    public boolean them(ThucAn mon) {
        this.dsThucAn.add(mon);

        return ghi(Path.THUC_AN.getPath(), dsThucAn);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.THUC_AN.getPath(), dsThucAn);
    }

    @Override
    public boolean xoa(String ma) {
        ThucAn thucAn = timById(Integer.parseInt(ma));
        
        if (thucAn != null) {
            this.dsThucAn.remove(thucAn);
            return ghi(Path.THUC_AN.getPath(), this.dsThucAn);
        }

        return false;
    }

    @Override
    public void hienThiDS(List<ThucAn> listThucAn) {
        if (listThucAn.size() != 0) {
            for (ThucAn thucAn : listThucAn) {
                thucAn.hienThi();
                System.out.println("------------------------------------");
            }
        }
    }

    @Override
    public void doc(String path) {
        File file = new File(path);

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThucAn thucAn = new ThucAn();

                    thucAn.setMa(scanner.nextInt());
                    scanner.nextLine();

                    thucAn.setTen(scanner.nextLine());
                    thucAn.setGia(scanner.nextBigDecimal());
                    scanner.nextLine();
                    thucAn.setMonChay(scanner.nextBoolean());

                    this.dsThucAn.add(thucAn);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay so cuoi tu ma thuc an lam bien dem
                ThucAn.setMaThucAn(this.dsThucAn.get(this.dsThucAn.size() - 1).getMa());

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThucAn> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(path);

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (ThucAn mon : items) {
                        printWriter.println(mon.getMa());
                        printWriter.println(mon.getTen());
                        printWriter.println(mon.getGia());
                        printWriter.println(mon.getMonChay());
                    }

                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }
}
