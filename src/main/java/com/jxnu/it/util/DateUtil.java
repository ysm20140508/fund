package com.jxnu.it.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vxbb on 2014/9/18.
 */
public class DateUtil {

    public static Date parseUtilDate(String dateStr,String pattern){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static java.sql.Date parseSqlDate(String dateStr,String pattern){
       Date utilDate = parseUtilDate(dateStr,pattern);
        if(utilDate!=null){
            return new java.sql.Date(utilDate.getTime());
        }
        return null;
    }

    public static String formatDate(Date date,String pattern){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDate(java.sql.Date date,String pattern){
        Date utilDate = new Date(date.getTime());
        return formatDate(utilDate,pattern);
    }


    public static Date add(Date date,int field,int amount){
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field,amount);
        return calendar.getTime();
    }

    public static Date dateFormat(Date date , String format){
        if(date==null || format==null || format.length()==0){
            throw  new IllegalArgumentException(" Date and format  must be null");
        }
        String newDate=formatDate(date, format);
        return  parseSqlDate(newDate,format);
    }

    public static Date dateAddFormat(Date date ,int calendarType, int amount , String format){
        if(date==null || format==null || format.length()==0){
            throw  new IllegalArgumentException(" Date and format  must be null");
        }
        Date newDate=add(date,calendarType,amount);
        return  dateFormat(newDate,format);
    }




}
