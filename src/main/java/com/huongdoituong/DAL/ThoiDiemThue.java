package com.huongdoituong.DAL;

public enum ThoiDiemThue {
    SANG {
        @Override
        public String toString() {
            return "sang";
        }
    },
    CHIEU {
        @Override
        public String toString() {
            return "chieu";
        }
    },
    TOI {
        @Override
        public String toString() {
            return "toi";
        }
    };
}
