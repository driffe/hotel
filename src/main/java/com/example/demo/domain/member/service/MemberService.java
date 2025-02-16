package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.MemberResponseDto;
import com.example.demo.domain.member.entity.Member;

import java.util.List;

public interface MemberService {
    Long register(String username, String name, String password);
    Member login(String username, String name, String password);
    Member findByUsername(String username);

    List<MemberResponseDto> getAllMembers();
}
