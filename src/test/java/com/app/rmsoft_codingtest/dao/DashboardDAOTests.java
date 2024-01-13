package com.app.rmsoft_codingtest.dao;

import com.app.rmsoft_codingtest.domain.dao.DashboardDAO;
import com.app.rmsoft_codingtest.domain.dao.StorageDAO;
import com.app.rmsoft_codingtest.domain.dao.SubscribeDAO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.vo.DashboardVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class DashboardDAOTests {

    @Autowired
    private DashboardDAO dashboardDAO;

    @Autowired
    private SubscribeDAO subscribeDAO;

    @Autowired
    private StorageDAO storageDAO;
    
//    대시 보드 넣기
    @Test
    public void insertTest(){

        SubscribeVO subscribeVO = subscribeDAO.findById(1L);
        Long usedStorageSize = storageDAO.usedStorageSizeAll(subscribeVO.getSubscribeId());
        LocalDateTime dateTime = LocalDateTime.now();

        Duration duration = Duration.between(dateTime, subscribeVO.getSubscribeEndDate());

        DashboardVO dashboardVO = DashboardVO.builder()
                .memberId(1L)
                .subscribeId(subscribeVO.getSubscribeId())
                .subscribeRemainingStorage(subscribeVO.getSubscribeStorageSize() - usedStorageSize)
                .subscribeRemainingPeriod(duration.getSeconds())
                .build();

        dashboardDAO.insert(dashboardVO);
    }

    //    dashboard find
    @Test
    public void dashboardCheckTest(){
        log.info("갯수 :" + dashboardDAO.dashboardCheck(1L));
        log.info("갯수 :" + dashboardDAO.dashboardCheck(2L));
    }

    //    dashboardVO
    @Test
    public void findBySubscribeIdTest(){
        SubscribeVO subscribeVO = subscribeDAO.findById(1L);
        DashboardVO dashboardVO = dashboardDAO.findBySubscribeId(subscribeVO.getSubscribeId());
        log.info("구독 서비스  : " + dashboardVO.getSubscribeId());
    }

    //    dashboard update
    @Test
    public void updateTest(){
        SubscribeVO subscribeVO = subscribeDAO.findById(1L);
        DashboardVO dashboardVO = dashboardDAO.findBySubscribeId(subscribeVO.getSubscribeId());
        LocalDateTime dateTime = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, subscribeVO.getSubscribeEndDate());

        DashboardVO updateDashboard = DashboardVO.builder()
                .dashboardId(dashboardVO.getDashboardId())
                .subscribeRemainingPeriod(duration.getSeconds())
                .subscribeId(dashboardVO.getSubscribeId())
                .subscribeRemainingStorage(dashboardVO.getSubscribeRemainingStorage() + 14040L)
                .memberId(dashboardVO.getMemberId())
                .build();

        dashboardDAO.updateBySubscribeId(updateDashboard);
    }

//    dashboardList
    @Test
    public void dashboardListTest(){
        SearchDTO searchDTO = new SearchDTO();
        dashboardDAO.dashboardList(1L,searchDTO).stream().forEach(e ->log.info("종료일 : " + e.getSubscribeEndDate()));


    }
}
