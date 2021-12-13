package com.huongdoituong.Utils;

public enum Path {
    SANH_CUOI {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachSanhCuoi.txt";
        }
    };

    public abstract String getPath();
}
