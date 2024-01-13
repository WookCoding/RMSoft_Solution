package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.DashboardVO;
import com.app.rmsoft_codingtest.domain.vo.SubscribeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
public class DashboardMapperTests {

    @Autowired
    private DashboardMapper dashboardMapper;

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Autowired
    private StorageMapper storageMapper;

//    dashboard insert
    @Test
    public void insertTest(){
        SubscribeVO subscribeVO = subscribeMapper.findById(1L);
        Long usedStorageSize = storageMapper.usedStorageSizeAll(subscribeVO.getSubscribeId());
        LocalDateTime dateTime = LocalDateTime.now();

        Duration duration = Duration.between(dateTime, subscribeVO.getSubscribeEndDate());

        log.info("subsusbusubu ::::::" + subscribeVO.getSubscribeId());
        DashboardVO dashboardVO = DashboardVO.builder()
                .memberId(1L)
                .subscribeId(subscribeVO.getSubscribeId())
                .subscribeRemainingStorage(subscribeVO.getSubscribeStorageSize() - usedStorageSize)
                .subscribeRemainingPeriod(duration.getSeconds())
                .build();

        dashboardMapper.insert(dashboardVO);
    }

//    dashboard find
    @Test
    public void dashboardCheckTest(){
        log.info("갯수 :" + dashboardMapper.dashboardCheck(1L));
        log.info("갯수 :" + dashboardMapper.dashboardCheck(2L));
    }

//    dashboardVO
    @Test
    public void findBySubscribeIdTest(){
        SubscribeVO subscribeVO = subscribeMapper.findById(1L);
        DashboardVO dashboardVO = dashboardMapper.findBySubscribeId(subscribeVO.getSubscribeId());
        log.info("구독 서비스  : " + dashboardVO.getSubscribeId());
    }

//    dashboard update
    @Test
    public void updateTest(){
        SubscribeVO subscribeVO = subscribeMapper.findById(1L);
        DashboardVO dashboardVO = dashboardMapper.findBySubscribeId(subscribeVO.getSubscribeId());

        DashboardVO updateDashboard = DashboardVO.builder()
                .dashboardId(dashboardVO.getDashboardId())
                .subscribeRemainingPeriod(dashboardVO.getSubscribeRemainingPeriod())
                .subscribeId(dashboardVO.getSubscribeId())
                .subscribeRemainingStorage(dashboardVO.getSubscribeRemainingStorage()+10240L)
                .memberId(dashboardVO.getMemberId())
                .build();

        dashboardMapper.updateBySubscribeId(updateDashboard);
    }

    @Test
    public void dashboardListTest(){
        SearchDTO searchDTO = new SearchDTO();
        Long memberId = 1L;
        searchDTO.setSubscribeFormType("BASIC");

        List<DashboardDTO> subscribeDTOS = dashboardMapper.dashboardList(memberId, searchDTO);

        subscribeDTOS.stream().forEach(e -> log.info("나오나요??" + e.getMemberEmail()));
    }

}
