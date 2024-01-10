package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.MemberDAO;
import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class MemberServiceImplTest {

    @Mock
    MemberDAO memberDAO;

    @InjectMocks
    private MemberServiceImpl memberServiceImpl;

    @BeforeEach
    public void setUp() {
        reset(memberDAO);
    }

    public MemberVO setUpMemberVO(){
        return MemberVO.builder()
                .memberName("임종욱")
                .memberIdentification("test1234")
                .memberPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .build();
    }

    // 회원가입
    @Test
    @DisplayName("회원가입 테스트")
    public void joinTest(){
        MemberVO memberVO = setUpMemberVO();
        memberServiceImpl.join(memberVO);
        verify(memberDAO, times(1)).insertMember(memberVO);
    }

    // 로그인
    @Test
    @DisplayName("로그인 테스트 - 성공")
    public void loginTest(){
        MemberVO memberVO = setUpMemberVO();

        when(memberServiceImpl.login(memberVO)).thenReturn(1L);
        Long memberId = memberServiceImpl.login(memberVO);
        assertEquals(1L,memberId);
        verify(memberDAO, times(1)).selectMemberId(memberVO);
    }

}
