package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SubScribeFormMapperTest {

    @Autowired
    private SubscribeFormMapper subscribeFormMapper;


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

        subscribeFormMapper.insert(basic);
        subscribeFormMapper.insert(standard);
        subscribeFormMapper.insert(premium);
    }

    //      목록 찾기 테스트
    @Test
    public void findAllTest() {
        List<SubscribeFormVO> subscribeFormVOS = subscribeFormMapper.findAll();
        subscribeFormVOS.stream().forEach((data) -> log.info("타입명  : " + data.getSubscribeFormType()));
    }

    //      찾기 테스트
    @Test
    public void findByIdTest(){
        log.info("타입 : " + subscribeFormMapper.findById(1L).getSubscribeFormType());
    }

    //    수정 테스트
    @Test
    public void updateTest() {
        SubscribeFormVO subscribeFormVO = subscribeFormMapper.findById(1L);
        subscribeFormVO.setSubscribeFormPrice(10000L);
        subscribeFormMapper.update(subscribeFormVO);
    }


//    삭제 테스트
    @Test
    public void deleteTest(){
        subscribeFormMapper.delete(1L);
    }
}
