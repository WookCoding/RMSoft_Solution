package com.app.rmsoft_codingtest.service;

import com.app.rmsoft_codingtest.domain.dao.MemberDAO;
import com.app.rmsoft_codingtest.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    @Transactional // 회원가입 시에 오류 발생 시 롤백 위해서
    public void join(MemberVO memberVO) {
        MemberVO member = MemberVO.builder()
                .memberName(memberVO.getMemberName())
                .memberIdentification(memberVO.getMemberIdentification())
                .memberPassword(new String(Base64.getEncoder().encode(memberVO.getMemberPassword().getBytes())))
                .build();

        memberDAO.insertMember(member);
    }

    @Override
    public Long login(MemberVO memberVO) {
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode(memberVO.getMemberPassword().getBytes())));
        return memberDAO.findById(memberVO);
    }

    @Override
    public Long idCheck(String memberIdentification) {
        return memberDAO.findByMemberIdentification(memberIdentification);
    }

}
