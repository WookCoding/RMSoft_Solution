package com.app.rmsoft_codingtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("login")
    public void login(){;}

    @GetMapping("join")
    public void join(){;}

}
