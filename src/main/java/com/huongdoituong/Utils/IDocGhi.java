package com.huongdoituong.Utils;

import java.util.List;

public interface IDocGhi<T> {
    public void doc(String path);

    public boolean ghi(String path, List<T> items);

    public void hienThi();

    public void hienThi(List<T> items);
}