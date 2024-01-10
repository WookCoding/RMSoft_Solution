package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import com.app.rmsoft_codingtest.mapper.SubscribeFormMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SubscribeFormDAO {

    private final SubscribeFormMapper subscribeFormMapper;

    //    구독 버전 추가
    public void insert(SubscribeFormVO subscribeFormVO){
        subscribeFormMapper.insert(subscribeFormVO);
    }

    //    구독 버전 목록
    public List<SubscribeFormVO> findAll(){
        return subscribeFormMapper.findAll();
    }

    //    구독 버전 찾기
    public SubscribeFormVO findById(Long subscribeFormId){
        return subscribeFormMapper.findById(subscribeFormId);
    }

    //    구독 버전 수정
    public void update(SubscribeFormVO subscribeFormVO){
        subscribeFormMapper.update(subscribeFormVO);
    }

    //    구독 버전 삭제
    public void delete(Long subscribeFormId){
        subscribeFormMapper.delete(subscribeFormId);
    }

}
