package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.GioHang;


@Repository

public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	
}
