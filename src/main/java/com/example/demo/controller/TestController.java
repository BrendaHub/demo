package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.StuDao;
import com.example.demo.entity.Student;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.net.Proxy.Type.HTTP;


/**
 * @author Sam
 * @date 2019/3/11 15:26
 */
@RestController
public class TestController {

    @Autowired
    private StuDao stuDao;

//    @GetMapping(value = "test")
//    public String test(){
//        String test = JsonUtil.EntityToString("test");
//        System.out.println(test);
//        return test;
//    }

    @GetMapping(value = "getStu")
    public Student getStuList(){
        Student stuDaoAllById = stuDao.findAllById(1);
        System.out.println(stuDaoAllById);
        return stuDaoAllById;
    }


//    @RequestMapping("/getCode")
//    public ResponseMsg getCodeM(HttpServletRequest request) throws Exception {
//
//        String imei ="867186032552993";
//        String page="page/msg_waist/msg_waist";
//        String token = getToken();   // 得到token
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("scene", imei);  //参数
//        params.put("page", "page/msg_waist/msg_waist"); //位置
//        params.put("width", 430);
//
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//        HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token);  // 接口
//        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
//        String body = JSON.toJSONString(params);           //必须是json模式的 post
//        StringEntity entity;
//        entity = new StringEntity(body);
//        entity.setContentType("image/png");
//
//        httpPost.setEntity(entity);
//        HttpResponse response;
//
//        response = httpClient.execute(httpPost);
//        InputStream inputStream = response.getEntity().getContent();
//        String name = imei+".png";
//        saveToImgByInputStream(inputStream,"D:\\",name);  //保存图片
//        return null;
//    }


//    public String getToken() {
//        try {
//
//            Map<String, String> map = new LinkedHashMap<String, String>();
//            map.put("grant_type", grant_type);
//            map.put("appid", appid);
//            map.put("secret", secret);
//
//            String rt = HttpUtils.sendGet(TOKEN_URL, map);
//
//            System.out.println(rt);
//            JSONObject json = JSONObject.parseObject(rt);
//
//            if (json.getString("access_token") != null || json.getString("access_token") != "") {
//                return json.getString("access_token");
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            log.error("# 获取 token 出错... e:" + e);
//            e.printStackTrace();
//            return null;
//        }
//
//    }


//    public static int saveToImgByInputStream(InputStream instreams, String imgPath, String imgName){
//        int stateInt = 1;
//        if(instreams != null){
//            try {
//                File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等
//                FileOutputStream fos=new FileOutputStream(file);
//                byte[] b = new byte[1024];
//                int nRead = 0;
//                while ((nRead = instreams.read(b)) != -1) {
//                    fos.write(b, 0, nRead);
//                }
//                fos.flush();
//                fos.close();
//            } catch (Exception e) {
//                stateInt = 0;
//                e.printStackTrace();
//            } finally {
//            }
//        }
//        return stateInt;
//    }


}
