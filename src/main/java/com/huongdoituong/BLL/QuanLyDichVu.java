package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.huongdoituong.DAL.DichVu;
import com.huongdoituong.DAL.Karaoke;
import com.huongdoituong.DAL.ThueCaSi;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyDichVu implements IDocGhi<DichVu>, BaseInterfaceQuanLy<DichVu> {
    private static List<DichVu> listDichVu = new ArrayList<>();

    public QuanLyDichVu() {
    }

    public static DichVu timById(int ma) {
        return QuanLyDichVu.listDichVu.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public static List<DichVu> timByTen(String ten) {
        return QuanLyDichVu.listDichVu.stream().filter(p -> p.getTen() == ten).collect(Collectors.toList());
    }

    @Override
    public boolean them(DichVu dichVu) {
        return QuanLyDichVu.listDichVu.add(dichVu);
    }

    // public boolean them(Karaoke dichVu) {
    // return QuanLyDichVu.listDichVu.add(dichVu);
    // }

    // public boolean them(ThueCaSi dichVu) {
    // return QuanLyDichVu.listDichVu.add(dichVu);
    // }

    // public boolean xoa(int ma) {

    // return QuanLyDichVu.listDichVu.removeIf(mon -> mon.getMa() == ma);

    // }

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
        if (QuanLyDichVu.listDichVu.size() != 0) {
            System.out.println("-------------- Dich Vu ----------------");

            for (DichVu dichVu : QuanLyDichVu.listDichVu) {
                dichVu.hienThi();
                // System.out.println("Ma dich vu:" + String.format("%s", dichVu.getMa()));
                // System.out.println("Ten dich vu:" + dichVu.getTen());
                // if (dichVu.getStoreKey().isEmpty()) {
                // for (String key : dichVu.getStoreKey()) {
                // if (key != null) {
                // System.out.println(key + ": " + dichVu.getLuaChonDieuKien().get(key));

                // }
                // }
                // }

                // System.out.println("Tong gia dich vu:" + dichVu.getGia());

            }
        }

    }

    @Override
    public void hienThi(List<DichVu> listDichVu) {

        if (listDichVu.size() != 0) {
            System.out.println("-------------- Dich Vu ----------------");
            for (DichVu dichVu : listDichVu) {
                dichVu.hienThi();
            }
        }

    }

    @Override
    public boolean capNhat(String maDichVu, Scanner scanner) {
        DichVu dichVu = timById(Integer.parseInt(maDichVu));
        if (dichVu != null) {
            try {
                System.out.print("Ten: ");
                dichVu.setTen(scanner.nextLine());
                System.out.print("Gia: ");
                dichVu.setGia(scanner.nextBigDecimal());

            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return false;
    }

    @Override
    public boolean xoa(String ma) {
        DichVu dichVu = timById(Integer.parseInt(ma));
        if (dichVu != null) {
            QuanLyDichVu.listDichVu.remove(dichVu);
            return ghi(Path.DICH_VU.getPath(), QuanLyDichVu.listDichVu);
        }
        return false;
    }
}
