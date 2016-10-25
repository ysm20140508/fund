package com.jxnu.it.business.model.bill;

import java.util.Date;

/**
 * @author shoumiao_yao
 * @date 2016-10-25
 */
public class BillBalance {
    private Integer id;        //编号
    private String time;       //时间
    private Float balance;     //余额
    private Integer type;      //类型
    private Date updateTime;   //更新时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BillBalance{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                ", updateTime=" + updateTime +
                '}';
    }
}
