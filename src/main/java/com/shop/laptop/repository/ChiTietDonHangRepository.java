package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.ChiTietDonHang;


@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Long>{
}
