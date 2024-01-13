package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.vo.DashboardVO;
import com.app.rmsoft_codingtest.mapper.DashboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DashboardDAO {

    private final DashboardMapper dashboardMapper;

//    대시 보드 insert
    public void insert(DashboardVO dashboardVO){
        dashboardMapper.insert(dashboardVO);
    }

    //    dashboard find
    public Long dashboardCheck(Long subscribeId){
        return dashboardMapper.dashboardCheck(subscribeId);
    }

    //    dashboardVO
    public DashboardVO findBySubscribeId(Long subscribeId){
        return dashboardMapper.findBySubscribeId(subscribeId);
    }

    //    update
    public void updateBySubscribeId(DashboardVO dashboardVO){
         dashboardMapper.updateBySubscribeId(dashboardVO);
    }

    // list
    public List<DashboardDTO> dashboardList(Long memberId, SearchDTO searchDTO){
        return dashboardMapper.dashboardList(memberId, searchDTO);
    }
}
