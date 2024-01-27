package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.NguoiDung;



@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{


}
