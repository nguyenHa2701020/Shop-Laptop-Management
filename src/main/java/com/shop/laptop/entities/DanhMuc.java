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
public class DanhMuc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="Tên danh mục không được trống")
	private String tenDanhMuc;

	@JsonIgnore
	@OneToMany(mappedBy = "danhMuc")
	private List<SanPham> listSanPham;
	
//	public DanhMuc(long id, String tenDanhMuc) {
//		this.id = id;
//		this.tenDanhMuc = tenDanhMuc;
//	}
	

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
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

	public DanhMuc(@NotEmpty(message = "Tên danh mục không được trống") String tenDanhMuc, List<SanPham> listSanPham) {
		this.tenDanhMuc = tenDanhMuc;
		this.listSanPham = listSanPham;
	}

	public DanhMuc() {
	}

	
}
