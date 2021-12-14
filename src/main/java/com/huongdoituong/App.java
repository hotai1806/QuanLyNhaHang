package com.huongdoituong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.huongdoituong.BLL.QuanLySanhCuoi;
import com.huongdoituong.DAL.GiaThue;
import com.huongdoituong.DAL.SanhCuoi;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        QuanLySanhCuoi qlSC = new QuanLySanhCuoi(SCANNER);
        // qlSC.HienThi();
        List<SanhCuoi> listSC = qlSC.traCuuBangTuKhoa("1");
        qlSC.sapXep(listSC);
        qlSC.HienThi(listSC);
        // qlSC.suaSC(SCANNER.nextLine(), SCANNER);
        // qlSC.xoaSC(SCANNER.next());

        // SanhCuoi sc = new SanhCuoi();
        // if (sc.Nhap(SCANNER)) {

        // String sDate1="17/12/2021";
        // Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        // Calendar calendar = new GregorianCalendar();
        // calendar.setTime(date1);

        // int day = calendar.get(Calendar.DAY_OF_WEEK);

        // if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        // sc.setGia(GiaThue.CUOI_TUAN);
        // } else {
        // sc.setGia(GiaThue.NGAY_THUONG);
        // }

        // qlSC.themSC(sc);
        // }
    }
}
