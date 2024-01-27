package com.shop.laptop.dto;

import java.util.List;

import com.shop.laptop.entities.SanPham;

import lombok.Data;

@Data
public class DanhMucDto {
    private String tenDanhMuc;
    private List<SanPham> listSanPham;
}
