package com.app.rmsoft_codingtest.controller;

import com.app.rmsoft_codingtest.domain.dto.SubscribeDTO;
import com.app.rmsoft_codingtest.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribe/*")
public class SubscribeRestController {

    private final SubscribeService subscribeService;

    @PostMapping("subscribeApply")
    public void subscribeApply(@RequestBody SubscribeDTO subscribeDTO){
        subscribeService.subscribeApply(subscribeDTO);
    }
}
