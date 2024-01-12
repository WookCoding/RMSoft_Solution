package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class SubscribeExtensionRequestServiceTests {

    @Autowired
    private SubscribeExtensionRequestService subscribeExtensionRequestService;


//    구독 연장 신청
    @Test
    public void extensionRequestTest(){
        LocalDateTime dateTime = LocalDateTime.now();

        SubscribeExtensionRequestVO subscribeExtensionRequestVO = SubscribeExtensionRequestVO.builder()
                .memberId(1L)
                .subscribeId(1L)
                .extensionPeriod(3L)
                .requestDate(dateTime)
                .build();

        subscribeExtensionRequestService.request(subscribeExtensionRequestVO);
    }
}
