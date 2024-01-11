package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;

import java.util.List;

public interface SubscribeFormService {

    //    구독 버전 추가
    public void insertForm(SubscribeFormVO subscribeFormVO);

    //    구독 버전 목록
    public List<SubscribeFormVO> findAllForm();

    //    구독 버전 찾기
    public SubscribeFormVO findForm(Long subscribeFormId);

    //    구독 버전 수정
    public void updateForm(SubscribeFormVO subscribeFormVO);

    //    구독 버전 삭제
    public void deleteForm(Long subscribeFormId);
}
