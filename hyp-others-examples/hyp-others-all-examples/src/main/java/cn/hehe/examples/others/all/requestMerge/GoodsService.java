package cn.hehe.examples.others.all.requestMerge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author hyp
 * @title: GoodsService
 * @projectName hyp-examples
 * @description: 商品服务层
 * @date 2022/6/13 14:59
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    private LinkedBlockingQueue queue;
}
