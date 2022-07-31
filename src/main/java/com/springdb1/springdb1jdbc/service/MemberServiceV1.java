package com.springdb1.springdb1jdbc.service;

import com.springdb1.springdb1jdbc.domain.Member;
import com.springdb1.springdb1jdbc.repository.MemberRepositoryV1;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findByid(fromId);
        Member toMember = memberRepository.findByid(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);

    }

    private void validation(Member toMember) {
        if( toMember.getMemberId().equals("ex") ) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
