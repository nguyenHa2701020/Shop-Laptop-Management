package com.shop.laptop.dto;


import com.shop.laptop.entities.DonHang;
import com.shop.laptop.entities.SanPham;

import lombok.Data;
@Data
public class ChiTietDonHangDto {
	private SanPham sanPham;
	private long donGia;
	private int soLuongDat;
	
	private int soLuongNhanHang;

	private DonHang donHang;
}
