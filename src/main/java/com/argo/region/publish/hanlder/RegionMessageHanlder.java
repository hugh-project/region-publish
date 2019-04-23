package com.argo.region.publish.hanlder;

import com.alibaba.fastjson.JSON;
import com.argo.region.publish.configuration.RegionProperties;
import com.argo.region.publish.model.Region;
import com.argo.region.publish.model.RegionPublishMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.LinkedList;

import static com.argo.region.publish.configuration.AmqpConfiguration.RegionPublishQue;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/23
 * Time: 16:12
 *
 * @author hugh
 */
public class RegionMessageHanlder {
    @Autowired
    private RegionProperties regionProperties;
    @Autowired
    private MongoTemplate template;
    @RabbitListener(queues = RegionPublishQue,containerFactory = "pointTaskContainerFactory")
    public void regionMessagePublish(String msg){
        RegionPublishMessage regionPublishMessage = JSON.parseObject(msg, RegionPublishMessage.class);
        LinkedList<Region> regions = regionPublishMessage.getRegions();
        String collectionName = regionProperties.getDataSource().getCollection();
        if(regions.size()>0){
            for (Region region :regions){
                //删除mogodb数据
                template.remove(new Query().addCriteria(Criteria.where("regionId").is(region.getRegionId())), collectionName);
                //写入数据
                template.insert(region, collectionName);
                System.out.println(region.getRegionId());
            }
        }
    }
}
