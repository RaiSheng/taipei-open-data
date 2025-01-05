package com.rswang.taipeiopendata.service;

import com.rswang.taipeiopendata.model.YouBikeInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YouBikeInfoService {

    // 定義 API 資料來源 URL
    @Value("${youbike.api.url}")
    public String url;

    // 根據指定區域過濾，取得 YouBike資訊
    public List<YouBikeInfo> getYouBikeInfoByArea(String area) {
        // 使用 RestTemplate 從遠端 API 取得資料
        RestTemplate restTemplate = new RestTemplate();

        // 發送GET請求，並將結果整理成 YouBikeInfo 陣列
        YouBikeInfo[] info = restTemplate.getForObject(url, YouBikeInfo[].class);

        // 不為空的話，則根據指定區域過濾出資料
        if (info != null) {
            return Arrays.stream(info)
                    .filter(i -> i.getArea().equals(area))
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}
