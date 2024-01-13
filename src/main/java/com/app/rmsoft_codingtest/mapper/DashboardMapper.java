package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.dto.DashboardDTO;
import com.app.rmsoft_codingtest.domain.dto.SearchDTO;
import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.domain.vo.DashboardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DashboardMapper {

//    dashboard insert
    public void insert(DashboardVO dashboardVO);

//    dashboard find
    public Long dashboardCheck(Long subscribeId);

//    dashboardVO
    public DashboardVO findBySubscribeId(Long subscribeId);

//    update
    public void updateBySubscribeId(DashboardVO dashboardVO);

//    list
    public List<DashboardDTO> dashboardList(@Param("memberId")Long memberId, @Param("searchDTO") SearchDTO searchDTO);
}
