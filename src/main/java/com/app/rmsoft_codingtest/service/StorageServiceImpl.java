package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.DashboardDAO;
import com.app.rmsoft_codingtest.domain.dao.StorageDAO;
import com.app.rmsoft_codingtest.domain.dao.SubscribeDAO;
import com.app.rmsoft_codingtest.domain.vo.DashboardVO;
import com.app.rmsoft_codingtest.domain.vo.StorageVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageDAO storageDAO;
    private final SubscribeDAO subscribeDAO;
    private final DashboardDAO dashboardDAO;


    //    저장 공간 사용
    @Override
    @Transactional
    public void useStorage(StorageVO storageVO) {

        StorageVO storage = setStorageVO(storageVO);
        Long subscribeId = storage.getSubscribeId();
        SubscribeVO subscribeVO = setSubscribeVO(subscribeId);
        Long storageSize = 0L;

        storageDAO.insert(storage);
        storageSize = storageSize(subscribeId);
        dashboard(subscribeVO,subscribeId,storageSize);
    }

    //    저장공간의 사용 크기
    public Long storageSize(Long subscribeId) {
        return storageDAO.usedStorageSizeAll(subscribeId);
    }

//    저장 공간 업데이트
    @Override
    public void updateStorage(StorageVO storageVO) {
        StorageVO storage = setStorageVO(storageVO);
        Long subscribeId = storage.getSubscribeId();
        SubscribeVO subscribeVO = setSubscribeVO(subscribeId);
        Long storageSize = 0L;

        storageDAO.update(storage);
        storageSize = storageSize(subscribeId);

        dashboard(subscribeVO,subscribeId,storageSize);
    }

    private StorageVO setStorageVO(StorageVO storageVO) {
        StorageVO storage = StorageVO.builder()
                .storageId(storageVO.getStorageId())
                .usedStorageSize(storageVO.getUsedStorageSize())
                .memberId(storageVO.getMemberId())
                .subscribeId(storageVO.getSubscribeId())
                .build();
        return storage;
    }

    private SubscribeVO setSubscribeVO(Long subscribeId) {
        return subscribeDAO.findById(subscribeId);
    }

    private Long time(LocalDateTime subscribeEndDate){
        LocalDateTime dateTime = LocalDateTime.now();
        return Duration.between(dateTime, subscribeEndDate).getSeconds();
    }

    private void dashboard(SubscribeVO subscribeVO, Long subscribeId, Long max){
        DashboardVO dashboardVO = dashboardDAO.findBySubscribeId(subscribeId);
        DashboardVO updateDashBoard = DashboardVO.builder()
                .dashboardId(dashboardVO.getDashboardId())
                .subscribeRemainingStorage(subscribeVO.getSubscribeStorageSize() - max)
                .subscribeRemainingPeriod(time(subscribeVO.getSubscribeEndDate()))
                .subscribeId(subscribeId)
                .memberId(dashboardVO.getMemberId())
                .build();

        dashboardDAO.updateBySubscribeId(updateDashBoard);
    }


}
