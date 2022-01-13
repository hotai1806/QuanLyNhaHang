package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThucUong;

import com.huongdoituong.Utils.*;

public class QuanLyThucUong implements IDocGhi<ThucUong>, IBaseQuanLy<ThucUong> {
    private static List<ThucUong> dsThucUong = new ArrayList<>();

    {
        doc(Path.THUC_UONG.getPath());
    }

    public List<ThucUong> getDSThucUong() {
        return QuanLyThucUong.dsThucUong;
    }

    public static ThucUong timByMa(int ma) {
        return QuanLyThucUong.dsThucUong.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public ThucUong timByTen(String ten) {
        return QuanLyThucUong.dsThucUong.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten))
                .findFirst().orElse(null);
    }

    @Override
    public boolean them(ThucUong thucUong) {
        QuanLyThucUong.dsThucUong.add(thucUong);
        return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);
    }

    @Override
    public boolean xoa(String ma) {
        ThucUong thucUong = timByMa(Integer.parseInt(ma));

        if (thucUong != null) {
            QuanLyThucUong.dsThucUong.remove(thucUong);
            return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);
        }

        return false;
    }

    @Override
    public void hienThiDS(List<ThucUong> dsThucUong) {

        if (dsThucUong.size() != 0) {
            for (ThucUong thucUong : dsThucUong) {
                thucUong.hienThi();
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
                    ThucUong thucUong = new ThucUong();

                    thucUong.setMa(scanner.nextInt());
                    scanner.nextLine();

                    thucUong.setTen(scanner.nextLine());
                    thucUong.setGia(scanner.nextBigDecimal());
                    scanner.nextLine();
                    thucUong.setHangSanXuat(scanner.nextLine());

                    QuanLyThucUong.dsThucUong.add(thucUong);
                }

                // Lay so cuoi tu ma thuc uong lam bien dem
                ThucUong.setMaThucUong(QuanLyThucUong.dsThucUong.get(
                        QuanLyThucUong.dsThucUong.size() - 1).getMa());

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThucUong> dsThucUong) {
        if (!dsThucUong.isEmpty()) {
            try {
                File file = new File(path);

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (ThucUong mon : dsThucUong) {
                        printWriter.println(mon.getMa());
                        printWriter.println(mon.getTen());
                        printWriter.println(mon.getGia());
                        printWriter.println(mon.getHangSanXuat());
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
