package cn.hehe.examples.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author hyp
 * @title: RedisConfig
 * @projectName hyp-examples
 * @description: redis配置类
 * @date 2022/4/21 14:58
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.147.131:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return  redissonClient;
    }

    @Bean
    public Jedis jedis(){
        return new Jedis("192.168.147.131", 6379);
    }

}
