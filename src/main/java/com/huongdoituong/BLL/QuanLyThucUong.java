package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

// import com.huongdoituong.Utils.IDocGhi;
// import com.huongdoituong.Utils.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.Utils.IBaseQuanLy;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThucUong implements IDocGhi<ThucUong>, IBaseQuanLy<ThucUong> {
    private static List<ThucUong> dsThucUong = new ArrayList<>();

    {
        doc(Path.THUC_UONG.getPath());
    }

    public ThucUong tim(int ma) {
        return QuanLyThucUong.dsThucUong.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public static ThucUong timTheoTen(String ten) {
        return QuanLyThucUong.dsThucUong.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten)).findFirst().orElse(null);
    }

    @Override
    public boolean them(ThucUong thucUong) {
        QuanLyThucUong.dsThucUong.add(thucUong);

        return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);
    }

    public ThucUong timById(int ma) {
        return QuanLyThucUong.dsThucUong.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public List<ThucUong> timByTen(String ten) {
        return QuanLyThucUong.dsThucUong.stream().filter(p -> p.getTen() == ten).collect(Collectors.toList());

    }
    // public boolean xoa(int ma){

    // return QuanLyThucUong.listThucUong.removeIf(mon-> mon.getMa()==ma);

    // }

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
                ThucUong.setMaThucUong(QuanLyThucUong.dsThucUong
                        .get(QuanLyThucUong.dsThucUong.size() - 1).getMa());

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThucUong> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(path);

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
        if (QuanLyThucUong.dsThucUong.size() != 0) {
            for (ThucUong thucUong : QuanLyThucUong.dsThucUong) {
                thucUong.hienThi();
                System.out.println("------------------------------------");
            }
        }

    }

    @Override
    public void hienThi(List<ThucUong> listThucUong) {

        if (listThucUong.size() != 0) {
            for (ThucUong thucUong : listThucUong) {
                thucUong.hienThi();
                System.out.println("------------------------------------");
            }
        }

    }

    @Override
    public boolean capNhat(String maThucUong, Scanner scanner) {
        ThucUong thucUong = timById(Integer.parseInt(maThucUong));
        if (thucUong != null) {
            try {
                System.out.print("Ten: ");
                thucUong.setTen(scanner.nextLine());

                System.out.print("Hang san xuat:");
                thucUong.setHangSanXuat(scanner.nextLine());

                System.out.print("Gia: ");
                thucUong.setGia(new BigDecimal(scanner.nextLine()));

                return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);

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
            QuanLyThucUong.dsThucUong.remove(thucUong);
            return ghi(Path.THUC_UONG.getPath(), QuanLyThucUong.dsThucUong);
        }
        return false;
    }
}
