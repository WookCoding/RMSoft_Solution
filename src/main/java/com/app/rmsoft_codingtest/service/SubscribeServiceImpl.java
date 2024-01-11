package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.MemberDAO;
import com.app.rmsoft_codingtest.domain.dao.SubscribeDAO;
import com.app.rmsoft_codingtest.domain.dao.SubscribeFormDAO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscribeServiceImpl implements SubscribeService {

    private final MemberDAO memberDAO;
    private final SubscribeFormDAO subscribeFormDAO;
    private final SubscribeDAO subscribeDAO;

    @Override
    @Transactional
    public void subscribeApply(SubscribeDTO subscribeDTO) {
        SubscribeFormVO subscribeFormVO = subscribeFormDAO.findById(subscribeDTO.getSubscribeFormId());
        LocalDateTime dateTime = LocalDateTime.now();

        SubscribeVO subscribeVO = SubscribeVO.builder()
                .subscribeFormId(subscribeDTO.getSubscribeFormId())
                .memberId(subscribeDTO.getMemberId())
                .subscribeStorageSize(subscribeDTO.getSubscribeStorageSize())
                .subscribeStartDate(dateTime)
                .subscribeEndDate(dateTime.plusMonths(subscribeFormVO.getSubscribeFormPeriod()))
                .subscribeUsePeople(subscribeDTO.getSubscribeUsePeople())
                .build();

        member(subscribeDTO);
        subscribeDAO.insert(subscribeVO);

    }

    private void member(SubscribeDTO subscribeDTO){
        MemberVO memberVO = memberDAO.findById(subscribeDTO.getMemberId());

        MemberVO member = MemberVO.builder()
                .memberId(memberVO.getMemberId())
                .memberPhoneNumber(subscribeDTO.getMemberPhoneNumber())
                .memberEmail(subscribeDTO.getMemberEmail())
                .memberCompanyName(subscribeDTO.getMemberCompanyName())
                .memberPassword(memberVO.getMemberPassword())
                .memberName(memberVO.getMemberName())
                .memberIdentification(memberVO.getMemberIdentification())
                .memberRegisterDate(memberVO.getMemberRegisterDate())
                .build();

        memberDAO.updateMemberVO(member);
    }

}
