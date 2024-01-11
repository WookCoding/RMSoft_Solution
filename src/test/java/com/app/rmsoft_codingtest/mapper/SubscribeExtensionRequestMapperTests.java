package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class SubscribeExtensionRequestMapperTests {

    @Autowired
    private SubscribeExtensionRequestMapper subscribeExtensionRequestMapper;
    
//    구독 신청 테스트
    @Test
    public void insertTest(){
        LocalDateTime dateTime = LocalDateTime.now();

        SubscribeExtensionRequestVO subscribeExtensionRequestVO = SubscribeExtensionRequestVO.builder()
                .memberId(1L)
                .subscribeId(1L)
                .extensionPeriod(3L)
                .requestDate(dateTime)
                .build();

        subscribeExtensionRequestMapper.insert(subscribeExtensionRequestVO);
    }

}
