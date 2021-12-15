package com.huongdoituong.Utils;

public enum Path {
    SANH_CUOI {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachSanhCuoi.dat";
        }
    },
    THONG_TIN_THUE {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachThongTinThue.txt";
        }
    };

    public abstract String getPath();
}