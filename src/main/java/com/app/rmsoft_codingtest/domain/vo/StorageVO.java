package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class StorageVO {

   private Long storageId;
   private Long memberId;
   private Long subscribeId;
   private Long usedStorageSize;
   private LocalDateTime lastUpdated;

}
