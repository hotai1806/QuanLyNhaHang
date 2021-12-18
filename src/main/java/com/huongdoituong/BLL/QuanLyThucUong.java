package com.huongdoituong.BLL;

import java.io.File;
import java.io.PrintWriter;

// import com.huongdoituong.Utils.IDocGhi;
// import com.huongdoituong.Utils.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.ThucUong;
import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyThucUong implements IDocGhi<ThucUong>{
    private static List<ThucUong> listThucUong = new ArrayList<>();
    
    public QuanLyThucUong(){
    }
    public static ThucUong tim(int ma){
        return QuanLyThucUong.listThucUong.stream().filter(p->p.getMa()==ma).findFirst().get();

    }

    public static ThucUong timTheoTen(String ten){
        return QuanLyThucUong.listThucUong.stream().filter(p->p.getTen()==ten).findFirst().get();

    }

    public boolean them(ThucUong thucUong){
        return QuanLyThucUong.listThucUong.add(thucUong);
    }
    public boolean xoa(int ma){
        
      return  QuanLyThucUong.listThucUong.removeIf(mon-> mon.getMa()==ma);

    }

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

    }

    @Override
    public void hienThi(List<ThucUong> items) {

    }
}
