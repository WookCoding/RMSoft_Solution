package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class SubscribeMapperTests {

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Autowired
    private SubscribeFormMapper subscribeFormMapper;

//    구독 신청
    @Test
    public void insertSubscribeTest(){
        LocalDateTime dateTime = LocalDateTime.now();
        SubscribeFormVO subscribeFormVO = subscribeFormMapper.findById(1L);

        SubscribeVO subscribeVO = SubscribeVO.builder()
                .subscribeFormId(1L)
                .subscribeStorageSize(1024L)
                .subscribeUsePeople(4L)
                .memberId(1L)
                .subscribeStartDate(dateTime)
                .subscribeEndDate(dateTime.plusMonths(subscribeFormVO.getSubscribeFormPeriod()))
                .build();

        subscribeMapper.insert(subscribeVO);
        log.info("현재 시퀀스 값 : " + subscribeMapper.currentSequence());
    }
    
//    구독 찾기
    @Test
    public void findByIdTest(){
        SubscribeVO subscribeVO = subscribeMapper.findById(3L);
        
        log.info("종료일 : " + subscribeVO.getSubscribeEndDate());
    }

//    현재 시퀀스값
    @Test
    public void currentSequenceTest(){
        log.info("현재 시퀀스 값 : " + subscribeMapper.currentSequence());
    }

}
