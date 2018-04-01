using System;
using System.Security.Cryptography;
using System.Text;

namespace HTTP_POST_YUNZ
{
    public class MD5Util
    {
        public MD5Util()
        {
        }

/// <summary>
        /// MD5 16进制算法
        /// </summary>
        /// <param name="str"></param>
        /// <returns></returns>
        public static string getMD5(string str)
        {
            //创建MD5对像
            MD5 md5 = MD5.Create();
            //将字符串转换成数组
            byte[] ba = Encoding.Default.GetBytes(str);
            //将数组加密 成  加密数组
            byte[] md55 = md5.ComputeHash(ba);
            //将加密数组编译成字符串
            // return Encoding.Default.GetString(md55);
            //
            string STR = "";
            //便利数组中元素转化成字符并拼接
            for (int I = 0; I < md55.Length; I++)
            {
                //X 表是10进制,X2表示16进制

                STR += md55[I].ToString("x2");

            }
            return STR;
        }
    }
}
