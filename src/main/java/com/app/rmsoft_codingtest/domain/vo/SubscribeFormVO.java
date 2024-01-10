package com.app.rmsoft_codingtest.domain.vo;

import com.app.rmsoft_codingtest.domain.enums.SubscribeFormType;
import lombok.*;

@Getter
@ToString
@Builder
@Setter
public class SubscribeFormVO {

    private Long subscribeFormId;
    private SubscribeFormType subscribeFormType;
    private Long subscribeFormPrice;
    private Long subscribeFormPeriod;

}
