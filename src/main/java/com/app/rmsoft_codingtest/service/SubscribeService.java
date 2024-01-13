package com.app.rmsoft_codingtest.service;


import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;

import java.util.List;

public interface SubscribeService {

//    구독 신청
    public void subscribeApply(SubscribeDTO subscribeDTO);

//    구독 연장 신청 서비스
    public void request(SubscribeExtensionRequestVO subscribeExtensionRequestVO);

    //    서비스 대시 보드
    public List<DashboardDTO> dashboardList( Long memberId, String subscribeFormType);

}
