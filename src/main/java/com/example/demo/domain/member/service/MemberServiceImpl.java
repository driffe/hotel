package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.MemberResponseDto;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Long register(String username, String name, String password) {
        Member member = Member.of(username, name, password);
        return memberRepository.save(member).getId();
    }

    @Override
    public Member login(String username, String name, String password) {
        return null;
    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public List<MemberResponseDto> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponseDto::of)
                .collect(Collectors.toList());
    }
}
