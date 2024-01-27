package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.HangSanXuat;

@Repository

public interface HangSanXuatRepository extends JpaRepository<HangSanXuat, Long>{

}
