package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SubscribeServiceTests {

    @Autowired
    private SubscribeService subscribeService;

    @Test
    public void test(){
        SubscribeDTO subscribeDTO = SubscribeDTO.builder()
                .memberId(1L)
                .subscribeFormId(1L)
                .subscribeStorageSize("1TB")
                .subscribeUsePeople(4L)
                .memberCompanyName("test컴퍼니")
                .memberEmail("test@naver.com")
                .memberPhoneNumber("01012341234")
                .build();

        subscribeService.subscribeApply(subscribeDTO);
    }
}
