package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ThongTinThue {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
    private final Calendar CALENDAR = new GregorianCalendar();

    public static int dem = 0;

    private int maThue;
    private String tenTiec;
    private Date ngayThue;
    private ThoiDiemThue thoiDiemThue;
    private SanhCuoi sanhCuoi;
    private BigDecimal donGiaThueSanh;
    private List<Menu> dsMenu;
    private BigDecimal tongDonGiaMenu;
    private List<DichVu> dichVu;
    private BigDecimal donGiaDichVu;

    {
        this.setMaThue(++dem);

        this.donGiaThueSanh = new BigDecimal(0);
        this.tongDonGiaMenu = new BigDecimal(0);
        this.donGiaDichVu = new BigDecimal(0);

        dsMenu = new ArrayList<>();
        dichVu = new ArrayList<>();
    }

    public void xuatHoaDon() {
        System.out.println("Ma thue: " + this.getMaThue());
        System.out.println("Tiec: " + this.getTenTiec());
        System.out.println("Ngay thue: " + this.getNgayThueString());
        System.out.println("Thoi diem thue: " + this.getThoiDiemThue().toString());
        System.out.println("Sanh cuoi: " + this.getSanhCuoi().getTenSC());
        System.out.println("Don gia thue sanh: " + this.getDonGiaThueSanh());
        System.out.println("------------------------------");

        for (int i = 0; i < this.getDSMenu().size(); i++) {
            System.out.println("Menu ban: " + i);

            System.out.print("Thuc an: ");
            for (ThucAn thucAn : this.getDSMenu().get(i).getListThucAn()) {
                System.out.print(thucAn.getTen() + " ");
            }

            System.out.print("\nThuc uong: ");
            for (ThucUong thucUong : this.getDSMenu().get(i).getListThucUong()) {
                System.out.print(thucUong.getTen() + " ");
            }

            System.out.println("\n------------------------------------");
        }

        System.out.println("Tong don gia menu: " + this.getTongDonGiaMenu());
        System.out.println("------------------------------");

        System.out.print("Dich vu: ");
        for (DichVu dichVu : this.getDichVu()) {
            System.out.print(dichVu.getTen() + " ");
        }

        System.out.println("\n------------------------------------");
        System.out.println("Tong don gia dich vu: " + this.getDonGiaDichVu());

        System.out.println("===================================");
        System.out.println("Tong don gia  " + this.getTongGia());
        System.out.println("===================================");
    }

    public BigDecimal getTongGia() {
        BigDecimal tongGia = this.getDonGiaThueSanh()
                .add(this.getTongDonGiaMenu())
                .add(this.getDonGiaDichVu());

        return tongGia;
    }

    public boolean kiemTraDichVuTrungLap(DichVu dvCheck) {
        for (DichVu dv : dichVu) {
            if (dvCheck.ten.equals(dv.ten)) {
                return true;
            }
        }

        return false;
    }

    public int getThangThue() {
        CALENDAR.setTime(this.getNgayThue());

        return CALENDAR.get(Calendar.MONTH) + 1;
    }

    public int getNamThue() {
        CALENDAR.setTime(this.getNgayThue());

        return CALENDAR.get(Calendar.YEAR);
    }

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public String getTenTiec() {
        return tenTiec;
    }

    public void setTenTiec(String tenTiec) {
        this.tenTiec = tenTiec;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public String getNgayThueString() {
        return DATE_FORMATER.format(ngayThue);
    }

    public void setNgayThue(String ngayThue) throws ParseException {
        this.ngayThue = DATE_FORMATER.parse(ngayThue);
    }

    public ThoiDiemThue getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(String thoiDiem) throws Exception {
        switch (thoiDiem.toLowerCase().trim()) {
            case "sang":
            this.setThoiDiemThue(ThoiDiemThue.SANG);
            break;
            case "chieu":
            this.setThoiDiemThue(ThoiDiemThue.CHIEU);
            break;
            case "toi":
            this.setThoiDiemThue(ThoiDiemThue.TOI);
            break;
            default:
            throw new Exception("Thoi diem thue hien khong co!!!");
        }
    }
    
    private void setThoiDiemThue(ThoiDiemThue thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

    public SanhCuoi getSanhCuoi() {
        return sanhCuoi;
    }

    public void setSanhCuoi(SanhCuoi sanhCuoi) {
        this.sanhCuoi = sanhCuoi;
    }

    public BigDecimal getDonGiaThueSanh() {
        return donGiaThueSanh;
    }

    public void setDonGiaThueSanh(BigDecimal donGiaThueSanh) {
        this.donGiaThueSanh = donGiaThueSanh;
    }

    public List<Menu> getDSMenu() {
        return dsMenu;
    }

    public BigDecimal getTongDonGiaMenu() {
        if (this.tongDonGiaMenu.compareTo(new BigDecimal(0)) == 0) {
            for (Menu m : dsMenu) {
                tongDonGiaMenu = tongDonGiaMenu.add(m.getTongGia());
            }
        }

        return tongDonGiaMenu;
    }

    public void setTongDonGiaMenu(BigDecimal tongDonGiaMenu) {
        this.tongDonGiaMenu = tongDonGiaMenu;
    }

    public List<DichVu> getDichVu() {
        return dichVu;
    }

    public BigDecimal getDonGiaDichVu() {
        if (donGiaDichVu.compareTo(new BigDecimal(0)) == 0) {
            for (DichVu dv : dichVu) {
                donGiaDichVu = donGiaDichVu.add(dv.gia);
            }
        }

        return donGiaDichVu;
    }
}