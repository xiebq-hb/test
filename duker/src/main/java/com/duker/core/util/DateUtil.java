package com.duker.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 * @author xiebq
 * @create 2019/4/22 0022
 * @since 1.0.0
 */
public class DateUtil {

    /**
     * 判断字符串是不是日期
     * @return
     */
    public static boolean isValidDate(String str){
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，
            // 比如2007-02-29会被接受，并转换成2007-03-01
            format.setLenient(false);
            format.parse(str);
        }catch (Exception e){
            //e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return  convertSuccess;
    }

    /**
     * 日期转成日期字符串
     * @param date  日期
     * @param format   日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String Date2Str(Date date,String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        return  df.format(date);
    }

    /**
     * 字符串转成日期
     * @param dateString  日期字符串
     * @param format   日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date str2Date(String dateString,String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  d;
    }
    /**
     * 两个日期字符串类型比较
     * 要求长度和格式一样。
     * @param target
     * @param source
     * @return
     */
    public static boolean compareTo(String target,String source){
        boolean flag = true;
        if (source.compareTo(target) == -1){
            return false;
        }
        return flag;
    }


    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static String getChinese(String url){
        String regex = "([\u4e00-\u9fa5]+)";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group(1);
        }
        return result;
    }
}
