package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;

public interface MemberService {
    Long register(Member member);
    Member login(String username, String password);
    Member findByUsername(String username);
}
