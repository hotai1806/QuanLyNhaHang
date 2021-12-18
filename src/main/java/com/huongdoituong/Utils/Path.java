package com.huongdoituong.Utils;

public enum Path {
    SANH_CUOI {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachSanhCuoi.txt";
        }

    },
    THONG_TIN_THUE {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachThongTinThue.txt";
        }
    },
    THUC_AN {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachThucAn.txt";
        }
    },
    THUC_UONG {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachThucUong.txt";
        }
    },
    MENU {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachMenu.txt";
        }
    },
    DICH_VU {
        @Override
        public String getPath() {
            return "src/main/resources/DanhSachDichVu.txt";
        }
    };

    public abstract String getPath();
}