package com.yun.test;

import com.alibaba.fastjson.JSONObject;
import com.yun.util.Imagebase64;
import com.yun.util.http.HttpUtil;

import java.util.Map;

/**
 * Created by tangjixiong on 2017/12/11.
 */
public class FileTest {

    public static void main(String[] args) {
        FileTest t= new FileTest();
        t.upload();
    }

    /**
     * 文件上传
     */
    public void upload() {
        String fileName = "/Users/tangjixiong/tmp/tu_small.png";
        String str = Imagebase64.getImageBinary(fileName,"png");
        System.out.println(str);
        String url  = TestUtils._BASE_URL+"/api/file/upload";
        JSONObject json = new JSONObject();
        json.put("file",str);
        json.put("type","png");
        Map<String,String> headerMap =TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);
    }


}
