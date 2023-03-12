package com.wqm.ims.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunction {
    /**
     * 校验手机号格式
     */
    public static boolean phoneVerification(String phone){
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 校验日期格式 2000-01-01
     */
    public static boolean dateVerification(String date){
        try{
            //先判断日期是否符合reg表达式
            String regExp ="20[0-9]{2}-[0-9]{2}-[0-9]{2}";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(date);
            if(!m.matches()){
                return false;
            }
            //将日期分割
            String monthString=date.substring(5,7);
            String dayString=date.substring(8,10);
            //校验月是否正确
            int month=Integer.valueOf(monthString);
            if(month<=0||month>12){
                return false;
            }
            //根据月校验日
            int day=Integer.valueOf(dayString);
            if(day<=0){
                return false;
            }
            if(month==2) {
                String yearString=date.substring(0,4);
                int year=Integer.valueOf(yearString);
                if(year%4==0){
                    //闰年29天
                    if(day>29){
                        return false;
                    }
                }else{
                    //平年28天
                    if(day>28){
                        return false;
                    }
                }
            }else if(month==4||month==6||month==9||month==11){
                if(day>30){
                    return false;
                }
            }else{
                if(day>31){
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /**
     * 校验日期格式，并校验日期顺序
     */
    public static boolean dateOrderVerification(String dateA,String dateB){
        if(!(dateVerification(dateA)&&dateVerification(dateB))){
            return false;
        }
        //校验两个日期先后顺序
        return compareDate(dateA,dateB);
    }
    /**
     * 日期A是否早于日期B
     */
    public static boolean compareDate(String dateA,String dateB){
        return dateA.compareTo(dateB)<0;
    }
    /**
     * 某个日期是否在两个日期之间
     */
    public static  boolean betweenDate(String startDate,String endDate, String targetDate){
        return compareDate(startDate,targetDate)&&compareDate(targetDate,endDate);
    }
}
