package com.app.rmsoft_codingtest.controller;

import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import com.app.rmsoft_codingtest.service.MemberService;
import com.app.rmsoft_codingtest.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberRestController {

    private final MemberService memberService;

    //  회원 가입
    @PostMapping("join")
    public void join(@RequestBody MemberVO memberVO) {
        memberService.join(memberVO);
    }

    //    로그인
    @GetMapping("login")
    public Long login(@RequestBody MemberVO memberVO) {
        return memberService.login(memberVO);
    }

    //    아이디 중복 검사
    @GetMapping("idCheck")
    public Boolean idCheck(@RequestParam String memberIdentification) {
        return memberService.idCheck(memberIdentification) == 0;
    }
}
