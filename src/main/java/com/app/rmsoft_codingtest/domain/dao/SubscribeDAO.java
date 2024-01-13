package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import com.app.rmsoft_codingtest.mapper.SubscribeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubscribeDAO {

    private final SubscribeMapper subscribeMapper;

//    구독 신청
    public void insert(SubscribeVO subscribeVO){
        subscribeMapper.insert(subscribeVO);
    }

//    구독 찾기
    public SubscribeVO findById(Long subscribeId){
        return subscribeMapper.findById(subscribeId);
    }

//    현재 시퀀스 값
    public Long currentSequence(){
        return subscribeMapper.currentSequence();
    }
}
