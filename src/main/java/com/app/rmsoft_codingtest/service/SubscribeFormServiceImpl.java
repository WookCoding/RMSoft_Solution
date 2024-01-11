package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.SubscribeFormDAO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscribeFormServiceImpl implements SubscribeFormService {

    private final SubscribeFormDAO subscribeFormDAO;

//    구독 버전 추가
    @Override
    @Transactional
    public void insertForm(SubscribeFormVO subscribeFormVO) {
        SubscribeFormVO subscribeForm = SubscribeFormVO.builder()
                .subscribeFormPeriod(subscribeFormVO.getSubscribeFormPeriod())
                .subscribeFormType(subscribeFormVO.getSubscribeFormType())
                .subscribeFormPrice(subscribeFormVO.getSubscribeFormPrice())
                .build();

        subscribeFormDAO.insert(subscribeForm);
    }

//    구독 버전 리스트
    @Override
    public List<SubscribeFormVO> findAllForm() {
        return subscribeFormDAO.findAll();
    }

//    구독 버전 찾기
    @Override
    public SubscribeFormVO findForm(Long subscribeFormId) {
        return subscribeFormDAO.findById(subscribeFormId);
    }

//     구독 버전 업데이트
    @Override
    public void updateForm(SubscribeFormVO subscribeFormVO) {
        SubscribeFormVO subscribeForm = SubscribeFormVO.builder()
                .subscribeFormId(subscribeFormVO.getSubscribeFormId())
                .subscribeFormPrice(subscribeFormVO.getSubscribeFormPrice())
                .subscribeFormType(subscribeFormVO.getSubscribeFormType())
                .subscribeFormPeriod(subscribeFormVO.getSubscribeFormPeriod())
                .build();

        subscribeFormDAO.update(subscribeFormVO);
    }

//    구독 버전 삭제
    @Override
    public void deleteForm(Long subscribeFormId) {
        subscribeFormDAO.delete(subscribeFormId);
    }
}
