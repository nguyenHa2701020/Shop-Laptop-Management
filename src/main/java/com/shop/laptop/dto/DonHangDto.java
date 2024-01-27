package com.shop.laptop.dto;

import java.util.Date;
import java.util.List;

import com.shop.laptop.entities.ChiTietDonHang;

import lombok.Data;

@Data
public class DonHangDto {
	private String diaChiNhan;
	private String sdtNhanHang;
	private String hoTenNguoiNhan;

	private Date ngayDatHang;

	private Date ngayGiaoHang;

	private Date ngayNhanHang;

	private String trangThaiDonHang;
	private String ghiChu;

	private long tongGiaTri;

	private List<ChiTietDonHang> danhSachChiTiet;
}
