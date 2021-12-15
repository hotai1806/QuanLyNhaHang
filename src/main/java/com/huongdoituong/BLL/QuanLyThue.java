package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThongTinThue;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThue implements IDocGhi<ThongTinThue> {
    private List<ThongTinThue> listThongTinThue = new ArrayList<>();

    public QuanLyThue() {
        doc(Path.THONG_TIN_THUE.getPath());
    }

    public boolean themThongTinThue(ThongTinThue thongTinThue) {
        this.listThongTinThue.add(thongTinThue);

        return ghi(Path.THONG_TIN_THUE.getPath(), this.listThongTinThue);
    }

    @Override
    public void doc(String path) {
        File file = new File(Path.THONG_TIN_THUE.getPath());

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    ThongTinThue thongTinThue = new ThongTinThue();

                    thongTinThue.setMaThue(scanner.nextInt());
                    thongTinThue.setTenTiec(scanner.nextLine());
                    thongTinThue.setNgayThue(scanner.nextLine());
                    thongTinThue.setThoiDiemThue(scanner.nextLine());
                    thongTinThue.setSanhCuoi(QuanLySanhCuoi.traCuuBangMaSC(scanner.nextLine()));
                    thongTinThue.setDonGiaThueSanh(scanner.nextBigDecimal());

                    this.listThongTinThue.add(thongTinThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay 3 so cuoi tu ma sanh cuoi S*** cuoi cung lam bien dem
                ThongTinThue.dem = this.listThongTinThue.get(this.listThongTinThue.size() - 1).getMaThue();

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<ThongTinThue> items) {
        if (!items.isEmpty()) {
            File file = new File(Path.THONG_TIN_THUE.getPath());

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (ThongTinThue thongTinThue : items) {
                    printWriter.println(thongTinThue.getMaThue());
                    printWriter.println(thongTinThue.getTenTiec());
                    printWriter.println(thongTinThue.getNgayThue());
                    printWriter.println(thongTinThue.getThoiDiemThue().toInt());
                    printWriter.println(thongTinThue.getSanhCuoi().getMaSC());
                    printWriter.println(thongTinThue.getDonGiaThueSanh());
                }

                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }

        return false;
    }

    @Override
    public void hienThi() {

    }

    @Override
    public void hienThi(List<ThongTinThue> items) {

    }
}
