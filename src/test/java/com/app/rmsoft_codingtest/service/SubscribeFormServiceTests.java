package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SubscribeFormServiceTests {

    @Autowired
    private SubscribeFormServiceImpl subscribeFormService;

    //    구독 버전 추가
    @Test
    public void insertFormTest(){
        SubscribeFormVO subscribeFormVO = SubscribeFormVO.builder()
                .subscribeFormPrice(30000L)
                .subscribeFormPeriod(12L)
                .subscribeFormType("TEST")
                .build();

        subscribeFormService.insertForm(subscribeFormVO);
    }

    //    구독 버전 목록
    @Test
    public void findAllFormTest(){
        List<SubscribeFormVO> subscribeFormVOS = subscribeFormService.findAllForm();
        subscribeFormVOS.stream().forEach(data ->{log.info("타입 명 : " + data.getSubscribeFormType());});
    }

    //    구독 버전 찾기
    @Test
    public void findFormTest(){
        SubscribeFormVO subscribeFormVO = subscribeFormService.findForm(4L);
        log.info("타입 명 : " + subscribeFormVO.getSubscribeFormType());
    }

    //    구독 버전 수정
    @Test
    public void updateFormTest(){
        SubscribeFormVO subscribeFormVO = SubscribeFormVO.builder()
                .subscribeFormId(4L)
                .subscribeFormPrice(30000L)
                .subscribeFormPeriod(12L)
                .subscribeFormType("TEST TYPE")
                .build();
        subscribeFormService.updateForm(subscribeFormVO);

        log.info(subscribeFormService.findForm(4L).getSubscribeFormType());

    }

    //    구독 버전 삭제
    @Test
    public void deleteFormTest(){
        log.info("초기 크기 : " + subscribeFormService.findAllForm().size());
        subscribeFormService.deleteForm(4L);
        log.info("이후 크기 : " + subscribeFormService.findAllForm().size());
    }
}
