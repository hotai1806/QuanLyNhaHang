package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThucAn;
import com.huongdoituong.Utils.*;

public class QuanLyThucAn implements IDocGhi<ThucAn> {
    private static List<ThucAn> listThucAn = new ArrayList<>();

    public QuanLyThucAn() {
    }

    public ThucAn tim(int ma) {
        return QuanLyThucAn.listThucAn.stream().filter(p -> p.getMa() == ma).findFirst().get();

    }

    public static ThucAn timTheoTen(String ten) {
        return QuanLyThucAn.listThucAn.stream().filter(p -> p.getTen() == ten).findFirst().get();

    }

    public boolean them(ThucAn mon) {
        return QuanLyThucAn.listThucAn.add(mon);
    }

    public boolean xoa(int ma) {

        return QuanLyThucAn.listThucAn.removeIf(mon -> mon.getMa() == ma);

    }


    @Override
    public void doc(String path) {
        File file = new File(Path.THUC_AN.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThucAn thucAn = new ThucAn();

                    thucAn.setMa(scanner.nextInt());
                    scanner.nextLine();

                    thucAn.setTen(scanner.nextLine());
                    scanner.nextLine();
                    thucAn.setGia(scanner.nextBigDecimal());
                    scanner.nextLine();
                    thucAn.setMonChay(scanner.nextBoolean());

                    scanner.nextLine();
                    QuanLyThucAn.listThucAn.add(thucAn);

                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public boolean ghi(String paths, List<ThucAn> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(Path.THUC_AN.getPath());

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

    @Override
    public void hienThi() {

    }

    @Override
    public void hienThi(List<ThucAn> items) {

    }
    

}
