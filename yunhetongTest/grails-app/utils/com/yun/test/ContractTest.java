package com.yun.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yun.util.http.HttpUtil;

import java.util.Map;

/**
 * Created by tangjixiong on 2017/12/13.
 */
public class ContractTest {
    public static void main(String[] args) {
        ContractTest t=new ContractTest();
        t.create();
        //t.token();

    }

    /**
     * 创建合同
     */
    static void  create() {
        String url = TestUtils._BASE_URL+"/api/contract/create";
        JSONObject json = new JSONObject();

        json.put("title","借贷合同1");
        json.put("templateId","432540");
        json.put("contractPrice","2150");
        json.put("sginRegionName","杭州市");
        json.put("courtRegionName","杭州市");
        json.put("typeName","房贷");
        json.put("contractNo","N01242314");
        JSONArray signArray =new JSONArray();
        JSONObject signAJson = new JSONObject();
        signAJson.put("signatory","a");//合同签署用户 a为第一个用户 b为第二个用户 c为第三个用户
        signAJson.put("userid","21");//用户Id,由云证提供
        signArray.add(signAJson);
        JSONObject signBJson = new JSONObject();
        signBJson.put("signatory","b");
        signBJson.put("userid","22");
        signArray.add(signBJson);
        JSONObject signCJson = new JSONObject();
        signCJson.put("signatory","c");
        signCJson.put("userid","23");
        signArray.add(signCJson);
        json.put("signJson",signArray);

        JSONObject contractJson =new JSONObject();
        /**
         * 以下内容根据合同模板生成和赋值.模板调整后 本部分内容也需要调整
         */
        contractJson.put("${contract_no}","N01242314");//合同编号
        contractJson.put("${a_user_name}","测试用户A");//甲方姓名
        contractJson.put("${a_idcard_no}","4307162728898221293");//甲方证件号
        contractJson.put("${a_accounts}","n13788990011");//甲方帐号
        contractJson.put("${b_user_name}","测试用户B");//乙方姓名
        contractJson.put("${b_idcard_no}","430726198901215342");//乙方证件号
        contractJson.put("${b_address}","测试地址test");//乙方联系地址
        contractJson.put("${c_user_name}","鸾鸟科技");//丙方名称
        contractJson.put("${c_idcard_no}","91310115MA1H9CM064");//丙方社会信用代码
        contractJson.put("${contract_price}","2158");//本金金额人民币
        contractJson.put("${contract_price_upper}","貮仟壹百伍拾捌元");//大写人民币
        contractJson.put("${contract_use}","其它");//借款用途
        contractJson.put("${contract_rate}","10%");//年利率
        contractJson.put("${contract_start_time}","2017年12月12日");//借款起息日
        contractJson.put("${contract_end_time}","2018年6月12日");//借款到期日
        contractJson.put("${repayment_method}","每月8日");//还款方式
        contractJson.put("${a_address}","甲方测试地址test");//甲方送达地址
        contractJson.put("${a_mobile}","13777556718");//  甲方手机号码
        contractJson.put("${a_qq}","120560380");//甲方QQ号
        contractJson.put("${a_email}","120560380@qq.com");//甲方邮箱
        contractJson.put("${a_emergency_mobile}","13777556718");//甲方紧急联系电话
        contractJson.put("${ent_name}","鸾鸟科技");//丙方名称
        contractJson.put("${repayment_count}","12期");//期数
        contractJson.put("${repayment_date}","每月8日");//还款日
        contractJson.put("${contract_repayment_price}","400");//还款金额
        contractJson.put("${contract_price}","2158");//本金
        contractJson.put("${contract_server_price}","400");//综合服务费
        contractJson.put("${create_time}","2017年12月25日");//创建日期
        json.put("contractJson",contractJson);

        System.out.println(json.toJSONString());
        Map<String,String> headerMap = TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);

    }

    static void token() {
        String url = TestUtils._BASE_URL+"/api/contract/token";
        JSONObject json = new JSONObject();
        //json.put("userId","21");
        //json.put("contractId","1712251705256721");
        json.put("userId","22");
        json.put("contractId","1712251705256721");
        //json.put("userId","23");
        //json.put("contractId","17001928172");
        System.out.println(json.toJSONString());
        Map<String,String> headerMap = TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);

    }


}
