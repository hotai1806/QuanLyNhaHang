package com.huongdoituong.Utils;

import java.util.List;

public interface IBaseQuanLy<T> {
    public void hienThiDS(List<T> list);

    public boolean them(T item);

    public boolean capNhatDS();

    public boolean xoa(String ma);
}
