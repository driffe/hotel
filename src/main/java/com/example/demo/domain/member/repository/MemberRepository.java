package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByUsername(String username);
}
