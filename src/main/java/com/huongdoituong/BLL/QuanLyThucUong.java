package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThucUong;

import com.huongdoituong.Utils.*;

public class QuanLyThucUong implements IDocGhi<ThucUong>, IBaseQuanLy<ThucUong> {
    private List<ThucUong> dsThucUong = new ArrayList<>();

    {
        doc(Path.THUC_UONG.getPath());
    }

    public List<ThucUong> getDSThucUong() {
        return this.dsThucUong;
    }

    public ThucUong timById(int ma) {
        return this.dsThucUong.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public ThucUong timByTen(String ten) {
        return this.dsThucUong.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(ten))
                .findFirst().orElse(null);
    }

    @Override
    public boolean them(ThucUong thucUong) {
        this.dsThucUong.add(thucUong);

        return ghi(Path.THUC_UONG.getPath(), this.dsThucUong);
    }

    @Override
    public boolean capNhatDS() {
        return ghi(Path.THUC_UONG.getPath(), this.dsThucUong);
    }

    @Override
    public boolean xoa(String ma) {
        ThucUong thucUong = timById(Integer.parseInt(ma));
        
        if (thucUong != null) {
            this.dsThucUong.remove(thucUong);
            return ghi(Path.THUC_UONG.getPath(), this.dsThucUong);
        }

        return false;
    }

    @Override
    public void hienThiDS(List<ThucUong> listThucUong) {

        if (listThucUong.size() != 0) {
            for (ThucUong thucUong : listThucUong) {
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

                    this.dsThucUong.add(thucUong);
                }

                // Lay so cuoi tu ma thuc uong lam bien dem
                ThucUong.setMaThucUong(this.dsThucUong.get(this.dsThucUong.size() - 1).getMa());

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
}
