package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 회원 가입
    public void insertMember(MemberVO memberVO);

    // 로그인
    public Long findById(MemberVO memberVO);

    // 아이디 중복검사
    public Long findByMemberIdentification(String memberIdentification);
}
