package com.app.rmsoft_codingtest.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class SubscribeDTO {

    private Long memberId;
    private String memberName;
    private String memberCompanyName;
    private String memberEmail;
    private String memberPhoneNumber;

    private Long subscribeFormId;
    private String subscribeFormType;
    private Long subscribeFormPrice;
    private Long subscribeFormPeriod;

    private Long subscribeId;
    private Long subscribeUsePeople;
    private Long subscribeStorageSize;
    private LocalDateTime subscribeStartDate;
    private LocalDateTime subscribeEndDate;


}
