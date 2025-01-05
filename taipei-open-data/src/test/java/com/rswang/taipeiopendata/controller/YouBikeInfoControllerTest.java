package com.rswang.taipeiopendata.controller;

import com.rswang.taipeiopendata.model.YouBikeInfo;
import com.rswang.taipeiopendata.service.YouBikeInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class YouBikeInfoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private YouBikeInfoService youBikeInfoService;

    @InjectMocks
    private YouBikeInfoController youBikeInfoController;

    @BeforeEach
    public void setUp() {
        // 初始化 MockMvc，並將 Controller 作為測試目標
        mockMvc = MockMvcBuilders.standaloneSetup(youBikeInfoController).build();
    }

    @Test
    public void testGetYouBikeInfoByArea() throws Exception {
        // 模擬 Service 回傳資料
        List<YouBikeInfo> mockYouBikeInfos = Arrays.asList(
                new YouBikeInfo() {{
                    setStationName("Station A");
                    setArea("大安區");
                }},
                new YouBikeInfo() {{
                    setStationName("Station C");
                    setArea("大安區");
                }}
        );

        when(youBikeInfoService.getYouBikeInfoByArea("大安區")).thenReturn(mockYouBikeInfos);

        // 發送 GET 請求，並驗證結果
        mockMvc.perform(get("/youbike")
                        .param("area", "大安區")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].sna", is("Station A")))
                .andExpect(jsonPath("$[0].sarea", is("大安區")))
                .andExpect(jsonPath("$[1].sna", is("Station C")))
                .andExpect(jsonPath("$[1].sarea", is("大安區")));
    }
}