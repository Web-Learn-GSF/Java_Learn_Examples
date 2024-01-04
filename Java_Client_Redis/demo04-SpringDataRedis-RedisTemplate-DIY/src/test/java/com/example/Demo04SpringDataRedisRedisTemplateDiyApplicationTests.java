package com.example;

import com.example.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Demo04SpringDataRedisRedisTemplateDiyApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testsaveString() {

        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "虎哥");
        // 获取string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testsaveUser() {
        User user = new User("你好", 18);
        redisTemplate.opsForValue().set("user:1", user);
        User object = (User) redisTemplate.opsForValue().get("user:1");
        System.out.println(object);
    }

}
