package cn.hehe.examples.others.all.requestMerge;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author hyp
 * @title: GoodsMapper
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/6/13 15:01
 */
@Repository
public class GoodsMapper {

    /**
     * 模拟合并查询
     * @param codes
     * @return
     */
    public Map<String, Goods> batchQueryByCodes(List<String> codes) {
        System.out.println("合并请求：" + codes);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Goods> goodMap = new HashMap<>();
        if (CollUtil.isNotEmpty(codes)) {
            codes.forEach(code -> goodMap.put(code, new Goods(code, "name" + new Random(8))));
        }
        return goodMap;
    }

    /**
     * 模拟单个查询
     * @param code
     * @return
     */
    public Goods queryByCode(String code) {
        System.out.println("单个请求：" + code);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Goods(code, "name" + new Random(8));
    }

}
