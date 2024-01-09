package com.app.rmsoft_codingtest.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@Builder
@ToString
public class MemberVO {
    private Long memberId;
    private String memberIdentification;
    private String memberPassword;
    private String memberName;
    private String memberCompanyName;
    private String memberEmail;
    private String phoneNumber;
    private Date memberRegisterDate;
    private Date memberUpdateDate;

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
}
