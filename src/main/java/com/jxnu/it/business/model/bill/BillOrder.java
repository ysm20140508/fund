package com.jxnu.it.business.model.bill;

import java.util.Date;

/**
 * 商品订单
 *
 * @author shoumiao_yao
 * @date 2016-10-24
 */
public class BillOrder {
    private Integer id;         //订单编号
    private Float total;        //商品总金额
    private Integer num;        //商品数量
    private String time;        //时间
    private BillGood good;      //商品
    private Integer type;       //类型 0:充值  1:消费
    private Date createTime;    //创建时间
    private Date updateTime;    //修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Float getTotal() {
        return total;
    }

    public BillGood getGood() {
        return good;
    }

    public void setGood(BillGood good) {
        this.good = good;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BillOrder{" +
                "id=" + id +
                ", total=" + total +
                ", num=" + num +
                ", time='" + time + '\'' +
                ", good=" + good +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
