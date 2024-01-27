package com.shop.laptop.service;

import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.ChiTietDonHangDto;
import com.shop.laptop.entities.ChiTietDonHang;

public interface ChiTietDonHangService {
	List<ChiTietDonHang> findAll();

    Optional<ChiTietDonHang> findById(Long id);
  
    ChiTietDonHang save(ChiTietDonHangDto ChiTietDonHang);
  
    void update(long id, ChiTietDonHangDto ChiTietDonHang);
  
    void updateSL(long id, int sl);
  
    void deleteById(long id);
}
