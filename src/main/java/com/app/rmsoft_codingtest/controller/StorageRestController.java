package com.app.rmsoft_codingtest.controller;

import com.app.rmsoft_codingtest.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/*")
public class StorageRestController {

    private final StorageService storageService;


}
