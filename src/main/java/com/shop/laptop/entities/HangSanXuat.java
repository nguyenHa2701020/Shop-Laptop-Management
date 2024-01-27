package com.shop.laptop.entities;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class HangSanXuat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty(message="Tên hãng sản xuất không được trống")
	private String tenHangSanXuat;

	@JsonIgnore
	@OneToMany(mappedBy = "hangSanXuat")
	private List<SanPham> listSanPham;

	public String getTenHangSanXuat() {
		return tenHangSanXuat;
	}

	public void setTenHangSanXuat(String tenHangSanXuat) {
		this.tenHangSanXuat = tenHangSanXuat;
	}

	public List<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public HangSanXuat(@NotEmpty(message = "Tên hãng sản xuất không được trống") String tenHangSanXuat,
			List<SanPham> listSanPham) {
		this.tenHangSanXuat = tenHangSanXuat;
		this.listSanPham = listSanPham;
	}

	public HangSanXuat() {
	}
}
