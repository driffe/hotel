package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Transactional
    @Override
    public Long userRegister(String name) {
        Member member = Member.of();
        return memberRepository.save(member).getId();
    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
