package com.example.demo.domain.member.dto;

import com.example.demo.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String username;
    private String name;

    @Builder
    private MemberResponseDto(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .name(member.getName())
                .build();
    }
}
