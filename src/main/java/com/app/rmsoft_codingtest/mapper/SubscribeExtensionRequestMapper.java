package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeExtensionRequestVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeExtensionRequestMapper {

//    구독 기간 연장 신청
    public void insert(SubscribeExtensionRequestVO subscribeExtensionRequestVO);
}
