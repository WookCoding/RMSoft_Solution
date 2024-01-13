package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class DashboardVO {

   private Long dashboardId;
   private Long memberId;
   private Long subscribeId;
   private Long subscribeRemainingStorage;
   private Long subscribeRemainingPeriod;

}
