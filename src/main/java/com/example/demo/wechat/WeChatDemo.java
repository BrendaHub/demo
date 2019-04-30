package com.example.demo.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Sam
 * @date 2019/3/20 16:48
 */
public class WeChatDemo {
    public static String postToken() throws Exception {
        //小程序id
        String APIKEY = "wx2511b504c75d1a61";
        //小程序密钥
        String SECRETKEY = "9671072d385e8d73efbc307b025797f6";
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APIKEY+"&secret="+SECRETKEY;
        URL url = new URL(requestUrl);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes("");
        out.flush();
        out.close();

        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if (requestUrl.contains("nlp")){
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        } else{
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        }

        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println(jsonObject);
        String accesstoken=jsonObject.getString("access_token");
        System.out.println(accesstoken);
        return accesstoken;
    }


    /**
     * 生成带参小程序二维码
     * @param sceneStr	参数
     * @param accessToken	token
     */
    public static void getminiqrQr(String sceneStr, String accessToken) {
        try
        {
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessToken);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 提交模式
            httpURLConnection.setRequestMethod("POST");
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();

            paramJson.put("scene", sceneStr);
            //必须是已经发布的小程序才可用，否则会出问题
            paramJson.put("page", "pages/index/index");
            paramJson.put("width", 430);
            paramJson.put("auto_color", true);
            System.out.println(paramJson.toString());
            /**
             * line_color生效
             * paramJson.put("auto_color", false);
             * JSONObject lineColor = new JSONObject();
             * lineColor.put("r", 0);
             * lineColor.put("g", 0);
             * lineColor.put("b", 0);
             * paramJson.put("line_color", lineColor);
             * */

            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            System.out.println(httpURLConnection.getInputStream());
            OutputStream os = new FileOutputStream(new File("C:/Users/Sam/Desktop/2.png"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1)
            {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
