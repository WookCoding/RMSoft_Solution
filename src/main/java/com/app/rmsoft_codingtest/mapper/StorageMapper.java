package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper {

    //    저장 공간 사용
    public void insert(StorageVO storageVO);

    //    사용 중인 구독 서비스의 사용 크기
    public Long usedStorageSizeAll(Long subscribeId);

    //  저장 공간 업데이트
    public void update(StorageVO storageVO);

//     사용 중인 저장공간
    public StorageVO findBySubscribeId(Long subscribeId);
}
