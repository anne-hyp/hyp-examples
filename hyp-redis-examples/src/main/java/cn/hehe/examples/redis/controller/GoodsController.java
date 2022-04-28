package cn.hehe.examples.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author hyp
 * @title: GoodsController
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/4/21 11:56
 */
@RestController
public class GoodsController {

    @Autowired
    private Jedis jedis;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("reduce")
    public String reduceInventory(){
        RLock reduce = redissonClient.getLock("reduce");
        reduce.lock(10, TimeUnit.SECONDS);
        String goodsInventory = jedis.get("num");
        Integer num = Integer.valueOf(goodsInventory);
        if (num > 0) {
            num -= 1;
        }
        jedis.set("num", num.toString());
        System.out.println(num);
        reduce.unlock();
        return "ok";
    }

    @GetMapping("initNum")
    public String initNum(){
        String num = jedis.set("num", "4000");
        return "ok";
    }

}
