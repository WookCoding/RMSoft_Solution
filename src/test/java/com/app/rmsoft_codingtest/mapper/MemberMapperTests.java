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
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("임종욱");
        memberVO.setMemberIdentification("test1234");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("hello".getBytes())));
        memberMapper.insertMember(memberVO);
    }

//    로그인 테스트
    @Test
    public void selectMemberTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberIdentification("test1234");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("hello".getBytes())));
        log.info("회원 번호 : " + memberMapper.selectMember(memberVO));
    }

}
