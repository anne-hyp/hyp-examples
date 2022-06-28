package cn.hehe.examples.redis.controller;

import cn.hutool.core.util.StrUtil;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author hyp
 * @title: GoodsController
 * @projectName hyp-examples
 * @description: 分布式锁示例
 * @date 2022/4/21 11:56
 */
@RestController
public class GoodsController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * setnx版本分布式锁
     * @return
     */
    @GetMapping("reduce1")
    public String reduceInventory1(){

        String clientId = UUID.randomUUID().toString();
        try{
            if (stringRedisTemplate.opsForValue().setIfAbsent("reduce1", clientId, 10, TimeUnit.SECONDS)) {
                String goodsInventory = stringRedisTemplate.opsForValue().get("num");
                Integer num = Integer.valueOf(goodsInventory);
                if (num > 0) {
                    num -= 1;
                }
                stringRedisTemplate.opsForValue().set("num", num.toString());
                System.out.println(num);
            }
        } finally {
            if (StrUtil.equals(clientId, stringRedisTemplate.opsForValue().get("reduce1"))) {
                stringRedisTemplate.opsForValue().getAndDelete("reduce1");
            }
        }
        return "ok";
    }

    /**
     * redission版本分布式锁
     * @return
     */
    @GetMapping("reduce2")
    public String reduceInventory2(){
        RLock reduce = redissonClient.getLock("reduce");
        reduce.lock(10, TimeUnit.SECONDS);
        String goodsInventory = stringRedisTemplate.opsForValue().get("num");
        Integer num = Integer.valueOf(goodsInventory);
        if (num > 0) {
            num -= 1;
        }
        stringRedisTemplate.opsForValue().set("num", num.toString());
        System.out.println(num);
        reduce.unlock();
        return "ok";
    }

    @GetMapping("initNum")
    public String initNum(){
        stringRedisTemplate.opsForValue().set("num", "4000");
        return "ok";
    }

}
