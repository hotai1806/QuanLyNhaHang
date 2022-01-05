package com.huongdoituong.BLL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.DAL.GiaThue;

import com.huongdoituong.Utils.IDocGhi;
import com.huongdoituong.Utils.Path;

public class QuanLyGiaThue implements IDocGhi<GiaThue> {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM");
    private final Calendar CALENDAR = new GregorianCalendar();

    private List<GiaThue> dsGiaThue = new ArrayList<>();

    {
        doc(Path.GIA_THUE.getPath());
    }

    public BigDecimal getGia(String ngayThue) throws ParseException {
        String ngayThangThue = getNgayVaThangThue(ngayThue);
        GiaThue giaThue = traCuuTheoNgayThue(ngayThangThue);

        return giaThue == null ? getGiaNgayThuong(ngayThangThue) : giaThue.getGiaThue();
    }

    private GiaThue traCuuTheoNgayThue(String ngayThangThue) {
        return dsGiaThue.stream()
                .filter(p -> p.getNgayThue().equals(ngayThangThue))
                .findFirst().orElse(null);
    }

    private BigDecimal getGiaNgayThuong(String ngayThue) throws ParseException {
        CALENDAR.setTime(DATE_FORMATER.parse(ngayThue));
        int ngay = CALENDAR.get(Calendar.DAY_OF_WEEK);

        switch (ngay) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                return traCuuTheoTen("cuoituan").getGiaThue();
            default:
                return traCuuTheoTen("ngaythuong").getGiaThue();
        }
    }

    private GiaThue traCuuTheoTen(String tenGiaThue) {
        return dsGiaThue.stream()
                .filter(p -> p.getTen().equalsIgnoreCase(tenGiaThue))
                .findFirst().orElse(null);
    }

    private String getNgayVaThangThue(String ngayThue) {
        return ngayThue.substring(0, 5);
    }

    public boolean them(GiaThue item) {
        this.dsGiaThue.add(item);

        return ghi(Path.GIA_THUE.getPath(), this.dsGiaThue);
    }

    @Override
    public void doc(String path) {
        File file = new File(path);

        if (file.exists() && file.length() > 0) {
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    GiaThue giaThue = new GiaThue();

                    giaThue.setMaGiaThue(scanner.nextInt());
                    scanner.nextLine();

                    giaThue.setTen(scanner.nextLine());
                    giaThue.setNgayThue(scanner.nextLine());
                    giaThue.setGiaThue(scanner.nextBigDecimal());

                    this.dsGiaThue.add(giaThue);

                    if (scanner.hasNext()) {
                        scanner.nextLine();
                    }
                }

                // Lay so cuoi tu ma thue lam bien dem
                GiaThue.dem = this.dsGiaThue.get(this.dsGiaThue.size() - 1).getMaGiaThue();

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ghi(String path, List<GiaThue> items) {
        if (!items.isEmpty()) {
            File file = new File(path);

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (GiaThue giaThue : items) {
                    printWriter.println(giaThue.getMaGiaThue());
                    printWriter.println(giaThue.getTen());
                    printWriter.println(giaThue.getNgayThue());
                    printWriter.println(giaThue.getGiaThue());
                }

                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }

        return false;
    }
}
