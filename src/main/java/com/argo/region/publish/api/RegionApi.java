package com.argo.region.publish.api;

import com.argo.region.publish.model.RegionRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.publish.api.RegionApi</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Api(value = "region", description = "the region API")
public interface RegionApi {

    @ApiOperation(value = "查询行政区划", nickname = "searchRegions", notes = "通过参数实现对中国行政区划的查询。行政区划共分为5级， 从省/自治区/直辖市到街道办事处和村委会。返回的行政区划数据按照行政区划码进行排序。", responseContainer = "List", tags={  })
    @RequestMapping(value = "/region",  produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<RegionRes> searchRegions(String id, String name);
}
