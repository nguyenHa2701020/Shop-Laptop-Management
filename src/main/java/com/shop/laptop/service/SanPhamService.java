package com.shop.laptop.service;

import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.SanPhamDto;

import com.shop.laptop.entities.SanPham;

public interface SanPhamService {
	List<SanPham> findAll();

    Optional<SanPham> findById(Long id);
  
    SanPham save(SanPhamDto SanPham);
  
    void update(long id, SanPhamDto SanPham);
  
    void updateName(long id, String name);
  
    void deleteById(long id);
}
