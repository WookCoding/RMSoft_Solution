package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {

    public void insertSubscribe(SubscribeVO subscribeVO);
}
