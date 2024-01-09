package com.app.rmsoft_codingtest.mapper;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

//    회원가입 테스트
    @Test
    public void insertMemberTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberName("임종욱")
                .memberIdentification("test1234")
                .memberPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .build();

        memberMapper.insertMember(memberVO);
    }

//    로그인 테스트
    @Test
    public void findByMemberIdTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("test1234")
                .memberPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .build();

        log.info("회원 번호 : " + memberMapper.findById(memberVO));
    }

//    아이디 중복검사 테스트
    @Test
    public void findByMemberIdentificationTest(){
        String memberIdentification = "test1234";

        log.info("아이디 갯수 : "  + memberMapper.findByMemberIdentification(memberIdentification));
    }

}
