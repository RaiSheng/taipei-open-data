package com.rswang.taipeiopendata.controller;


import com.rswang.taipeiopendata.model.YouBikeInfo;
import com.rswang.taipeiopendata.service.YouBikeInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YouBikeInfoController {

    private YouBikeInfoService youBikeInfoService;

    // 建構子注入
    public YouBikeInfoController(YouBikeInfoService youBikeInfoService) {
        this.youBikeInfoService = youBikeInfoService;
    }

    // GET請求端點，取得指定區域的] YouBikeInfo
    @GetMapping("/youbike")
    public List<YouBikeInfo> getYouBikeInfoByArea(@RequestParam String area) {
        // 透過 Service 層取得資料
        return youBikeInfoService.getYouBikeInfoByArea(area);
    }
}
