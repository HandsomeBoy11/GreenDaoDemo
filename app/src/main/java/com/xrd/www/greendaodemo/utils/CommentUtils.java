package com.xrd.www.greendaodemo.utils;

import java.util.regex.Pattern;

/**
 * Created by user on 2018/8/14.
 */

public class CommentUtils {
    private static CommentUtils instance;
    private CommentUtils (){

    }
    public static CommentUtils getInstance(){
        if(instance==null){
            synchronized (CommentUtils.class){
                if(instance==null){
                    instance=new CommentUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 判断字符串是否为数字类型的
     * @param str
     * @return
     */
    public  boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
