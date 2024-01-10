package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscribeFormMapper {

    //    구독 버전 추가
    public void insert(SubscribeFormVO subscribeFormVO);

    //    구독 버전 목록
    public List<SubscribeFormVO> findAll();

    //    구독 버전 찾기
    public SubscribeFormVO findById(Long subscribeFormId);

    //    구독 버전 수정
    public void update(SubscribeFormVO subscribeFormVO);

    //    구독 버전 삭제
    public void delete(Long subscribeFormId);


}
