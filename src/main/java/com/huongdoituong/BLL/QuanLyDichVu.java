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

import com.huongdoituong.Utils.*;

public class QuanLyDichVu implements IDocGhi<DichVu>, IBaseQuanLy<DichVu> {
    private static List<DichVu> dsDichVu = new ArrayList<>();

    {
        doc(Path.DICH_VU.getPath());
    }

    public List<DichVu> getDSDichVu() {
        return QuanLyDichVu.dsDichVu;
    }

    public static DichVu timByMa(int ma) {
        return QuanLyDichVu.dsDichVu.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public List<DichVu> traCuuByTen(String ten) {
        return QuanLyDichVu.dsDichVu.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten))
                .collect(Collectors.toList());
    }

    @Override
    public boolean them(DichVu dichVu) {
        QuanLyDichVu.dsDichVu.add(dichVu);
        return ghi(Path.DICH_VU.getPath(), QuanLyDichVu.dsDichVu);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.DICH_VU.getPath(), dsDichVu);
    }

    @Override
    public boolean xoa(String ma) {
        DichVu dichVu = timByMa(Integer.parseInt(ma));
        if (dichVu != null) {
            QuanLyDichVu.dsDichVu.remove(dichVu);
            return ghi(Path.DICH_VU.getPath(), QuanLyDichVu.dsDichVu);
        }

        return false;
    }

    @Override
    public void hienThiDS(List<DichVu> dsDichVu) {
        if (dsDichVu.size() != 0) {
            for (DichVu dichVu : dsDichVu) {
                dichVu.hienThi();
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
                    int maDichVu = Integer.parseInt(scanner.nextLine());

                    String tenDichVu = scanner.nextLine();
                    switch (tenDichVu) {
                        case "Karaoke":
                            Karaoke karaoke = new Karaoke();
                            karaoke.setMa(maDichVu);
                            karaoke.setGia(new BigDecimal(scanner.nextLine()));
                            karaoke.setThoiGianThue(Double.parseDouble(scanner.nextLine()));
                            QuanLyDichVu.dsDichVu.add(karaoke);

                            break;
                        case "Thue Ca Si":
                            ThueCaSi thueCaSi = new ThueCaSi();
                            thueCaSi.setMa(maDichVu);
                            thueCaSi.setGia(new BigDecimal(scanner.nextLine()));
                            thueCaSi.setTenCaSi(scanner.nextLine());
                            thueCaSi.setSoLuongBai(Integer.parseInt(scanner.nextLine()));
                            QuanLyDichVu.dsDichVu.add(thueCaSi);

                            break;
                        default:
                            DichVu dichVu = new DichVu();
                            dichVu.setTen(tenDichVu);
                            dichVu.setMa(maDichVu);

                            int lenghtKey = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < lenghtKey; i++) {
                                dichVu.setLuaChonDieuKien(scanner.nextLine(), scanner.nextLine());
                            }
                            
                            dichVu.setGia(new BigDecimal(scanner.nextLine()));

                            QuanLyDichVu.dsDichVu.add(dichVu);
                            continue;
                    }
                }

                // Lay so cuoi tu ma dich vu lam bien dem
                DichVu.setAutoIncreament(QuanLyDichVu.dsDichVu.get(QuanLyDichVu.dsDichVu.size() - 1).getMa());

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<DichVu> dsDichVu) {
        if (!dsDichVu.isEmpty()) {
            try {
                File file = new File(path);

                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (DichVu dv : dsDichVu) {
                        dv.ghi(printWriter);
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
