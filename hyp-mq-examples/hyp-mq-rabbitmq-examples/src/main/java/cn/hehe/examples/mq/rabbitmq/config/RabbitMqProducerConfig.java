package cn.hehe.examples.mq.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author hyp
 * @title: RabbitMqProducerConfig
 * @projectName hyp-examples
 * @description: 生产者配置文件
 * @date 2022/5/26 11:33
 */
@Component
public class RabbitMqProducerConfig {

    //<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~简单模式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    @Bean
    public Queue setQueue() {
        return new Queue("helloWorldqueue");
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~工作队列模式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    @Bean
    public Queue workQ1() {
        return new Queue("work_sb_mq_q");
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~发布订阅模式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    //声明队列
    @Bean
    public Queue fanoutQ1() {
        return new Queue("fanout.q1");
    }
    @Bean
    public Queue fanoutQ2() {
        return new Queue("fanout.q2");
    }


    //声明exchange
    @Bean
    public FanoutExchange setFanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }


    //声明Binding,exchange与queue的绑定关系
    @Bean
    public Binding bindQ1() {
        return BindingBuilder.bind(fanoutQ1()).to(setFanoutExchange());
    }
    @Bean
    public Binding bindQ2() {
        return BindingBuilder.bind(fanoutQ2()).to(setFanoutExchange());
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~路由模式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    //声明队列
    @Bean
    public Queue directQ1() {
        return new Queue("direct_sb_mq_q1");
    }
    @Bean
    public Queue directQ2() {
        return new Queue("direct_sb_mq_q2");
    }


    //声明exchange
    @Bean
    public DirectExchange setDirectExchange() {
        return new DirectExchange("directExchange");
    }

    //声明binding，需要声明一个routingKey
    @Bean
    public Binding bindDirectBind1() {
        return BindingBuilder.bind(directQ1()).to(setDirectExchange()).with("china.changsha");
    }
    @Bean
    public Binding bindDirectBind2() {
        return BindingBuilder.bind(directQ2()).to(setDirectExchange()).with("china.beijing");
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~主题模式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    //声明队列
    @Bean
    public Queue topicQ1() {
        return new Queue("topic_sb_mq_q1");
    }
    @Bean
    public Queue topicQ2() {
        return new Queue("topic_sb_mq_q2");
    }


    //声明exchange
    @Bean
    public TopicExchange setTopicExchange() {
        return new TopicExchange("topicExchange");
    }

    //声明binding，需要声明一个roytingKey
    @Bean
    public Binding bindTopicHebei1() {
        return BindingBuilder.bind(topicQ1()).to(setTopicExchange()).with("changsha.*");
    }
    @Bean
    public Binding bindTopicHebei2() {
        return BindingBuilder.bind(topicQ2()).to(setTopicExchange()).with("#.beijing");
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	//<!-- ~~~~~~~~~~~~~~~~ExchangeBuilder与QueueBuilder使用案例~~~~~~~~~~~~~~~~~~~~~~~~ -->
    //定义交换机的名字
    public static final String  EXCHANGE_NAME = "boot_topic_exchange";
    //定义队列的名字
    public static final String QUEUE_NAME = "boot_queue";

    //1、声明交换机
    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    //2、声明队列
    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    //3、队列与交换机进行绑定
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }
	//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

}
