package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StorageServiceTests {

    @Autowired
    private StorageService storageService;

    @Test
    public void usedStorageTest(){
        StorageVO storageVO = StorageVO.builder()
                .usedStorageSize(1024000L)
                .subscribeId(3L)
                .memberId(1L)
                .build();

        storageService.useStorage(storageVO);
    }
}
