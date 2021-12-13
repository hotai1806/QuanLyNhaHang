package com.huongdoituong;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.huongdoituong.Models.SanhCuoi;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        SanhCuoi sc = new SanhCuoi("ten", 1);

        File f = new File("src/main/resources/output.txt");
        FileWriter fw = new FileWriter(f, true);

        try (PrintWriter w = new PrintWriter(fw)) {
            w.println(sc.getMaSC());
        }
    }
}
