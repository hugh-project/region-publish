package com.argo.region.publish.configuration;

import com.argo.region.publish.hanlder.RegionMessageHanlder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.publish.configuration.AmqpConfiguration</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Configuration
public class AmqpConfiguration {
    public static final String DataPublishExchangeName = "data-publish-region1";
    @Bean
    public FanoutExchange regionPublishExchange(){
        return new FanoutExchange(DataPublishExchangeName);
    }
    public static final String RegionPublishQue = "region-publish-region-publish1";
    @Bean
    public Queue regionPublish(){return new Queue(RegionPublishQue);}
    //绑定交换机和队列
    @Bean
    public Binding binding(FanoutExchange regionPublishExchange,Queue regionPublish){
        return BindingBuilder.bind(regionPublish).to(regionPublishExchange);
    }

    @Bean("pointTaskContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory, RegionProperties properties) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(properties.getMq().getMaxCount() );
        factory.setConcurrentConsumers(properties.getMq().getMaxThreads());
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    @Bean
    public RegionMessageHanlder regionPublishListener() {
        return new RegionMessageHanlder();
    }

}
