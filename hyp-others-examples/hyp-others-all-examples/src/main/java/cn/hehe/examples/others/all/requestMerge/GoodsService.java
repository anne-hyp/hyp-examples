package cn.hehe.examples.others.all.requestMerge;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

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

    private LinkedBlockingQueue queue = new LinkedBlockingQueue();

    @PostConstruct
    public void init() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            int size = queue.size();
            if (size == 0) {
                return;
            }
            List<MergedRequest> requestList = new ArrayList<MergedRequest>();
            for (int i = 0; i < size; i++) {
                requestList.add((MergedRequest)queue.poll());
            }
            List codeList = new ArrayList();
            for (MergedRequest rq: requestList) {
                codeList.add(rq.getCode());
            }
            Map goodsMap = goodsMapper.batchQueryByCodes(codeList);
            requestList.forEach(rq -> {
                rq.getFuture().complete(goodsMap.get(rq.getCode()));
            });
        }, 0, 10, TimeUnit.MILLISECONDS);
    }

    public Goods queryByCode(String code) throws ExecutionException, InterruptedException {
        MergedRequest mergedRequest = new MergedRequest(code, new CompletableFuture());
        queue.add(mergedRequest);
        return (Goods) mergedRequest.getFuture().get();
    }

    /**
     * 模拟单个查询
     * @param code
     * @return
     */
    public Goods queryByCode2(String code){
        return goodsMapper.queryByCode(code);
    }

}
