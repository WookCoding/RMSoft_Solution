package com.app.rmsoft_codingtest.domain.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SearchDTO {

    private String subscribeFormType;

    public void setSubscribeFormType(String subscribeFormType) {
        this.subscribeFormType = subscribeFormType;
    }
}
