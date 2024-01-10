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

//    아이디 중복검사
    public Long findByMemberIdentification (String memberIdentification){ return memberMapper.findByMemberIdentification(memberIdentification); }

//    회원 정보 찾기
    public MemberVO findById(Long memberId){return memberMapper.findById(memberId); }
}
