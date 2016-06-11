package com.bizi.config.center.utils;

import java.util.Collection;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
public final class ValidateUtil {
    public static boolean isBlank(String s){
        return s==null||s.trim().equals("");
    }
    public static boolean hasOneBlank(String ... list){
        if(isNull(list)){
            return true;
        }
        for(Object obj : list){
            if(isNull(obj)){
                return false;
            }
        }
        return true;
    }
    public static boolean isNull(Object obj){
        return obj == null;
    }
}
