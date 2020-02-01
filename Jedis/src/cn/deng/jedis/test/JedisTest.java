package cn.deng.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
   @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("name","dengywuen");
        jedis.close();
    }

    @Test
    public void test2(){//String类型
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","zhangsan");
        String name = jedis.get("username");
        System.out.println(name);
        jedis.setex("activecode",20,"789456");//20秒自动删除键值对
        jedis.close();
    }

    @Test
    public void test3() {//hash类型
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.hset("user","name","lisi");
        jedis.hset("user","sex","man");
        jedis.hset("user","age","23");
        //System.out.println(jedis.hget("user","name"));
        Map<String,String> user = jedis.hgetAll("user");
        for (String key:user.keySet()
        ) {
            System.out.println(key+" "+user.get(key));

        }
        jedis.close();
    }

    @Test
    public void test4() {//list类型
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");
        List<String> list = jedis.lrange("mylist",0,-1);
        System.out.println(list);
        String ele = jedis.lpop("mylist");
        String ele2 = jedis.rpop("mylist");

        jedis.close();
    }


    @Test
    public void test5() {//Set类型
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.sadd("myset","java","c++","c#");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }

    @Test
    public void test6() {//sortedset类型
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.zadd("mysortedset",4,"r");
        jedis.zadd("mysortedset",20,"t");
        jedis.zadd("mysortedset",10,"y");
        Set<String> set = jedis.zrange("mysortedset",0,-1);
        System.out.println(set);
        jedis.close();
    }

    @Test
    public void test7() {//jedis连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("fenshi","32");
        jedis.close();

    }

    @Test
    public void test8() {//JedisPoolUtils工具类创建连接jedis
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("fenshi","33");
        jedis.close();
    }
}
