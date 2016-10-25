package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.store.bill.BillBalanceStore;

/**
 * @author shoumiao_yao
 * @date 2016-10-25
 */
public class BillThread implements Runnable {
    private BillBalanceStore store;

    public BillThread(BillBalanceStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        store.queryMonthBill();
    }
}
