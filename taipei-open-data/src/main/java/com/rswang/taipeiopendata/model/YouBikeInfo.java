package com.rswang.taipeiopendata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class YouBikeInfo {

    // 使用 @JsonProperty 將 JSON 的 "sno" 對應到 sno 變數
    @JsonProperty("sno")
    private String sno; //

    // 使用 @JsonProperty 將 JSON 的 "sna" 對應到 stationName 變數
    @JsonProperty("sna")
    private String stationName;  // 站名

    // 使用 @JsonProperty 將 JSON 的 "sarea" 對應到 area 變數
    @JsonProperty("sarea")
    private String area;  // 區域

    @JsonProperty("total")
    private Integer total; // 場站總停車格

    @JsonProperty("available_rent_bikes")
    private Integer availableRentBikes; // 場站目前車輛數量

    @JsonProperty("mday")
    private String mday; // 資料更新時間

    public String getMday() {
        return mday;
    }

    public void setMday(String mday) {
        this.mday = mday;
    }

    public Integer getAvailableRentBikes() {
        return availableRentBikes;
    }

    public void setAvailableRentBikes(Integer availableRentBikes) {
        this.availableRentBikes = availableRentBikes;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
