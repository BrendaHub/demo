package com.example.demo;

import com.example.demo.wechat.WeChatDemo;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author Sam
 * @date 2019/3/20 17:27
 */
public class WeChatTest {

    @Test
    public void test1() throws Exception {
        String token = WeChatDemo.postToken();
//        System.out.println(token);
        WeChatDemo.getminiqrQr("yytbm=0000", token);
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis("120.78.192.71", 6379);
        String name = jedis.get("name");
        System.out.println(name);
    }
}
