package com.huongdoituong.DAL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ThucAn> listThucAn = new ArrayList<ThucAn>();
    private List<ThucUong> listThucUong = new ArrayList<ThucUong>();

    public void themThucAn(ThucAn mon) {
        this.listThucAn.add(mon);
    }

    public void themThucUong(ThucUong mon) {
        this.listThucUong.add(mon);
    }

    public BigDecimal getTongGia() {
        BigDecimal tongGiaThucAn = listThucAn.stream()
                .map(p -> p.getGia())
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        BigDecimal tongGiaThucUong = listThucUong.stream()
                .map(p -> p.getGia())
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        return tongGiaThucAn.add(tongGiaThucUong);
    }

    public List<ThucAn> getListThucAn() {
        return this.listThucAn;
    }

    public List<ThucUong> getListThucUong() {
        return this.listThucUong;
    }

    public ThucAn timThucAn(int ma) {
        return this.listThucAn.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }

    public ThucUong timThucUong(int ma) {
        return this.listThucUong.stream().filter(p -> p.getMa() == ma).findFirst().orElse(null);
    }
}