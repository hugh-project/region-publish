package com.argo.region.publish.api;

import com.argo.region.publish.configuration.RegionProperties;
import com.argo.region.publish.model.Region;
import com.argo.region.publish.model.RegionPublish;
import com.argo.region.publish.model.RegionRes;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.publish.api.RegionApiController</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Controller
public class RegionApiController implements RegionApi {
    @Autowired
    private MongoTemplate template;
    @Autowired
    private RegionProperties properties;
    @Override
    public ResponseEntity<RegionRes> searchRegions(String id, String name) {
        Query query = new Query();
        if(id!=null&&!id.isEmpty()){
            query.addCriteria(Criteria.where("regionId").is(id));
        }
        if(name!=null&&!name.isEmpty()){
            query.addCriteria(Criteria.where("fullName").regex(name));
        }
        //排序
        query.with(new Sort(Sort.Direction.ASC, "regionId"));
        long count = template.count(query, properties.getDataSource().getCollection());
        List<RegionPublish> regions = template.find(query, RegionPublish.class, properties.getDataSource().getCollection());
        RegionRes regionRes = new RegionRes(count,regions);

        return ResponseEntity.ok(regionRes);
    }
}
