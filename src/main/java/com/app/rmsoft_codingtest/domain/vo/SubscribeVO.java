package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime subscribeStartDate;
    private LocalDateTime subscribeEndDate;

}
