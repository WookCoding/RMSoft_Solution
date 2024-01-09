package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Builder
@ToString
@Getter
public class SubscribeVO {

    private Long subscribeId;
    private Long subscribeFormId;
    private Long memberId;
    private Long subscribeUsePeople;
    private String subscribeStorageSize;
    private Date subscribeStartDate;
    private Date SubscribeEndDate;

}
