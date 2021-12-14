package com.huongdoituong.Utils;

import java.util.List;
import java.util.Scanner;

public interface IDocGhi<T> {
    public void doc(String path, Scanner scanner);

    public boolean ghi(String path, List<T> items);

    public void hienThi();

    public void hienThi(List<T> items);
}