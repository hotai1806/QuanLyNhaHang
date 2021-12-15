package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ThongTinThue {
    public static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
    public static int dem = 0;

    private int maThue;
    private String tenTiec;
    private Date ngayThue;
    private ThoiDiemThue thoiDiemThue;
    private SanhCuoi sanhCuoi;
    private BigDecimal donGiaThueSanh;
    private String[] menu;
    private BigDecimal donGiaMenu;
    private String[] dichVu;

    {
        this.setMaThue(++dem);
    }

    public boolean Nhap(Scanner scanner) {
        try {
            System.out.print("Ten tiec: ");
            this.setTenTiec(scanner.nextLine());

            System.out.print("Ngay thue ");
            this.setNgayThue(scanner.nextLine());
            System.out.println(this.getNgayThue());

            System.out.println("Thoi diem thue: ");
            System.out.println("1. Sang");
            System.out.println("2. Chieu");
            System.out.println("3. Toi");    
            this.setThoiDiemThue(scanner.nextLine());

            System.out.print("Ten tiec: ");
            this.setTenTiec(scanner.nextLine());

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public ThoiDiemThue getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(ThoiDiemThue thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

    public void setThoiDiemThue(String thoiDiem) throws Exception {
        switch (Integer.parseInt(thoiDiem)) {
            case 1:
                this.setThoiDiemThue(ThoiDiemThue.SANG);
                break;
            case 2:
                this.setThoiDiemThue(ThoiDiemThue.CHIEU);
                break;
            case 3:
                this.setThoiDiemThue(ThoiDiemThue.TOI);
                break;
            default:
                throw new Exception("Thoi diem thue hien khong co!!!");
        }
    }

    public int getMaThue() {
        return maThue;
    }

    public String[] getDichVu() {
        return dichVu;
    }

    public void setDichVu(String[] dichVu) {
        this.dichVu = dichVu;
    }

    public SanhCuoi getSanhCuoi() {
        return sanhCuoi;
    }

    public void setSanhCuoi(SanhCuoi sanhCuoi) {
        this.sanhCuoi = sanhCuoi;
    }

    public BigDecimal getTongGiaMenu() {
        return donGiaMenu;
    }

    public void setTongGiaMenu(BigDecimal tongGiaMenu) {
        this.donGiaMenu = tongGiaMenu;
    }

    public BigDecimal getDonGiaThueSanh() {
        return donGiaThueSanh;
    }

    public void setDonGiaThueSanh(BigDecimal donGiaThueSanh) {
        this.donGiaThueSanh = donGiaThueSanh;
    }

    public String getNgayThue() {
        return DATE_FORMATER.format(ngayThue);
    }

    public void setNgayThue(String ngayThue) throws ParseException {
        this.ngayThue = DATE_FORMATER.parse(ngayThue);
    }

    public String getTenTiec() {
        return tenTiec;
    }

    public void setTenTiec(String tenTiec) {
        this.tenTiec = tenTiec;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }
}