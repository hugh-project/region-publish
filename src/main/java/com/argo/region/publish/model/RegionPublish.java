package com.argo.region.publish.model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/23
 * Time: 17:14
 *
 * @author hugh
 */
public class RegionPublish {
    private String regionId;
    private int level;
    private String lv1Code;
    private String lv1Name;
    private String lv2Code;
    private String lv2Name;
    private String lv3Code;
    private String lv3Name;
    private String lv4Code;
    private String lv4Name;
    private String lv5Code;
    private String lv5Name;
    private String fullName;
    private String shortName;
    private Byte isActive;
    private Byte isPoor;
    private String areaCode;
    private String postCode;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLv1Code() {
        return lv1Code;
    }

    public void setLv1Code(String lv1Code) {
        this.lv1Code = lv1Code;
    }

    public String getLv1Name() {
        return lv1Name;
    }

    public void setLv1Name(String lv1Name) {
        this.lv1Name = lv1Name;
    }

    public String getLv2Code() {
        return lv2Code;
    }

    public void setLv2Code(String lv2Code) {
        this.lv2Code = lv2Code;
    }

    public String getLv2Name() {
        return lv2Name;
    }

    public void setLv2Name(String lv2Name) {
        this.lv2Name = lv2Name;
    }

    public String getLv3Code() {
        return lv3Code;
    }

    public void setLv3Code(String lv3Code) {
        this.lv3Code = lv3Code;
    }

    public String getLv3Name() {
        return lv3Name;
    }

    public void setLv3Name(String lv3Name) {
        this.lv3Name = lv3Name;
    }

    public String getLv4Code() {
        return lv4Code;
    }

    public void setLv4Code(String lv4Code) {
        this.lv4Code = lv4Code;
    }

    public String getLv4Name() {
        return lv4Name;
    }

    public void setLv4Name(String lv4Name) {
        this.lv4Name = lv4Name;
    }

    public String getLv5Code() {
        return lv5Code;
    }

    public void setLv5Code(String lv5Code) {
        this.lv5Code = lv5Code;
    }

    public String getLv5Name() {
        return lv5Name;
    }

    public void setLv5Name(String lv5Name) {
        this.lv5Name = lv5Name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Byte getIsPoor() {
        return isPoor;
    }

    public void setIsPoor(Byte isPoor) {
        this.isPoor = isPoor;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Date getChgTime() {
        return chgTime;
    }

    public void setChgTime(Date chgTime) {
        this.chgTime = chgTime;
    }

    private Date chgTime;
}
