package com.yun.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.yun.demo.util.http.HttpUtil;

import java.util.Map;

/**
 * 用户测试
 * Created by tangjixiong on 2017/12/25.
 */
public class CustomerTest {

    public static void main(String[] args) {
        CustomerTest t = new CustomerTest();
//        t.addUser();
        t.addEnt();
    }

    void addUser() {
        String url  = TestUtils._BASE_URL+"/api/customer/add";
        JSONObject json = new JSONObject();
        json.put("debtType",0);//主体类型 0债权人 1债务人
        json.put("customerType",1);//客户类型 0企业 1个人
        JSONObject userJson = new JSONObject();
        userJson.put("userName","董子源");
        userJson.put("address","test");
        userJson.put("mobile","13988991222");
        userJson.put("email","13788990011@139.com");
        userJson.put("idcardNo","211223199009153019");
        userJson.put("idcardImages","20171211155743265559.png");
        userJson.put("idcardImages2","20171211155743265559.png");
        userJson.put("bankCardNo","test");
        userJson.put("bankAddress","test");
        userJson.put("wechatNo","test");
        userJson.put("qq","test");
        userJson.put("emergencyMobile","13777443718");
        json.put("user",userJson);
        Map<String,String> headerMap =TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);
    }

    void addEnt() {
        String url  = TestUtils._BASE_URL+"/api/customer/add";
        JSONObject json = new JSONObject();
        json.put("debtType",0);//主体类型 0债权人 1债务人
        json.put("customerType",0);//客户类型 0企业 个人
        JSONObject entJson = new JSONObject();
        entJson.put("customerName","test杭州云证网络科技有限公司11");
        entJson.put("creditCode","w321432sf211113");
        entJson.put("address","滨江区");
        entJson.put("phone","13787880128");
        entJson.put("email","yz@yunfatong.com");
        entJson.put("licenseImages","20171211155743265559.png");
        entJson.put("userName","孙威");
        entJson.put("idcardNo","4324243111242");
        entJson.put("idcardImages","20171211155743265559.png");
        entJson.put("idcardImages2","20171211155743265559.png");
        entJson.put("bankCardNo","0637364134214214");
        entJson.put("bankAddress","杭州滨江");
        json.put("ent",entJson);
        Map<String,String> headerMap =TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);
    }
}

