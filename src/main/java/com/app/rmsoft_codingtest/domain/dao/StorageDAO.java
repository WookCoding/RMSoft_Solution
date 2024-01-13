package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import com.app.rmsoft_codingtest.mapper.StorageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StorageDAO {

    private final StorageMapper storageMapper;

    //    저장 공간 사용
    public void insert(StorageVO storageVO){
        storageMapper.insert(storageVO);
    }

    //    사용 중인 구독 서비스의 총 사용 크기
    public Long usedStorageSizeAll(Long subscribeId){
        return storageMapper.usedStorageSizeAll(subscribeId);
    }

    //  저장 공간 업데이트
    public void update(StorageVO storageVO) {
        storageMapper.update(storageVO);
    }

    //     사용 중인 저장공간
    public StorageVO findBySubscribeId(Long subscribeId){
        return storageMapper.findBySubscribeId(subscribeId);
    }
}
