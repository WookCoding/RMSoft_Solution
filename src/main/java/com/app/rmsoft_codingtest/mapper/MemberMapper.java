package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 회원 가입
    public void insertMember(MemberVO memberVO);

    // 로그인
    public Long selectMemberId(MemberVO memberVO);

    // 아이디 중복검사
    public Long findByMemberIdentification(String memberIdentification);

    // 회원 정보 찾기
    public MemberVO findById(Long memberId);

    // 회원정보 수정
    public void updateMemberVO(MemberVO memberVO);
}
