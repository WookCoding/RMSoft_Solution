package com.app.rmsoft_codingtest.controller;

import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import com.app.rmsoft_codingtest.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribe/*")
public class SubscribeRestController {

    private final SubscribeService subscribeService;

//  구독 신청
    @PostMapping("subscribeApply")
    public void subscribeApply(@RequestBody SubscribeDTO subscribeDTO){
        subscribeService.subscribeApply(subscribeDTO);
    }

    //    구독 연장 신청
    @PostMapping("request")
    public void request(@RequestBody SubscribeExtensionRequestVO subscribeExtensionRequestVO) {
        subscribeService.request(subscribeExtensionRequestVO);
    }

//    대시 보드
    @GetMapping("dashboard")
    public List<DashboardDTO> dashboard(@RequestParam("subscribeFormType") String subscribeFormType, @RequestParam("memberId") Long memberId){
        return subscribeService.dashboardList(memberId, subscribeFormType);
    }
}
