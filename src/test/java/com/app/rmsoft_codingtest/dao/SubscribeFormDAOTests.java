package com.app.rmsoft_codingtest.dao;

import com.app.rmsoft_codingtest.domain.dao.SubscribeFormDAO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SubscribeFormDAOTests {

    @Autowired
    private SubscribeFormDAO subscribeFormDAO;

    //    추가 테스트
    @Test
    public void insertTest() {
        SubscribeFormVO basic = SubscribeFormVO.builder()
                .subscribeFormPrice(10000L)
                .subscribeFormPeriod(3L)
                .subscribeFormType("BASIC")
                .build();

        SubscribeFormVO standard = SubscribeFormVO.builder()
                .subscribeFormPrice(15000L)
                .subscribeFormPeriod(6L)
                .subscribeFormType("STANDARD")
                .build();

        SubscribeFormVO premium = SubscribeFormVO.builder()
                .subscribeFormPrice(20000L)
                .subscribeFormPeriod(12L)
                .subscribeFormType("PREMIUM")
                .build();

        subscribeFormDAO.insert(basic);
        subscribeFormDAO.insert(standard);
        subscribeFormDAO.insert(premium);
    }

    //      목록 찾기 테스트
    @Test
    public void findAllTest() {
        List<SubscribeFormVO> subscribeFormVOS = subscribeFormDAO.findAll();
        subscribeFormVOS.stream().forEach((data) -> log.info("타입명  : " + data.getSubscribeFormType()));
    }

    //      찾기 테스트
    @Test
    public void findByIdTest(){
        log.info("타입 : " + subscribeFormDAO.findById(1L).getSubscribeFormType());
    }

    //    수정 테스트
    @Test
    public void updateTest() {
        SubscribeFormVO subscribeFormVO = subscribeFormDAO.findById(1L);
        subscribeFormVO.setSubscribeFormPrice(10000L);
        subscribeFormDAO.update(subscribeFormVO);
    }


    //    삭제 테스트
    @Test
    public void deleteTest(){
        subscribeFormDAO.delete(1L);
    }

}
