package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
@Slf4j
public class SubscribeServiceTests {

    @Autowired
    private SubscribeService subscribeService;

//    구독 신청
    @Test
    public void subscribeApplyTest(){

        for (int i = 0; i < 50; i++) {

            SubscribeDTO subscribeDTO = SubscribeDTO.builder()
                    .memberId(Long.valueOf(""+(i + 1)))
                    .subscribeFormId(1L)
                    .subscribeStorageSize(102400000L)
                    .subscribeUsePeople(3L)
                    .memberCompanyName("test컴퍼니" + i)
                    .memberEmail("test" +i + "@naver.com" )
                    .memberPhoneNumber("010123413"+ i)
                    .build();

            subscribeService.subscribeApply(subscribeDTO);
        }

    }

    //    구독 연장 신청
    @Test
    public void extensionRequestTest() {
        LocalDateTime dateTime = LocalDateTime.now();

        SubscribeExtensionRequestVO subscribeExtensionRequestVO = SubscribeExtensionRequestVO.builder()
                .memberId(1L)
                .subscribeId(1L)
                .extensionPeriod(3L)
                .requestDate(dateTime)
                .build();

        subscribeService.request(subscribeExtensionRequestVO);
    }
}
