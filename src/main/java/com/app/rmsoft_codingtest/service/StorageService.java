package com.app.rmsoft_codingtest.service;


import com.app.rmsoft_codingtest.domain.vo.StorageVO;

public interface StorageService {

    //    저장 공간 사용
    public void useStorage(StorageVO storageVO);

    //    저장공간의 크기
    public Long storageSize(Long subscribeId);

    //  저장 공간 업데이트
    public void updateStorage(StorageVO storageVO);

}
