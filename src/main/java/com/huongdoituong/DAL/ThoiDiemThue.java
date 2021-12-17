package com.huongdoituong.DAL;

public enum ThoiDiemThue {
    SANG {
        @Override
        public int toInt() {
            return 1;
        }
    },
    CHIEU {
        @Override
        public int toInt() {
            return 2;
        }
    },
    TOI {
        @Override
        public int toInt() {
            return 3;
        }
    };

    public abstract int toInt();
}
