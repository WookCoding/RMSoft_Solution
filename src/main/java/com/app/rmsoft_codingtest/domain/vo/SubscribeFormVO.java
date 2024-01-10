package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SubscribeFormVO {

    private Long subscribeFormId;
    private String subscribeFormName;
    private Long subscribeFormPrice;
    private Long subscribeFormPeriod;
}
