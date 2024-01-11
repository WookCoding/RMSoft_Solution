package com.app.rmsoft_codingtest.domain.vo;

import lombok.*;

@Getter
@ToString
@Builder
@Setter
public class SubscribeFormVO {

    private Long subscribeFormId;
    private String subscribeFormType;
    private Long subscribeFormPrice;
    private Long subscribeFormPeriod;

}
