using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Web;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Converters;
using System.Text;

namespace HTTP_POST_YUNZ
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            JObject JsonPara = new JObject();
            JsonPara.Add(new JProperty("debtType",0));
            JsonPara.Add(new JProperty("customerType",1));
            JsonPara.Add(new JProperty("user", new JObject(
            
                new JProperty("userName","叶泽群"),
                new JProperty("address", "test"),
                new JProperty("mobile", "18157930676"),
                new JProperty("email", "yzq991328@icloud.com"),
                new JProperty("idcardNo", "33070219910328771X"),
                new JProperty("idcardImages", "20171211155743265559.png"),
                new JProperty("idcardImages2", "20171211155743265559.png"),
                new JProperty("bankCardNo", "test"),
                new JProperty("bankAddress", "test"),
                new JProperty("wechatNo", "test"),
                new JProperty("qq", "test"),
                new JProperty("emergencyMobile", "13777443718")                 
            )));
   
            String sb = JsonPara.ToString();
            DateTime now = new DateTime();
            String utime = now.ToString();
            String userCode = "2000019";
            String key = "3dcabc20106734f22a6bd8e11057bd50";
            String sign = MD5Util.getMD5(userCode + key + utime + JsonPara);
            String URL = "http://yqdc.yunfatong.com/api/customer/add";
            String result = Post(URL,userCode,utime,sign,sb);
            Console.WriteLine(result);

        }

        public static string Post(string URL,string userCode,string utime,string sign,
                          String str){
            String yunzURL = URL;
            //创建一个HTTP请求  
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(yunzURL);
            //设置请求，添加请求参数
            request.Headers.Add("userCode", userCode);
            request.Headers.Add("utime", utime);
            request.Headers.Add("sign", sign);
            request.Method = "POST";
            request.ContentType = "application/json;charset=UTF-8";
            request.Timeout = 30000;
            

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(str);
                streamWriter.Flush();
                streamWriter.Close();

            }

            var httpResponse = (HttpWebResponse)request.GetResponse();
            string result;
            using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
            {
                 result = streamReader.ReadToEnd();
            }
            return result;
        }

    }
}
