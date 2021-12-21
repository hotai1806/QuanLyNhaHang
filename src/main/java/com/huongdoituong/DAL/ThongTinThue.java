package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.huongdoituong.App.DichVu;
import com.huongdoituong.App.Menu;

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
    private List<Menu> menu;
    private BigDecimal tongDonGiaMenu;
    private List<DichVu> dichVu;
    private BigDecimal donGiaDichVu;

    {
        this.setMaThue(++dem);

        this.donGiaThueSanh = new BigDecimal(0);
        this.tongDonGiaMenu = new BigDecimal(0);
        this.donGiaDichVu = new BigDecimal(0);

        menu = new ArrayList<>();
        dichVu = new ArrayList<>();
    }

    public BigDecimal getTongGia() {
        BigDecimal tongGia = getDonGiaThueSanh().add(getTongDonGiaMenu()).add(getDonGiaDichVu());

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
        CALENDAR.setTime(this.ngayThue);

        return CALENDAR.get(Calendar.MONTH) + 1;
    }

    public int getNamThue() {
        CALENDAR.setTime(this.ngayThue);

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

    public String getNgayThue() {
        return DATE_FORMATER.format(ngayThue);
    }

    public void setNgayThue(String ngayThue) throws ParseException {
        this.ngayThue = DATE_FORMATER.parse(ngayThue);
    }

    public ThoiDiemThue getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(ThoiDiemThue thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
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

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public BigDecimal getTongDonGiaMenu() {
        for (Menu m : menu) {
            tongDonGiaMenu = tongDonGiaMenu.add(m.getTongGia());
        }

        return tongDonGiaMenu;
    }

    public void setTongDonGiaMenu(BigDecimal tongDonGiaMenu) {
        this.tongDonGiaMenu = tongDonGiaMenu;
    }

    public List<DichVu> getDichVu() {
        return dichVu;
    }

    public void setDichVu(List<DichVu> dichVu) {
        this.dichVu = dichVu;
    }

    public BigDecimal getDonGiaDichVu() {
        for (DichVu dv : dichVu) {
            donGiaDichVu = donGiaDichVu.add(dv.gia);
        }

        return donGiaDichVu;
    }

    public void setDonGiaDichVu(BigDecimal donGiaDichVu) {
        this.donGiaDichVu = donGiaDichVu;
    }
}