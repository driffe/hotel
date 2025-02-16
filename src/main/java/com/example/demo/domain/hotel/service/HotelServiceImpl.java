package com.example.demo.domain.hotel.service;

import com.example.demo.domain.hotel.dto.HotelRequestDTO;
import com.example.demo.domain.hotel.entity.Hotel;
import com.example.demo.domain.hotel.repository.HotelRepository;
import com.example.demo.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // 누락
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    @Override
    @Transactional
    public Long createHotel(HotelRequestDTO dto) {
        Hotel hotel = Hotel.of(dto);
        return hotelRepository.save(hotel).getId();
    }

    @Override
    @Transactional
    public Long updateHotel( Long hotelId, HotelRequestDTO dto) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다."));

        hotel.update(dto);
        return hotelRepository.save(hotel).getId();
    }

    @Override
    @Transactional
    public void deleteHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 호텔입니다."));

        hotelRepository.delete(hotel);
    }

    @Override
    public Optional<Hotel> getById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
