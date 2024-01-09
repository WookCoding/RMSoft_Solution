package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;

public interface MemberService {

    // 회원 가입
    public void join(MemberVO memberVO);

    // 로그인
    public Long login(MemberVO memberVO);
}
