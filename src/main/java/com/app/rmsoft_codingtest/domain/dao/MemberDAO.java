package com.app.rmsoft_codingtest.domain.dao;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import com.app.rmsoft_codingtest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

//    회원가입
    public void insertMember(MemberVO memberVO){
        memberMapper.insertMember(memberVO);
    }

//    로그인
    public Long selectMemberId(MemberVO memberVO){
        return memberMapper.selectMemberId(memberVO);
    }

}
