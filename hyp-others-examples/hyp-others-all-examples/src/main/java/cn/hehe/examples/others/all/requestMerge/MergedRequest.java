package cn.hehe.examples.others.all.requestMerge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;

/**
 * @author hyp
 * @title: MergedRequest
 * @projectName hyp-examples
 * @description: 合并请求实体类
 * @date 2022/6/29 11:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MergedRequest {

    String code;

    CompletableFuture future;

}
