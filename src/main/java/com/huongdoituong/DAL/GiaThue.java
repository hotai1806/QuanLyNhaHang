package com.huongdoituong.DAL;

import java.math.BigDecimal;

public enum GiaThue {
    NGAY_THUONG {
        @Override
        public BigDecimal getGiaThue() {
            return new BigDecimal(6000000);
        }
    },
    CUOI_TUAN {
        @Override
        public BigDecimal getGiaThue() {
            return new BigDecimal(8000000);
        }
    };

    public abstract BigDecimal getGiaThue();