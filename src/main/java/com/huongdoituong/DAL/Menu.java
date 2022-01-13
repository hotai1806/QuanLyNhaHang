package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ThucAn> dsThucAn = new ArrayList<ThucAn>();
    private List<ThucUong> dsThucUong = new ArrayList<ThucUong>();

    public void themThucAn(ThucAn mon) {
        this.dsThucAn.add(mon);
    }

    public void themThucUong(ThucUong mon) {
        this.dsThucUong.add(mon);
    }

    public BigDecimal getTongGia() {
        BigDecimal tongGiaThucAn = dsThucAn.stream()
                .map(p -> p.getGia())
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        BigDecimal tongGiaThucUong = dsThucUong.stream()
                .map(p -> p.getGia())
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        return tongGiaThucAn.add(tongGiaThucUong);
    }

    public List<ThucAn> getDSThucAn() {
        return this.dsThucAn;
    }

    public List<ThucUong> getDSThucUong() {
        return this.dsThucUong;
    }
}