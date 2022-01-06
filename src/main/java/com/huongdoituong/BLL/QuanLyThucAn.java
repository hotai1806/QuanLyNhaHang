package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.ThucAn;

import com.huongdoituong.Utils.*;

public class QuanLyThucAn implements IDocGhi<ThucAn>, IBaseQuanLy<ThucAn> {
    private static List<ThucAn> dsThucAn = new ArrayList<>();

    {
        doc(Path.THUC_AN.getPath());
    }

    public ThucAn timById(int ma) {
        return QuanLyThucAn.dsThucAn.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public ThucAn tim(int ma) {
        return QuanLyThucAn.dsThucAn.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);

    }

    public static List<ThucAn> timByTen(String ten) {
        return QuanLyThucAn.dsThucAn.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten)).collect(Collectors.toList());
    }

    @Override
    public boolean them(ThucAn mon) {
        QuanLyThucAn.dsThucAn.add(mon);

        return ghi(Path.THUC_AN.getPath(), dsThucAn);
    }

    // public boolean xoa(int ma) {

    // return QuanLyThucAn.listThucAn.removeIf(mon -> mon.getMa() == ma);

    // }

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

                    QuanLyThucAn.dsThucAn.add(thucAn);
                    
                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay so cuoi tu ma thuc an lam bien dem
                ThucAn.setMaThucAn(QuanLyThucAn.dsThucAn.get(QuanLyThucAn.dsThucAn.size() - 1).getMa());

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

    @Override
    public void hienThi() {
        if (QuanLyThucAn.dsThucAn.size() != 0) {
            for (ThucAn thucAn : QuanLyThucAn.dsThucAn) {
                thucAn.hienThi();
                System.out.println("------------------------------------");
            }
        }
    }

    @Override
    public void hienThi(List<ThucAn> listThucAn) {
        if (listThucAn.size() != 0) {
            for (ThucAn thucAn : listThucAn) {
                thucAn.hienThi();
                System.out.println("------------------------------------");

            }
        }
    }

    @Override
    public boolean capNhat(String maThucAn, Scanner scanner) {
        ThucAn thucAn = timById(Integer.parseInt(maThucAn));
        if (thucAn != null) {
            try {
                System.out.print("Ten: ");
                thucAn.setTen(scanner.nextLine());

                System.out.println("Mon co chay khong(1 co, 0 khong):");
                thucAn.setMonChay(Integer.parseInt(scanner.nextLine()) == 0 ? false : true);

                System.out.print("Gia: ");
                thucAn.setGia(new BigDecimal(scanner.nextLine()));

                return ghi(Path.THUC_AN.getPath(), dsThucAn);
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return false;
    }

    @Override
    public boolean xoa(String ma) {
        ThucAn thucAn = timById(Integer.parseInt(ma));
        if (thucAn != null) {
            QuanLyThucAn.dsThucAn.remove(thucAn);
            return ghi(Path.THUC_AN.getPath(), QuanLyThucAn.dsThucAn);
        }
        return false;
    }
}
