package cn.hehe.examples.others.all.requestMerge;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hyp
 * @title: GoodsMapper
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/6/13 15:01
 */
@Repository
public class GoodsMapper {

    public List<Goods> batchQueryByCodes(List<String> codes){
        List<Goods> goodsList = new ArrayList<>();
        if (CollUtil.isNotEmpty(codes)) {
            codes.forEach(code -> goodsList.add(new Goods(code, "name" + new Random(8))));
        }
        return goodsList;
    }

}
