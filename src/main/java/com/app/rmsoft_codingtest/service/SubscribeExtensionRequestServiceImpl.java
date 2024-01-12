package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.SubscribeExtensionRequestDAO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscribeExtensionRequestServiceImpl implements SubscribeExtensionRequestService {

    private final SubscribeExtensionRequestDAO subscribeExtensionRequestDAO;

    @Override
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
}
