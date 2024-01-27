package com.shop.laptop.service;
import java.util.List;
import java.util.Optional;

import com.shop.laptop.dto.DanhMucDto;
import com.shop.laptop.entities.DanhMuc;


public interface DanhMucService {

	List<DanhMuc> findAll();

    Optional<DanhMuc> findById(Long id);
  
    DanhMuc save(DanhMucDto DanhMuc);
  
    void update(long id, DanhMucDto DanhMuc);
  
    void updateName(long id, String name);
  
    void deleteById(long id);
 }
