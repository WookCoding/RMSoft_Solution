package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class StorageSerivceTests {

    @Autowired
    private StorageService storageService;

    //    저장 공간 사용
    @Test
    public void insertTest(){
        StorageVO storageVO = StorageVO.builder()
                .subscribeId(1L)
                .memberId(1L)
                .usedStorageSize(300L)
                .build();
        storageService.useStorage(storageVO);
    }

}
