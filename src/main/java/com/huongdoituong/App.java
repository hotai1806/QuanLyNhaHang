package com.huongdoituong;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final StringBuilder BUILDER = new StringBuilder();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final List<FuncTypes> menuMain = Arrays.asList(FuncTypes.THUESANH, FuncTypes.QUANLY);
    private static final List<FuncTypes> menuQuanLy = Arrays.asList(FuncTypes.QUANLY_SANHCUOI,
                                                                    FuncTypes.QUANLY_DICHVU,
                                                                    FuncTypes.QUANLY_THUE,
                                                                    FuncTypes.QUANLY_THUCAN,
                                                                    FuncTypes.QUANLY_THUCUONG);

    private static FuncTypes funcType = FuncTypes.NONE;

    public static void main(String[] args) {
        ChooseFunc(menuMain, "Quan ly nha hang\n1. Thue\n2. Quan ly\nChon chuc nang: ");

        ChooseFunc(menuQuanLy, "Quan ly \n1. Thue\n2. Quan ly\nChon chuc nang: ");
    }

    private static void ChooseFunc(List<FuncTypes> funcTypes, String guide) {
        boolean isCheckWrongInput = false;
        int funcSelection = 0;

        while (!funcTypes.contains(funcType)) {
            if (isCheckWrongInput && !funcTypes.contains(funcType)) {
                System.out.print("***Chuc nang khong kha dung***\n");
            }

            System.out.print(guide);
            funcSelection = SCANNER.nextInt();

            Hashtable<Integer, FuncTypes> hashtable = CreateHashTableFromList(funcTypes);

            if (hashtable.containsKey(funcSelection)) {
                funcType = hashtable.get(funcSelection);
            }

            isCheckWrongInput = true;
        }
    }

    private static Hashtable<Integer, FuncTypes> CreateHashTableFromList(List<FuncTypes> funcTypes) {
        if (!funcTypes.isEmpty()) {
            Hashtable<Integer, FuncTypes> hashtable = new Hashtable<>();
            int count = 1;

            for (FuncTypes funcType : funcTypes) {
                hashtable.put(count, funcType);
                count++;
            }

            return hashtable;
        }

        return null;
    }
}
