package com.app.rmsoft_codingtest.dao;

import com.app.rmsoft_codingtest.domain.dao.MemberDAO;
import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;
import java.util.Base64;

@SpringBootTest
@Slf4j
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

//    회원가입
    @Test
    public void insertMemberTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("홍길동");
        memberVO.setMemberIdentification("test123");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("hong1234".getBytes())));
        memberDAO.insertMember(memberVO);
    }

//    로그인
    @Test
    public void selectMemberIdTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberIdentification("test123");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("hong1234".getBytes())));

        log.info("회원 번호 : " + memberDAO.selectMemberId(memberVO));
    }

}
