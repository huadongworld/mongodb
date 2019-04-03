package com.ys.mongodb.spring.data.mongodb.model;

/**
 * @author HuaDong
 * @date 2019/4/3 15:19
 */
public class Address {

    private String regionId;

    private String province;

    public Address(String regionId, String province) {
        this.regionId = regionId;
        this.province = province;
    }

    public Address() {

    }

    @Override
    public String toString() {
        return "Address{" +
                "regionId='" + regionId + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
