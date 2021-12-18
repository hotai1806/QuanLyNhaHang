package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ThongTinThue {
    private final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
    
    public static int dem = 0;

    private int maThue;
    private String tenTiec;
    private Date ngayThue;
    private ThoiDiemThue thoiDiemThue;
    private SanhCuoi sanhCuoi;
    private BigDecimal donGiaThueSanh;
    private List<Menu> menu;
    private BigDecimal donGiaMenu;
    private List<DichVu> dichVu;
    private BigDecimal donGiaDichVu;

    {
        this.setMaThue(++dem);

        this.donGiaThueSanh = new BigDecimal(0);
        this.donGiaMenu = new BigDecimal(0);
        this.donGiaDichVu = new BigDecimal(0);

        menu = new ArrayList<>();
        dichVu = new ArrayList<>();
    }

    public BigDecimal getTongGia() {
        BigDecimal tongGia = getDonGiaThueSanh().add(getDonGiaMenu()).add(getDonGiaDichVu());

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

    public BigDecimal getDonGiaDichVu() {
        for (DichVu dv : dichVu) {
            donGiaDichVu = donGiaDichVu.add(dv.gia);
        }

        return donGiaDichVu;
    }

    public void setDonGiaDichVu(BigDecimal donGiaDichVu) {
        this.donGiaDichVu = donGiaDichVu;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
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

    public List<DichVu> getDichVu() {
        return dichVu;
    }

    public void setDichVu(List<DichVu> dichVu) {
        this.dichVu = dichVu;
    }

    public SanhCuoi getSanhCuoi() {
        return sanhCuoi;
    }

    public void setSanhCuoi(SanhCuoi sanhCuoi) {
        this.sanhCuoi = sanhCuoi;
    }

    public BigDecimal getDonGiaMenu() {
        for (Menu m : menu) {
            donGiaMenu = donGiaMenu.add(m.getTongGia());
        }

        return donGiaMenu;
    }

    public void setDonGiaMenu(BigDecimal donGiaMenu) {
        this.donGiaMenu = donGiaMenu;
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