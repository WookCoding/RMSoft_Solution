package com.app.rmsoft_codingtest.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    private Long memberId;
    private String memberIdentification;
    private String memberPassword;
    private String memberName;
    private Date memberRegisterDate;
    private Date memberUpdateDate;
}
