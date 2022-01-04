package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
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

    {
        doc(Path.DICH_VU.getPath());
    }

    public DichVu timById(int ma) {
        return QuanLyDichVu.listDichVu.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public static List<DichVu> timByTen(String ten) {
        return QuanLyDichVu.listDichVu.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten)).collect(Collectors.toList());
    }

    @Override
    public boolean them(DichVu dichVu) {
        QuanLyDichVu.listDichVu.add(dichVu);

        return ghi(Path.DICH_VU.getPath(), QuanLyDichVu.listDichVu);
    }

    @Override
    public void doc(String path) {
        File file = new File(Path.DICH_VU.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    int maDichVu = Integer.parseInt(scanner.nextLine());
                    String tenDichVu = scanner.nextLine();
                    switch (tenDichVu) {
                        case "Karaoke":
                            Karaoke karaoke = new Karaoke();
                            karaoke.doc(scanner,maDichVu);
                            QuanLyDichVu.listDichVu.add(karaoke);

                            break;
                        case "Thue Ca Si":
                            ThueCaSi thueCaSi = new ThueCaSi();
                            thueCaSi.doc(scanner,maDichVu);
                            QuanLyDichVu.listDichVu.add(thueCaSi);

                            break;
                        default:
                            DichVu dichVu = new DichVu();

                            dichVu.setTen(tenDichVu);
                            dichVu.doc(scanner,maDichVu);

                            QuanLyDichVu.listDichVu.add(dichVu);
                            continue;

                    }
                    // if (scanner.hasNext()) {
                    //     scanner.nextLine();
                    // }

                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<DichVu> items) {
        if (!items.isEmpty()) {
            try {
                File file = new File(path);

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (DichVu mon : items) {
                        mon.ghi(printWriter);
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
            for (DichVu dichVu : QuanLyDichVu.listDichVu) {
                dichVu.hienThi();
                System.out.println("------------------------------------");
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
                // System.out.print("Ten: ");
                // dichVu.setTen(scanner.nextLine());
                // System.out.print("Gia: ");
                // dichVu.setGia(new BigDecimal(scanner.nextLine()));
                dichVu.capNhat(scanner);
                // return ghi(Path.DICH_VU.getPath(), listDichVu);
                return true;

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
