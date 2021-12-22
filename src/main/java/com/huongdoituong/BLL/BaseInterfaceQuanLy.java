package com.huongdoituong.BLL;

import java.util.List;
import java.util.Scanner;

public interface BaseInterfaceQuanLy<T> {
    public void hienThi();

    public  void hienThi(List<T> list);

    public boolean capNhat(int ma,Scanner scanner);
    public boolean xoa(int ma);
}
