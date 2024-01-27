package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.ChiMucGioHang;

@Repository

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long> {

	// ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);

	// List<ChiMucGioHang> findByGioHang(GioHang g);
}
