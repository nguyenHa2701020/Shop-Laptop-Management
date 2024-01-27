package com.shop.laptop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.SanPham;


@Repository

public interface SanPhamRepository extends JpaRepository<SanPham, Long>{

	
}
