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

}
