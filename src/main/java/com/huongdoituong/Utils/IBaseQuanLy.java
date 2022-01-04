package com.huongdoituong.Utils;

import java.util.List;
import java.util.Scanner;

public interface IBaseQuanLy<T> {
    public void hienThi();

    public void hienThi(List<T> list);

    public boolean them(T item);

    public boolean capNhat(String ma, Scanner scanner);

    public boolean xoa(String ma);
}
