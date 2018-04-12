package com.yun.demo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yun.demo.util.http.*;

import java.util.Map;

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

        json.put("title","勤亿租赁合同");
        json.put("templateId","TEM1000917");
        json.put("contractPrice","100000");
        json.put("sginRegionName","杭州市");
        json.put("courtRegionName","杭州市");
        json.put("typeName","融资租赁");
        json.put("contractNo","N020180321");
		json.put("linkUrl","http://www.baidu.com"); //你方着陆页的地址
        JSONArray signArray =new JSONArray();
        JSONObject signAJson = new JSONObject();
        signAJson.put("signatory","a");//合同签署用户 a为承租方   b为出租方
        signAJson.put("userid","2000023");//用户Id,由云证提供
        signArray.add(signAJson);
        JSONObject signBJson = new JSONObject();
        signBJson.put("signatory","b");
        signBJson.put("userid","2000019");
        signArray.add(signBJson);
        json.put("signJson",signArray);

        JSONObject contractJson =new JSONObject();
        /**
         * 以下内容根据合同模板生成和赋值.模板调整后 本部分内容也需要调整
         */
        //文本内容
        contractJson.put("${contract_no}","N020180321");//合同编号
        contractJson.put("${a_user_name}","勤亿测试用户A");//承租方姓名
        contractJson.put("${a_idcard_no}","4307162728898221293");//承租方身份证号
        contractJson.put("${a_address}","承租方测试地址test"); //承租方通讯住址
        contractJson.put("${a_idcard_address}","上海浦东");//承租方户籍地
        contractJson.put("${a_postcode}","421000"); //承租方邮编
        contractJson.put("${a_mobile}","18778267653"); //承租方电话
        contractJson.put("${a_email}","373823782@qq.com");//承租方邮箱
        contractJson.put("${a_qq}","782178127"); //承租人微信号或qq号
        contractJson.put("${a_emergency_mobile}","198778625367"); //承租人近亲电话

        contractJson.put("${b_user_name}","勤亿有限公司");//出租人姓名
        contractJson.put("${b_username}","陈文方"); //法定代表人
        contractJson.put("${b_house_address}","上海崇文"); //法定代表人住所地
        contractJson.put("${b_address}","上海环球金融中心");//通讯地址
        contractJson.put("${b_postcode}","3213131"); //出租人邮编
        contractJson.put("${b_link_name}","张三"); //联系人
        contractJson.put("${b_mobile}","19877627786"); //联系人电话
        contractJson.put("${b_fax}","8776552"); //联系人传真
        contractJson.put("${b_email}","3123123@126.com"); //联系人邮箱
        contractJson.put("${payee_bank}","上海工商银行"); //出租人开户行
        contractJson.put("${b_accounts}","78712631983913312"); //出租人银行账号

        contractJson.put("${overdue_rate}","0.5%"); //逾期利率 (固定值0.5%)
        contractJson.put("${repayment_count}","12"); //租赁期(多少个月)
        contractJson.put("${ensure_price}","5000"); //保证金
        contractJson.put("${service_price}","2000"); //手续费
        contractJson.put("${every_count_price}","10000"); //每期租金
        contractJson.put("${price_count}","12"); //租金期数
        contractJson.put("${how_mouth}","1"); //租金支付频率
        contractJson.put("${pay_method}","前付"); //租金支付方式
        //contractJson.put("${end_price}","20000"); //期末留购价格
        contractJson.put("${contract_price}","50000"); // 货款本金
        contractJson.put("${contract_price_upper}","伍万元"); //本金大写
        contractJson.put("${in_mouth}","6"); //合同生效多少个月内
        //contractJson.put("${repayment_time}","2018年1月1日"); //开始付租金时间
        contractJson.put("${count_1}","50000"); //租赁物清单总计价格
        contractJson.put("${count_2}","60000"); //应付租金表总计价格
        contractJson.put("${create_time}","2018年3月21日"); //合同创建时间

        //表格内容
        JSONArray tablesArray = new JSONArray();

        JSONObject table_1 = new JSONObject(); //表1
        table_1.put("index",2);
        JSONArray tableArray_1 = new JSONArray();//表1内容,表格中如有多行数据,依次类推
        JSONObject tableJson_1_1 = new JSONObject();//第一行内容
        tableJson_1_1.put("1",1);  //序号
        tableJson_1_1.put("2","汽车");//租赁物名称
        tableJson_1_1.put("3","YY-287IH"); //型号
        tableJson_1_1.put("4","1234666"); //机身号码
        tableJson_1_1.put("5","大华广场"); //租赁物设置场所
        tableJson_1_1.put("6",3); //数量
        tableJson_1_1.put("7","100000"); //单价
        tableArray_1.add(tableJson_1_1);

        JSONObject tableJson_1_2 = new JSONObject(); //第二行内容
        tableJson_1_2.put("1",2);  //序号
        tableJson_1_2.put("2","车床");//租赁物名称
        tableJson_1_2.put("3","QQ-987IJ"); //型号
        tableJson_1_2.put("4","987662"); //机身号码
        tableJson_1_2.put("5","上海厂房"); //租赁物设置场所
        tableJson_1_2.put("6",5); //数量
        tableJson_1_2.put("7","50000"); //单价
        tableArray_1.add(tableJson_1_2);
        table_1.put("table",tableArray_1);
        tablesArray.add(table_1);

        JSONObject table_2 = new JSONObject(); //表2
        table_2.put("index",3);
        JSONArray tableArray_2 = new JSONArray();
        JSONObject tableJson_2_1 = new JSONObject();//第一行内容
        tableJson_2_1.put("1",1);
        tableJson_2_1.put("2","2018年1月1日");//租金到期日
        tableJson_2_1.put("3","30000"); //应付租金
        tableArray_2.add(tableJson_2_1);

        JSONObject tableJson_2_2 = new JSONObject(); //第二行内容
        tableJson_2_2.put("1",2);
        tableJson_2_2.put("2","2018年2月1日");
        tableJson_2_2.put("3","30000");
        tableArray_2.add(tableJson_2_2);
        table_2.put("table",tableArray_2);
        tablesArray.add(table_2);


        JSONObject table_3 = new JSONObject(); //表3
        table_3.put("index",4);
        JSONArray tableArray_3 = new JSONArray();
        JSONObject tableJson_3_1 = new JSONObject();//第一行内容
        tableJson_3_1.put("1",1);  //序号
        tableJson_3_1.put("2","汽车");//租赁物名称
        tableJson_3_1.put("3","YY-287IH"); //型号
        tableJson_3_1.put("4","1234666"); //机身号码
        tableJson_3_1.put("5","大华广场"); //租赁物设置场所
        tableJson_3_1.put("6",3); //数量
        tableJson_3_1.put("7","100000"); //单价
        tableArray_3.add(tableJson_3_1);

        JSONObject tableJson_3_2 = new JSONObject();//第二行内容
        tableJson_3_2.put("1",2);  //序号
        tableJson_3_2.put("2","车床");//租赁物名称
        tableJson_3_2.put("3","QQ-987IJ"); //型号
        tableJson_3_2.put("4","987662"); //机身号码
        tableJson_3_2.put("5","上海厂房"); //租赁物设置场所
        tableJson_3_2.put("6",5); //数量
        tableJson_3_2.put("7","50000"); //单价
        tableArray_3.add(tableJson_3_2);
        table_3.put("table",tableArray_3);
        tablesArray.add(table_3);

        

        contractJson.put("tables",tablesArray);
        json.put("contractJson",contractJson);

        System.out.println(json.toJSONString());
        Map<String,String> headerMap = TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);

    }

    static void token() {
        String url = TestUtils._BASE_URL+"/api/contract/token";
        JSONObject json = new JSONObject();
        //json.put("userId","2000024");
        //json.put("contractId","1712271615519551");
        //json.put("userId","2000021");
        //json.put("contractId","1712271615519551");
        json.put("userId","2000019");
        json.put("contractId","1712271615519551");
        System.out.println(json.toJSONString());
        Map<String,String> headerMap = TestUtils.getHeaderMap(json.toJSONString());
        HttpUtil.sendPost(url,json.toJSONString(),headerMap);

    }

}
