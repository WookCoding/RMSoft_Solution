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
        for (int i = 0; i < 100; i++) {
            MemberVO memberVO = MemberVO.builder()
                    .memberName("임종욱" + (i + 1))
                    .memberIdentification("test" + (i+1))
                    .memberPassword(new String(Base64.getEncoder().encode(("hello"+(i+1)).getBytes())))
                    .build();

            memberMapper.insertMember(memberVO);
        }

    }

//    로그인 테스트
    @Test
    public void findByMemberIdTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("test1234")
                .memberPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .build();

        log.info("회원 번호 : " + memberMapper.selectMemberId(memberVO));
    }

//    아이디 중복검사 테스트
    @Test
    public void findByMemberIdentificationTest(){
        String memberIdentification = "test1234";

        log.info("아이디 갯수 : "  + memberMapper.findByMemberIdentification(memberIdentification));
    }

//    회원 정보 찾기
    @Test
    public void findByIdTest(){
        log.info(memberMapper.findById(1L).getMemberName());
    }

//    회원 정보 수정
    @Test
    public void updateMemberVOTest(){
        MemberVO memberVO = memberMapper.findById(1L);

        MemberVO memberVO1 = MemberVO.builder()
                .memberId(memberVO.getMemberId())
                .memberName(memberVO.getMemberName())
                .memberPassword("test12345")
                .memberEmail(memberVO.getMemberEmail())
                .memberPhoneNumber(memberVO.getMemberPhoneNumber())
                .memberIdentification(memberVO.getMemberIdentification())
                .memberCompanyName(memberVO.getMemberCompanyName())
                .memberRegisterDate(memberVO.getMemberRegisterDate())
                .build();

        memberMapper.updateMemberVO(memberVO1);
    }

}
