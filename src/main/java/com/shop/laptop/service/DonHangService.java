package com.shop.laptop.service;

import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.DonHangDto;
import com.shop.laptop.entities.DonHang;

public interface DonHangService {

	List<DonHang> findAll();

    Optional<DonHang> findById(Long id);
  
    DonHang save(DonHangDto DonHang);
  
    void update(long id, DonHangDto DonHang);
  
    void updateName(long id, String name);
  
    void deleteById(long id);

}
