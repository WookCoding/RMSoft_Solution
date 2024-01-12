package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import com.app.rmsoft_codingtest.mapper.SubscribeExtensionRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubscribeExtensionRequestDAO {

    private final SubscribeExtensionRequestMapper subscribeExtensionRequestMapper;

    // 구독 연장 신청
    public void insert(SubscribeExtensionRequestVO subscribeExtensionRequestVO){
        subscribeExtensionRequestMapper.insert(subscribeExtensionRequestVO);
    }

}
