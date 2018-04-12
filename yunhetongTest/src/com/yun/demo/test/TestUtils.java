package com.yun.demo.test;

import com.yun.demo.util.MD5Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjixiong on 2017/12/12.
 */
public class TestUtils {

    public static final String _BASE_URL= "http://yqdc.yunfatong.com/";



    public static Map<String,String> getHeaderMap(String json) {
        String utime =String.valueOf(new Date().getTime());
        String userCode = "2000019";
        String sign = getSign(userCode,utime,json);
        System.out.println("sign:"+sign);
        Map<String,String> map = new HashMap<>();
        map.put("utime",utime);
        map.put("userCode",userCode);
        map.put("sign",sign);

        return map;

    }

    static String getSign(String userCode,String utime,String json) {
        final String _key = "3dcabc20106734f22a6bd8e11057bd50";
        return MD5Util.MD5(userCode+_key+utime+json);

    }
}
