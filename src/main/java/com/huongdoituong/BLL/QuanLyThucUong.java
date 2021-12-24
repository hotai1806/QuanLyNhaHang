package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;

// import com.huongdoituong.Utils.IDocGhi;
// import com.huongdoituong.Utils.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThucUong implements IDocGhi<ThucUong>, BaseInterfaceQuanLy<ThucUong> {
    private static List<ThucUong> listThucUong = new ArrayList<>();

    public QuanLyThucUong() {
    }

    public ThucUong tim(int ma) {
        return QuanLyThucUong.listThucUong.stream().filter(p -> p.getMa() == ma).findFirst().get();

    }

    public static ThucUong timTheoTen(String ten) {
        return QuanLyThucUong.listThucUong.stream().filter(p -> p.getTen() == ten).findFirst().get();

    }

    @Override
    public boolean them(ThucUong thucUong) {
        return QuanLyThucUong.listThucUong.add(thucUong);
    }

    public static ThucUong timById(int ma) {
        return QuanLyThucUong.listThucUong.stream().filter(p -> p.getMa() == ma).findFirst().get();
    }

    public static List<ThucUong> timByTen(String ten) {
        return QuanLyThucUong.listThucUong.stream().filter(p -> p.getTen() == ten).collect(Collectors.toList());

    }
    // public boolean xoa(int ma){

    // return QuanLyThucUong.listThucUong.removeIf(mon-> mon.getMa()==ma);

    // }

    @Override
    public void doc(String path) {
        File file = new File(Path.THUC_UONG.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThucUong mon = new ThucUong();

                    mon.setMa(scanner.nextInt());
                    scanner.nextLine();

                    mon.setTen(scanner.nextLine());
                    scanner.nextLine();
                    mon.setGia(scanner.nextBigDecimal());
                    scanner.nextLine();
                    mon.setHangSanXuat(scanner.nextLine());

                    scanner.nextLine();
                    QuanLyThucUong.listThucUong.add(mon);

                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String paths, List<ThucUong> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(Path.THUC_AN.getPath());

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (ThucUong mon : items) {
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

    @Override
    public void hienThi() {
        if (QuanLyThucUong.listThucUong.size() != 0) {
            for (ThucUong thucAn : QuanLyThucUong.listThucUong) {
                System.out.println("-------------- Dich Vu ----------------");
                thucAn.hienThi();

            }
        }

    }

    @Override
    public void hienThi(List<ThucUong> listThucUong) {

        if (listThucUong.size() != 0) {
            System.out.println("-------------- Dich Vu ----------------");
            for (ThucUong thucUong : listThucUong) {
                thucUong.hienThi();

            }
        }

    }

    @Override
    public boolean capNhat(String maThucUong, Scanner scanner) {
        ThucUong thucAn = timById(Integer.parseInt(maThucUong));
        if (thucAn != null) {
            try {
                System.out.print("Ten: ");
                thucAn.setTen(scanner.nextLine());

                System.out.println("Hang san xuat:");
                thucAn.setHangSanXuat(scanner.nextLine());

                System.out.print("Gia: ");
                thucAn.setGia(scanner.nextBigDecimal());

            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return false;
    }

    @Override
    public boolean xoa(String ma) {
        ThucUong thucUong = timById(Integer.parseInt(ma));
        if (thucUong != null) {
            QuanLyThucUong.listThucUong.remove(thucUong);
            return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.listThucUong);
        }
        return false;
    }

}
