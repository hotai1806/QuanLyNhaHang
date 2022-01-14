package com.huongdoituong.Views;

import java.util.Scanner;

public interface ViewBase<T> {
    public void themView(Scanner scanner, T quanly);

    public void xoaView(Scanner scanner, T quanly);

    public void capNhatView(Scanner scanner, T quanly);

    public void traCuuView(Scanner scanner, T quanly);
}
