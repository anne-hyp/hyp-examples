package cn.hehe.examples.others.all.requestMerge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author hyp
 * @title: GoodController
 * @projectName hyp-examples
 * @description: 商品前端控制类
 * @date 2022/6/29 10:56
 */
@RestController
public class GoodController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("test1")
    public void queryByCode1() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        CountDownLatch downLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            final String code = "code" + i;
            Thread t = new Thread(() -> {
                Goods goods = null;
                try {
                    goods = goodsService.queryByCode(code);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------>" + goods.getCode() + "--" + goods.getName());
                downLatch.countDown();
            });
            t.setName("thread_" + code);
            t.start();
        }
        downLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    @GetMapping("test2")
    public void queryByCode2() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        CountDownLatch downLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            final String code = "code" + i;
            Thread t = new Thread(() -> {
                Goods goods = null;
                try {
                    goods = goodsService.queryByCode2(code);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------>" + goods.getCode() + "--" + goods.getName());
                downLatch.countDown();
            });
            t.setName("thread_" + code);
            t.start();
        }
        downLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    @GetMapping("test3")
    public void queryByCode3(String code) throws InterruptedException, ExecutionException {
        goodsService.queryByCode(code);
    }

    @GetMapping("test4")
    public void queryByCode4(String code) throws InterruptedException {
        goodsService.queryByCode2(code);
    }

}
