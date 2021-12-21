package com.huongdoituong.Utils;

import java.util.List;

public interface IDocGhi<T> {
    public void doc(String path);

    public boolean ghi(String path, List<T> items);
}