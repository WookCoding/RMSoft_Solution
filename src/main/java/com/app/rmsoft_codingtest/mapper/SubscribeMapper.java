package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {

//    구독 신청
    public void insert(SubscribeVO subscribeVO);

//    구독 찾기
    public SubscribeVO findById(Long subscribeId);

//    현재 시퀀스 id값
    public Long currentSequence();
}
