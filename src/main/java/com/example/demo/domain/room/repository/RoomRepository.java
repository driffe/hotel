package com.example.demo.domain.room.repository;

import com.example.demo.domain.room.entity.Room;
import com.example.demo.domain.room.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    List<Room> findByHotelIdAndTypeAndStatus(Long hotelId, RoomType type, boolean status);
}
