package com.yun.util.http;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by tangjixiong on 2017/6/6.
 */
public class HttpUtil {
    public static String sendPost(String url, String inputStr, Map<String, String> headerMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;

        HttpPost httpPost = new HttpPost(url);

        //将要提交给API的数据对象转换成XML格式数据Post给API

        System.out.println("API，POST过去的数据是：");
        System.out.println(inputStr);

        //得指明使用UTF-8编码，
        StringEntity postEntity = new StringEntity(inputStr, "UTF-8");
        postEntity.setContentType("application/json");
        postEntity.setContentEncoding("UTF-8");
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");

        if (headerMap!=null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }


        try {
            httpPost.setEntity(postEntity);
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

            System.out.println(response.getStatusLine());
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("http get throw Exception");

        } finally {
            httpPost.abort();
        }

        return result;
    }

    /**
     * 上传文件请求
     * @param url
     * @param filePath
     * @param headerMap
     * @return
     */

    public static String sendPostFile(String url, String  filePath, Map<String, String> headerMap) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;
        HttpPost httpPost = new HttpPost(url);

        System.out.println("filePath:"+filePath);
        File file = new File(filePath);
        FileBody bin = new FileBody(file);

        StringBody body  = new StringBody(filePath, Charset.forName("UTF-8"));
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("password",body )
                .build();
        if (headerMap!=null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }


        try {
            httpPost.setEntity(reqEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(response.getStatusLine());
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("http get throw Exception");

        } finally {
            httpPost.abort();
        }

        return result;
    }

    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    public static String  sendGet(String url, Map<String, String> headerMap) {
        System.out.println("url:"+url);

        BufferedReader bufferedReader = null;

        String content = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpGet httpGet = new HttpGet();
            if (headerMap != null) {

                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpGet.setURI(new URI(url));
            HttpResponse response = client.execute(httpGet);

            bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity()
                    .getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + NL);
            }
            bufferedReader.close();
            content = sb.toString();
            //println(content)
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }

    public static void main(String[] args) {
//        long startTime = new Date().getTime()
//
//        def _KEY = "fsafsafsdasa";
//        def utime = new Date().getTime();
////        def sign = ("loginName=$_KEY&passwd=$utime").encodeAsMD5();
////        println "sign:$sign";
////        String result = new HttpUtil().sendGet("http://www.baidu.com/s?wd=医院", null)
//
//        Map<String,String> headerMap =new HashMap<>();
//        headerMap.put("userId", "1234");
        //headerMap.put("sign","fdsafsafsa".encodeAsMD5())
        String json = "{\"userId\":\"1\"}";
//        String sha256json = json.encodeAsSHA256()
//        String sign = encodeRsa(sha256json);
//        headerMap.put("sign", sign)
//        String result = new HttpUtil().sendPost("http://127.0.0.1:8080/api/user/test", json, headerMap)
    }


}
