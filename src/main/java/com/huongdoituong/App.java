package com.huongdoituong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.BLL.QuanLyThue;
import com.huongdoituong.DAL.GiaThue;
import com.huongdoituong.DAL.SanhCuoi;
import com.huongdoituong.DAL.ThongTinThue;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        // QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        QuanLyThue quanLyThue = new QuanLyThue();

        // SanhCuoi sc = new SanhCuoi();
        // if (sc.Nhap(SCANNER)) {

        //     String sDate1 = "17/12/2021";
        //     Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        //     Calendar calendar = new GregorianCalendar();
        //     calendar.setTime(date1);

        //     int day = calendar.get(Calendar.DAY_OF_WEEK);

        //     if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        //         sc.setGia(GiaThue.CUOI_TUAN);
        //     } else {
        //         sc.setGia(GiaThue.NGAY_THUONG);
        //     }

        //     quanLySanhCuoi.themSC(sc);
        // }

        ThongTinThue thongTinThue = new ThongTinThue();
        if (thongTinThue.Nhap(SCANNER)) {
            quanLyThue.themThongTinThue(thongTinThue);
        }
    }
}
