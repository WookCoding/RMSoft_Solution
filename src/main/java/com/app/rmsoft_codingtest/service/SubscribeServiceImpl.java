package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.*;
import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscribeServiceImpl implements SubscribeService {

    private final MemberDAO memberDAO;
    private final SubscribeFormDAO subscribeFormDAO;
    private final SubscribeDAO subscribeDAO;
    private final SubscribeExtensionRequestDAO subscribeExtensionRequestDAO;
    private final DashboardDAO dashboardDAO;

//    구독 신청
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

        //        이미 있는 대시 보드 인지 아닌지 검사
        boolean check = dashboardDAO.dashboardCheck(currentSequence()) == 0;
        if(check){
            dashboardInsert(subscribeVO);
        }else {
            dashboardUpdate(subscribeVO);
        }
    }

//    구독 연장 요청
    @Override @Transactional
    public void request(SubscribeExtensionRequestVO subscribeExtensionRequestVO) {
        LocalDateTime dateTime = LocalDateTime.now();

        SubscribeExtensionRequestVO subscribeExtensionRequest = SubscribeExtensionRequestVO.builder()
                .subscribeId(subscribeExtensionRequestVO.getSubscribeId())
                .memberId(subscribeExtensionRequestVO.getMemberId())
                .extensionPeriod(subscribeExtensionRequestVO.getExtensionPeriod())
                .requestDate(dateTime)
                .build();

        subscribeExtensionRequestDAO.insert(subscribeExtensionRequest);
    }

//    구독 대시 보드
    @Override
    public List<DashboardDTO> dashboardList(Long memberId, String subscribeFormType) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSubscribeFormType(subscribeFormType);

        return dashboardDAO.dashboardList(memberId, searchDTO);
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

    private Long currentSequence(){
        return subscribeDAO.currentSequence();
    }

    public void dashboardInsert(SubscribeVO subscribeVO){
        LocalDateTime dateTime = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, subscribeVO.getSubscribeEndDate());

        DashboardVO dashboardVO = DashboardVO.builder()
                .subscribeRemainingStorage(subscribeVO.getSubscribeStorageSize())
                .subscribeRemainingPeriod(duration.getSeconds())
                .subscribeId(currentSequence())
                .memberId(subscribeVO.getMemberId())
                .build();

        dashboardDAO.insert(dashboardVO);
    }

    public void dashboardUpdate(SubscribeVO subscribeVO){
        LocalDateTime dateTime = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, subscribeVO.getSubscribeEndDate());
        DashboardVO dashboardVO = dashboardDAO.findBySubscribeId(subscribeVO.getSubscribeId());

        DashboardVO dashboard = DashboardVO.builder()
                .dashboardId(dashboardVO.getDashboardId())
                .subscribeId(subscribeVO.getSubscribeId())
                .subscribeRemainingStorage(subscribeVO.getSubscribeStorageSize())
                .subscribeRemainingPeriod(duration.getSeconds())
                .memberId(subscribeVO.getMemberId())
                .build();

        dashboardDAO.updateBySubscribeId(dashboard);
    }
}
