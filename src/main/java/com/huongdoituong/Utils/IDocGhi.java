package com.huongdoituong.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface IDocGhi<T> {
    public void Doc(String path, Scanner scanner);

    public boolean Ghi(String path, List<T> items) throws IOException;
}