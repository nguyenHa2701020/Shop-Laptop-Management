package com.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.laptop.entities.DanhMuc;


@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Long>{

}
