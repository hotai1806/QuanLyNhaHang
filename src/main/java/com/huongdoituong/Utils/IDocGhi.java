package com.huongdoituong.Utils;

import java.util.List;
import java.util.Scanner;

public interface IDocGhi<T> {
    public void Doc(String path, Scanner scanner);

    public boolean Ghi(String path, List<T> items);

    public void HienThi();

    public void HienThi(List<T> items);
}