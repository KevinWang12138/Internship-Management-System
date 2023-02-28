package com.wqm.ims.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunction {
    public static boolean phoneVerification(String phone){
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
