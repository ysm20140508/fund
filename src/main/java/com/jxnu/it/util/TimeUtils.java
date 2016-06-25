package com.jxnu.it.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    /**
     * 现在
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
    /**
     * 昨天
     * @return
     */
    public static String getYesterdayTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        return format.format(calendar.getTime());
    }
    /**
     * 获取间隔天数的日期
     * @param day
     * @return
     */
    public static String getBetweenDayTime(int day){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DATE ,calendar.get(Calendar.DATE)+day);
        return  format.format(calendar.getTime());
    }
    /**
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static String getStartTime(String startTime, String endTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	long monthTimes = 60 * 24 * 60 * 60 * 1000 ;
			Long start = format.parse(startTime).getTime();
			Long end = format.parse(endTime).getTime();
			if(end - start > monthTimes){
				start = end - monthTimes;
				startTime = format.format(new Date(start));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return startTime;
    }
    /**
     * 指定时间相隔几天
     * @param starttime
     * @param day
     * @return
     */
    public static String getBetweenTime(String starttime , int day){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(starttime);
        } catch (ParseException e) {
            return "";
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE , calendar.get(Calendar.DATE)+day);
        return  format.format(calendar.getTime());
    }


    public static void main(String[] args) {
        String nowDate=TimeUtils.getCurrentTime();
        String yesterdayTime=TimeUtils.getYesterdayTime();
        String betweenDayTime=TimeUtils.getBetweenDayTime(2);
        String s=TimeUtils.getBetweenTime(betweenDayTime,3);
        boolean f=2==2;
    }
}