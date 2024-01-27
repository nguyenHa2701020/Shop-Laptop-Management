package com.shop.laptop.entities;



import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "san pham")
@Table(name = "san pham")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Transient
	@JsonIgnore
	private MultipartFile hinhAnh;

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc")
	private DanhMuc danhMuc;

	@ManyToOne
	@JoinColumn(name = "ma_hang_sx")
	private HangSanXuat hangSanXuat;

	public SanPham(String tenSanPham, long donGia, int donViKho, int donViBan, String thongTinBaoHanh,
			String thongTinChung, String manHinh, String heDieuHanh, String cpu, String ram, String thietKe,
			String dungLuongPin, MultipartFile hinhAnh, DanhMuc danhMuc, HangSanXuat hangSanXuat) {
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.donViKho = donViKho;
		this.donViBan = donViBan;
		this.thongTinBaoHanh = thongTinBaoHanh;
		this.thongTinChung = thongTinChung;
		this.manHinh = manHinh;
		this.heDieuHanh = heDieuHanh;
		this.cpu = cpu;
		this.ram = ram;
		this.thietKe = thietKe;
		this.dungLuongPin = dungLuongPin;
		this.hinhAnh = hinhAnh;
		this.danhMuc = danhMuc;
		this.hangSanXuat = hangSanXuat;
	}

	
}
