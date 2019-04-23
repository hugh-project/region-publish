package com.argo.region.publish.model;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/23
 * Time: 17:08
 *
 * @author hugh
 */
public class RegionRes {
    private Long total;
    private List<RegionPublish> data;

    public RegionRes(Long total, List<RegionPublish> data) {
        this.total = total;
        this.data = data;
    }

    public RegionRes() {

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<RegionPublish> getData() {
        return data;
    }

    public void setData(List<RegionPublish> data) {
        this.data = data;
    }
}
