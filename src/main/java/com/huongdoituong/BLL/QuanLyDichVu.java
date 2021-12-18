package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyDichVu implements IDocGhi<DichVu> {
    private static List<DichVu> listDichVu = new ArrayList<>();

    public QuanLyDichVu() {
    }

    public static DichVu tim(int ma) {
        return QuanLyDichVu.listDichVu.stream().filter(p -> p.getMa() == ma).findFirst().get();
    }

    public static DichVu timByTen(String ten) {
        return QuanLyDichVu.listDichVu.stream().filter(p -> p.getTen() == ten).findFirst().get();
    }

    public boolean them(DichVu dichVu) {
        return QuanLyDichVu.listDichVu.add(dichVu);
    }

    public boolean xoa(int ma) {

        return QuanLyDichVu.listDichVu.removeIf(mon -> mon.getMa() == ma);

    }

    @Override
    public void doc(String path) {
        File file = new File(Path.DICH_VU.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    DichVu dichVu = new DichVu();

                    dichVu.setMa(scanner.nextInt());
                    scanner.nextLine();

                    dichVu.setTen(scanner.nextLine());
                    scanner.nextLine();
                    dichVu.setGia(scanner.nextBigDecimal());
                    scanner.nextLine();
                    dichVu.setLuaChonDieuKien(scanner.nextLine(), scanner.nextLine());

                    scanner.nextLine();
                    QuanLyDichVu.listDichVu.add(dichVu);

                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String paths, List<DichVu> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(Path.THUC_AN.getPath());

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (DichVu mon : items) {
                        printWriter.println(mon.getMa());
                        printWriter.println(mon.getTen());
                        printWriter.println(mon.getLuaChonDieuKien());
                        // printWriter.println(mon.getListThucAn());
                        // printWriter.println(mon.getListThucUong());
                        printWriter.println(mon.getGia());
                    }

                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }

    @Override
    public void hienThi() {
        for (DichVu dichVu : listDichVu) {
            System.out.printf("-------------- Dich Vu ----------------");

            System.out.printf("Ma dich vu:", dichVu.getMa());
            System.out.printf("Ten dich vu:", dichVu.getTen());
            for (String key : dichVu.getStoreKey()) {
                System.out.printf("{}:{}", key, dichVu.getLuaChonDieuKien().get(key));

            }

            System.out.printf("Tong gia dich vu:", dichVu.getGia());

        }

    }

    @Override
    public void hienThi(List<DichVu> items) {

    }

}
