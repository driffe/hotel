package com.example.demo.domain.hotel.service;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.repository.HotelRepository;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service  // 누락
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long createHotel(String username, HotelRequestDTO dto) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Hotel hotel = Hotel.of(dto);
        return hotelRepository.save(hotel).getId();
    }

    @Override
    @Transactional
    public Long updateHotel(String username, Long hotelId, HotelRequestDTO dto) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다."));

        hotel.update(dto);
        return hotelRepository.save(hotel).getId();
    }

    @Override
    @Transactional
    public void deleteHotel(String username, Long hotelId) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다."));

        hotelRepository.delete(hotel);
    }

    @Override
    public Optional<Hotel> getById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }
}
