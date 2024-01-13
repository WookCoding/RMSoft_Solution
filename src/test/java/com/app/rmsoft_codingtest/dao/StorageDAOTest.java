package com.app.rmsoft_codingtest.dao;

import com.app.rmsoft_codingtest.domain.dao.StorageDAO;
import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StorageDAOTest {

    @Autowired
    private StorageDAO storageDAO;


    //    저장 공간 사용
    @Test
    public void insertTest(){
        StorageVO storageVO = StorageVO.builder()
                .subscribeId(1L)
                .memberId(1L)
                .usedStorageSize(300L)
                .build();

        storageDAO.insert(storageVO);
    }

    //    사용 중인 구독 서비스의 총 사용 크기
    @Test
    public void usedStorageSizeAllTest(){
        log.info("값 : " + storageDAO.usedStorageSizeAll(1L));
    }

    //  저장 공간 업데이트
    @Test
    public void update(){
        StorageVO storageVO = storageDAO.findBySubscribeId(3L);
        StorageVO storage = StorageVO.builder()
                .subscribeId(storageVO.getSubscribeId())
                .memberId(storageVO.getMemberId())
                .usedStorageSize(storageVO.getUsedStorageSize() + 1024)
                .build();
        storageDAO.update(storage);
    }


}
