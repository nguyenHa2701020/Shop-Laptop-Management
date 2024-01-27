package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.VaiTro;


@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	
}
