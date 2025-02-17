package com.example.demo.global.initial;

import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.repository.HotelRepository;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.room.entity.Room;
import com.example.demo.domain.room.entity.RoomType;
import com.example.demo.domain.room.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final MemberRepository memberRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @PostConstruct
    public void setup() {
        Member member1 = Member.builder()
                .username("user1")
                .password("password1")
                .name("User One")
                .build();

        Member member2 = Member.builder()
                .username("user2")
                .password("password2")
                .name("User Two")
                .build();

        memberRepository.saveAll(Arrays.asList(member1, member2));

        Hotel hotel1 = Hotel.builder()
                .name("Grand Hotel")
                .address("SF, CA")
                .description("5Star luxury")
                .hotelKey("hotel01")
                .build();

        Hotel hotel2 = Hotel.builder()
                .name("City Hotel")
                .address("SJ, CA")
                .description("Business Hotel")
                .hotelKey("hotel02")
                .build();

        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);

        // 룸 생성
        Room room1 = Room.builder()
                .hotel(hotel1)
                .type(RoomType.SINGLE)
                .price(100000)
                .status(true)
                .build();

        Room room2 = Room.builder()
                .hotel(hotel1)
                .type(RoomType.DOUBLE)
                .price(150000)
                .status(true)
                .build();

        Room room3 = Room.builder()
                .hotel(hotel1)
                .type(RoomType.DELUXE)
                .price(200000)
                .status(true)
                .build();

        Room room4 = Room.builder()
                .hotel(hotel2)
                .type(RoomType.SINGLE)
                .price(80000)
                .status(true)
                .build();

        Room room5 = Room.builder()
                .hotel(hotel2)
                .type(RoomType.DOUBLE)
                .price(120000)
                .status(true)
                .build();

        Room room6 = Room.builder()
                .hotel(hotel2)
                .type(RoomType.DELUXE)
                .price(180000)
                .status(true)
                .build();

        roomRepository.saveAll(Arrays.asList(room1, room2, room3, room4, room5, room6));
    }
}
