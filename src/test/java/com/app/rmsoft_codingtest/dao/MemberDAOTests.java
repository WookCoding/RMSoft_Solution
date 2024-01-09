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
        MemberVO memberVO = MemberVO.builder()
                .memberName("홍길동")
                .memberIdentification("test123")
                .memberPassword(new String(Base64.getEncoder().encode("hong1234".getBytes())))
                .build();

        memberDAO.insertMember(memberVO);
    }

//    로그인
    @Test
    public void selectMemberIdTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("test123")
                .memberPassword(new String(Base64.getEncoder().encode("hong1234".getBytes())))
                .build();

        log.info("회원 번호 : " + memberDAO.findById(memberVO));
    }

}
