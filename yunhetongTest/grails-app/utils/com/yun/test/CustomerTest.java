package com.yun.test;

import com.alibaba.fastjson.JSONObject;
import com.yun.util.http.HttpUtil;

import java.util.Map;

/**
 * 用户测试
 * Created by tangjixiong on 2017/12/12.
 */
public class CustomerTest {

    public static void main(String[] args) {
        CustomerTest t = new CustomerTest();
        t.addUser();
        //t.addEnt();
        //t.addUser1();
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
        /*userJson.put("userName","李志鹏");
        userJson.put("address","test");
        userJson.put("mobile","13988991222");
        userJson.put("email","13788990011@139.com");
        userJson.put("idcardNo","420683199509090938");
        userJson.put("idcardImages","20180209190947852554.png");
        userJson.put("idcardImages2","20180209190948805298.png");
        userJson.put("bankCardNo","test");
        userJson.put("bankAddress","test");
        userJson.put("wechatNo","test");
        userJson.put("qq","test");
        userJson.put("emergencyMobile","13777443718");*/
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
        entJson.put("creditCode","91310110MA1G847J81");
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


    void addUser1() {
        String url  = TestUtils._BASE_URL+"/api/customer/add";
        JSONObject json = new JSONObject();
        json.put("debtType",1);//主体类型 0债权人 1债务人
        json.put("customerType",1);//客户类型 0企业 1个人
        JSONObject userJson = new JSONObject();
        userJson.put("userName","债务人测试用");
        userJson.put("address","地址测试用");
        userJson.put("mobile","13900000003");
        userJson.put("email","test@qq.com");
        userJson.put("idcardNo","123675898726567387");
        userJson.put("idcardImages","20171211155743265559.png");
        userJson.put("idcardImages2","20171211155743265559.png");
        userJson.put("bankCardNo","testBankCardNo");
        userJson.put("bankAddress","testBankAddress");
        userJson.put("wechatNo","testWeChatNo");
        userJson.put("qq","testQq");
        userJson.put("emergencyMobile","13900000000");
        json.put("user",userJson);
        Map<String,String> headerMap =TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);
    }
}

