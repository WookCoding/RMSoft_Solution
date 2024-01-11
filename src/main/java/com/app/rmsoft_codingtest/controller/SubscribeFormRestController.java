package com.app.rmsoft_codingtest.controller;

import com.app.rmsoft_codingtest.domain.vo.SubscribeFormVO;
import com.app.rmsoft_codingtest.service.SubscribeFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribeForm/*")
public class SubscribeFormRestController {

    private final SubscribeFormService subscribeFormService;

//    구독 버전 추가
    @PostMapping("insertForm")
    public void insertForm(@RequestBody SubscribeFormVO subscribeFormVO){
        subscribeFormService.insertForm(subscribeFormVO);
    }

    //    구독 버전 목록
    @GetMapping("findAllForm")
    public List<SubscribeFormVO> findAllForm(){
        return subscribeFormService.findAllForm();
    }

    //    구독 버전 찾기
    @GetMapping("findForm")
    public SubscribeFormVO findForm(@RequestParam Long subscribeFormId){
        return subscribeFormService.findForm(subscribeFormId);
    }

    //    구독 버전 수정
    @PutMapping("updateForm")
    public void updateForm(@RequestBody SubscribeFormVO subscribeFormVO){
        subscribeFormService.updateForm(subscribeFormVO);
    }

    //    구독 버전 삭제
    @DeleteMapping("deleteForm")
    public void deleteForm(@RequestParam Long subscribeFormId){
        subscribeFormService.deleteForm(subscribeFormId);
    }

}
