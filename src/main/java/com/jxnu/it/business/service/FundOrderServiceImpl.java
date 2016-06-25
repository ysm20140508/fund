package com.jxnu.it.business.service;


import com.jxnu.it.business.model.FundMarkLineData;
import com.jxnu.it.business.model.FundMarkPointData;
import com.jxnu.it.business.model.FundOrder;
import com.jxnu.it.business.store.FundOrderStore;
import com.jxnu.it.util.DecimalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FundOrderServiceImpl implements FundOrderService {
    @Resource
    private FundOrderStore fundOrderStore;


    @Override
    public List<FundOrder> query(String keyword, String status, Integer page, Integer pageSize) {
        return fundOrderStore.query(keyword, status, page, pageSize);
    }

    @Override
    public FundOrder find(Integer id) {
        return fundOrderStore.find(id);
    }

    @Override
    public Integer create(FundOrder whiteUser) {
        if (fundOrderStore.create(whiteUser))
            return 0;
        else return 1;
    }

    @Override
    public Integer edit(FundOrder whiteUser) {
        if (fundOrderStore.edit(whiteUser))
            return 0;
        else return 1;
    }

    @Override
    public Integer sale(FundOrder fundOrder) {
        if (fundOrderStore.sale(fundOrder))
            return 0;
        else return 1;
    }

    @Override
    public List<FundMarkPointData> query(Integer code) {
        return fundOrderStore.query(code);
    }

    @Override
    public List<FundMarkLineData> queryLineData(Integer code) {
        List<FundMarkLineData> fundMarkLineDataList = new ArrayList<>();
        if (code == null) {
            code = 2;
        }
        List<FundOrder> fundOrderList = fundOrderStore.query(code + "", "1", null, null);
        for (FundOrder fundOrder : fundOrderList) {
            FundMarkLineData fundMarkLineData = new FundMarkLineData();
            List<FundMarkPointData> fundMarkPointDataList = assem(fundOrder);
            if (fundMarkPointDataList == null) continue;
            fundMarkLineData.setFundMarkPointDataList(fundMarkPointDataList);
            fundMarkLineDataList.add(fundMarkLineData);
        }
        return fundMarkLineDataList;
    }


    //组装订单数据
    public List<FundMarkPointData> assem(FundOrder fundOrder) {
        if (fundOrder == null || fundOrder.getStartNetWorth() == null || fundOrder.getSaleNetWorth() == null)
            return null;
        Double account = DecimalUtil.div(DecimalUtil.sub(fundOrder.getSaleNetWorth(), fundOrder.getStartNetWorth()), fundOrder.getStartNetWorth());
        String value = DecimalUtil.mul(account, 100.00).toString();
        String name = value + "%";
        List<FundMarkPointData> fundMarkPointDataList = new ArrayList<>();
        FundMarkPointData fundMarkPointData = new FundMarkPointData();
        fundMarkPointData.setName(name);
        fundMarkPointData.setValue(value);
        fundMarkPointData.setxAxis(fundOrder.getStartTime());
        fundMarkPointData.setyAxis(fundOrder.getStartNetWorth().toString());
        fundMarkPointDataList.add(fundMarkPointData);
        FundMarkPointData fundMarkPointData1 = new FundMarkPointData();
        fundMarkPointData1.setName(name);
        fundMarkPointData1.setValue(value);
        fundMarkPointData1.setxAxis(fundOrder.getSaleTime());
        fundMarkPointData1.setyAxis(fundOrder.getSaleNetWorth().toString());
        fundMarkPointDataList.add(fundMarkPointData1);
        return fundMarkPointDataList;
    }
}
