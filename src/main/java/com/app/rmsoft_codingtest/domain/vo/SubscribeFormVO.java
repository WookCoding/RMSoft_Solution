package com.app.rmsoft_codingtest.domain.vo;

import lombok.*;

@Getter
@ToString
@Builder
@Setter
@AllArgsConstructor
public class SubscribeFormVO {

    private Long subscribeFormId;
    private String subscribeFormType;
    private Long subscribeFormPrice;
    private Long subscribeFormPeriod;

}
