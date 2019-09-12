package com.yc.story.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016100900646973";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbI0PHpLcJQi8OWjT2rkyNaYA/BluUKfogGwP4iTV2DhsmH0dEWg1G8Nxkm9JA9QnRjIZlr2Mw97N6wKkvvWIBRGEHEsW7yXcOUT9bTuohoJarSA07VTKpPd2nswvESUd2PlVei2mX2qadvtmQRHyrECtEZAvtpU4DoWhix8VD4XAd4oO/HqUMPoi4lsQ37yHcpn7vbD9gvDv59ksWy6fbsiliiJzqCEeYMDpcD+uIAj1TXR5usWeRdmZ7aInZ8+mkEoCXFDwOmfJvpI365vQaLydfd+MyUzN+f9bJSbwYwig5NonIe0evsg4PgytCHOH2A++Tpc+4d5eiSdBniOPlAgMBAAECggEAbeMDvqUAdVFo7VyeCWEankvtaDcDpSY6ooUgQepGcPG67zzWiSbUIry3D5iDzDkFFGXaSKp7sxKxEbDn5gXaJpWduJnmb4Zbi0unefCizODn+DjYDn/hm5lTqNac7hMNyEaMx6QuTj61KCUoDBVGzRBt5UqMXG9rnAy3WMiyBMrMUXxa+RiTeEERR9t9i2RtTEm0Qhjkh4Ipfd5+1rGp4xxjbOfLUNrcf6ldrnUz+vprquXOn+fDLJsNCqaO5oUb2xiLevjLCT6mQCmVsO6/4Hmlo+glbrlYFwYH/XhAr7eUPPw7dHcXyQ3lsL1zijMPzxJ8K7iWV7m8P1tFPIcgYQKBgQDkxGICFbzHd9GI1p1znXzKW/f/uUPYBy9FLeij8GHulyn8rs7trexJFZlG7G+PD9fx8/GmeZvHxidZ5PWrU0tLFMfluL4rNtoOIj9OnBRxob1OzraHVF9LZKs7pS/Lax9J75zIaUc+AiQ1N9A828Fpm6LFhAXTmjtyuAxbqpygPQKBgQCtmwvpRSu6zJn9zG3VbTWX1AalqVUbuVDer7rLpUV7rLyu3W6gqrIQo8RhJyK+cYBN6cx27X0QV7Ox+f9hxWC4uHZZqjFZPBCFKbi1YKlrmuiy+VDpTIN76++lDcPoxTGYfssSQLhigjcoGj002Ny2sk4WY4h7CzP/wvu2IgikyQKBgDF9kr5kuXxlnXz/AP0cGv0kPFikWdsIYt+SePvOa0FUjo7NupKMx8tf0tMXH2NRyCPd5G9ha6QiaCz4bXVtBaLukfhOqUVsDmx0WEHHXlze4reD3NUWGa+Tzb+PkvFs8U3ren2Y2QK/L9obgv9Hg2Y3d1VHpIMMoMPGsVW7aTr5AoGAAt5sDPfKqDSXWt1U91DtsMudLIGm2WVvk659vL3HbyrEl3MrT9ZiSOob5asa5ODFSQRTD6gPCAUbABbshHYZihPqSMMKO7pFX5334m9tfUy7CbIbBy/vgE2+0RBwK1mO30FBI9UT9vTF6pC8cDIhO5eouK/+YmImAtT7CeB4GhkCgYEAky01+0xNt841pMagOWo/Acp4p0pNxx4D/IxQtlch6cLH7bK4+99NOSaCkRfbzIheSYdhzMENp3xnT7OJk6jKh7lBcBORLlcq/UeLZKbr/8RCyiaZKUrq1xIctBsSWT1bjyqrm3ogGwGeoO9tAqaBkxl3X11ZgWCkiueAO1fij48=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA459+Y9tPjFAL5Z30loW0VS49tO/bLz7uVbMVHHAMz9IzbsxTgSKJqvsoU6dglesNf2ciPlP2Yu6haK2xRx2jpkVa0NW7mFRJ0olHWpQ9/qX1VjVx4KsGgBcd6lM9NHq4NYDSTb3GgMk9GjfLH+aso+1gaBFebY8gpKoCmsksG8OZiDd1C6qqmWYq9YFuRw4vTx7ELn25spPtVksvz7qJ3B9UtmEL/AmVfr3bAYnz5vEC08AYYnqu+32P4fAiWtfGj6NWfoq9KzZs6X6O0mUo91i3RSsdK5ILuWxF2k1EX7b22Tjvfx8FIgsgxl5HbZScDKwlMQP8h6IOpbhW7JAeEwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1/alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1/pay";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


