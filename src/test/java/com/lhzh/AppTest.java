package com.lhzh;


import com.lhzh.sys.handler.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest 
{
 @Resource
 private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void Test_sentinel()
        {

//            ValueOperations forValue = redisTemplate.opsForValue();
//            SysUser user =new SysUser("李四","123411","111");
//            forValue.set("user",user);
//            SysUser user1 = (SysUser) forValue.get("user");
//            System.out.println(user1);
//            System.out.println(forValue.get("abc"));
//            forValue.set("num",123);
//            forValue.set("hug",true);
//            forValue.set("me","hello");

        }
}
