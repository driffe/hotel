package com.example.demo.domain.hotel.repository;

import com.example.demo.domain.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepository extends JpaRepository<Hotel, Long> {  // extends가 아닌 implements 사용
    List<Hotel> findByName(String name);
}
