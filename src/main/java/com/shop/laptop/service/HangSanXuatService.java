package com.shop.laptop.service;

import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.HangSXDto;
import com.shop.laptop.entities.HangSanXuat;


public interface HangSanXuatService {
	List<HangSanXuat> findAll();

    Optional<HangSanXuat> findById(Long id);
  
    HangSanXuat save(HangSXDto HangSanXuat);
  
    void update(long id, HangSXDto HangSanXuat);
  
    void updateName(long id, String name);
  
    void deleteById(long id);
}
