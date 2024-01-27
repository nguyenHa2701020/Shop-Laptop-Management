package com.shop.laptop.api.admin;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.shop.laptop.dto.SanPhamDto;
import com.shop.laptop.entities.SanPham;
import com.shop.laptop.service.SanPhamService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/san-pham")
public class SanPhamApi {
	@Autowired
	private SanPhamService im;

	@GetMapping("/all")
	public ResponseEntity<List<SanPham>> findAllSanPham() {
		return ResponseEntity.ok(im.findAll());
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<SanPham> findSanPhamById(@PathVariable long id) {
		Optional<SanPham> m = im.findById(id);
		if (m.isPresent()) {
			return ResponseEntity.ok(m.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}

	}

	@PostMapping("/add")
	public ResponseEntity<SanPham> addSanPham(@RequestBody SanPhamDto SanPham) {
		SanPham mcd = im.save(SanPham);
		try {
			return ResponseEntity.created(new URI("/api/SanPham/add/" + mcd.getId())).body(mcd);

		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/all/{id}")
	public ResponseEntity<Void> updateSanPham(@RequestBody SanPhamDto SanPham, @PathVariable long id) {
		try {
			im.update(id, SanPham);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/all/{id}")
	public ResponseEntity<Void> updateSanPhamName(@RequestBody String nameString, @PathVariable long id) {
		try {
			im.updateName(id, nameString);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/all/{id}")
	public ResponseEntity<Void> deleteMeById(@PathVariable long id) {
		try {
			im.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}
