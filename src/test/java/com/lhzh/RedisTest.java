package com.lhzh;


import com.lhzh.sys.handler.entity.SysUser;
import org.apache.ibatis.lang.UsesJava7;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.BitSet;
import java.util.Date;


@SpringBootTest
public class RedisTest
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
    @Test
    public void Test_bitmap(){
        ValueOperations forValue = redisTemplate.opsForValue();
        String bitkey="play:2020-06-03";
        long uid =002;
        Boolean bit = forValue.getBit(bitkey, uid);
        assert bit;
//        System.out.println(bit);
    }



    public static void main(String[] args) throws URISyntaxException {
        String action="play";
        String date1 ="2020-06-03";
        String date2 ="2020-06-04";

        Jedis redis = new Jedis("127.0.0.1",6379);
        redis.auth("root");
//        System.out.println(redis.getbit("play:2020-06-03", 002L));
        int uniqueCount = uniqueCount(redis,action,date1,date2);
        System.out.println(uniqueCount);
        int keepCount = keepCount(redis, action, date1, date2);
        System.out.println(keepCount);

//        Long bitcount = redis.bitcount("play:2020-06-03");

//         redis.bitop(BitOP.OR, "play:2020-06", "play:2020-06-04", "play:2020-06-03");
//        Long bitcount = redis.bitcount("play:2020-06");
//        System.out.println(bitcount);
        redis.close();

    }
    //算出一天的活跃用户数量
    public static int  uniqueCount(Jedis redis,String action ,String date){
        String key =action +":"+date;
        BitSet users = BitSet.valueOf(redis.get(key.getBytes()));
        return users.cardinality();
    }
    //计算几天内用户活跃的数量
    public static int uniqueCount(Jedis redis,String action ,String... dates){
        BitSet all =new BitSet();
        for (String date:dates){
            String key =action +":"+date;
            BitSet users = BitSet.valueOf(redis.get(key.getBytes()));
            all.or(users);
        }
        return all.cardinality();
    }
    //计算几天内用户连续登陆的数量
    public static int keepCount(Jedis redis,String action ,String... dates){
        BitSet all =null;
        for (String date:dates){
            String key =action +":"+date;
            BitSet users = BitSet.valueOf(redis.get(key.getBytes()));
            if (all==null) {
                all=users;
            }else {
                all.and(users);
            }
        }
        return all.cardinality();
    }
}
