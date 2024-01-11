package com.app.rmsoft_codingtest.domain.vo;

import com.app.rmsoft_codingtest.domain.enums.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class SubscribeExtensionRequestVO {

   private Long requestId;
   private Long memberId;
   private Long subscribeId;
   private Long extensionPeriod;
   private RequestType requestType;
   private LocalDateTime requestDate;

}
