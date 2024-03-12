package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模板类...");
        // 创建RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(redisConnectionFactory);

        // TODO 使用注释相关部分的设置，在使用微信小程序，点击分类展示菜品信息的时候，redis会报错【菜品集合数据写入缓存失败，应该是value序列化器的问题，后续弄明白】
        //// 创建JSON序列化工具
        //GenericJackson2JsonRedisSerializer jsonRedisSerializer =
        //        new GenericJackson2JsonRedisSerializer();
        //// 设置Key的序列化
        //template.setKeySerializer(RedisSerializer.string());
        //template.setHashKeySerializer(RedisSerializer.string());
        //// 设置Value的序列化
        //template.setValueSerializer(jsonRedisSerializer);
        //template.setHashValueSerializer(jsonRedisSerializer);

        template.setKeySerializer(new StringRedisSerializer());

        // 返回
        return template;
    }
}
