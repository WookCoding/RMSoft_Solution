package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.MemberDAO;
import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.insertMember(memberVO);
    }

    @Override
    public Long login(MemberVO memberVO) {
        return memberDAO.selectMemberId(memberVO);
    }
}
