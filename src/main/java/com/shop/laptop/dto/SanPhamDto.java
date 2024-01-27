package com.shop.laptop.dto;


import org.springframework.web.multipart.MultipartFile;

import com.shop.laptop.entities.DanhMuc;
import com.shop.laptop.entities.HangSanXuat;

import lombok.Data;
@Data
public class SanPhamDto {

	private long id;

	private String tenSanPham;
	private long donGia;
	private int donViKho;
	private int donViBan;
	private String thongTinBaoHanh;
	private String thongTinChung;
	private String manHinh;
	private String heDieuHanh;
	private String cpu;
	private String ram;
	private String thietKe;
	private String dungLuongPin;

	private DanhMuc danhMuc;
	private HangSanXuat hangSanXuat;
	
	private MultipartFile hinhAnh;

	

	
}
