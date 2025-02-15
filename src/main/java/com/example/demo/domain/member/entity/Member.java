package com.example.demo.domain.member.entity;

import com.example.demo.domain.auditing.entity.BaseTimeEntity;
import com.example.demo.domain.reservation.entity.Reservation;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations = new ArrayList<>();

    public static Member of(String username, String name) {
        return Member.builder()
                .username(username)
                .name(name)
                .build();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }
}
