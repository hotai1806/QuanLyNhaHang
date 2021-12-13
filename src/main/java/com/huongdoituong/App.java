package com.huongdoituong;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Quan ly nha hang");
            System.out.println("1. Thue sanh");
            System.out.println("2. Quan ly");
            System.out.println("3. Thoat");
            String choice = SCANNER.nextLine();
            switch (choice) {
                case "1": {
                    break;
                }
                case "2": {
                    System.out.println("Quan ly");
                    System.out.println("1. Thue");
                    System.out.println("2. Sanh");
                    System.out.println("3. Dich vu");
                    System.out.println("4. Thuc an");
                    System.out.println("3. Thuc uong");
                    System.out.println("5. Thoat");
                    choice = SCANNER.nextLine();
                    
                    break;
                }
                case "3": {
                    return;
                }
                default:
                    System.out.println("*** Lua chong khong kha dung ***");
                    continue;
            }
        }
    }
}
