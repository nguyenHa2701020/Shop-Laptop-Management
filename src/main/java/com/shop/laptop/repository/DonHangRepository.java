package com.shop.laptop.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.DonHang;



@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long> {


}
