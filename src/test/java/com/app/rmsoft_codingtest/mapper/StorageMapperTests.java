package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StorageMapperTests {


    @Autowired
    private StorageMapper storageMapper;

    //    저장 공간 사용
    @Test
    public void insertTest(){
        StorageVO storageVO = StorageVO.builder()
                .subscribeId(1L)
                .memberId(1L)
                .usedStorageSize(300L)
                .build();

        storageMapper.insert(storageVO);
    }

    //    사용 중인 구독 용량 사용 크기
    @Test
    public void usedStorageSizeAllTest(){
        log.info("::::::::::" + storageMapper.usedStorageSizeAll(1L));
    }

    //  저장 공간 업데이트
    @Test
    public void update(){
        StorageVO storageVO = storageMapper.findBySubscribeId(3L);
        StorageVO storage = StorageVO.builder()
                .subscribeId(storageVO.getSubscribeId())
                .memberId(storageVO.getMemberId())
                .usedStorageSize(storageVO.getUsedStorageSize() + 1024)
                .build();
        storageMapper.update(storage);
    }

}
