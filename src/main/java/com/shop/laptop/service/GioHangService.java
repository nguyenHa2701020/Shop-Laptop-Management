package com.shop.laptop.service;

import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.GioHangDto;
import com.shop.laptop.entities.GioHang;

public interface GioHangService {
	List<GioHang> findAll();

    Optional<GioHang> findById(Long id);
  
    GioHang save(GioHangDto GioHang);
  
    void update(long id, GioHangDto GioHang);
  
    void updateName(long id, String name);
  
    void deleteById(long id);
}
