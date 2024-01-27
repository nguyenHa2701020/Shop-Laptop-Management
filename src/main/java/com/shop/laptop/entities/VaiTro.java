package com.shop.laptop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VaiTro {

	@Id
	@GeneratedValue
	private long id;

	private String tenVaiTro;

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public VaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public VaiTro() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
