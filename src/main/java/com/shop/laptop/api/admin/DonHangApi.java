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

import com.shop.laptop.dto.DonHangDto;

import com.shop.laptop.entities.DonHang;

import com.shop.laptop.service.DonHangService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/don-hang")
public class DonHangApi {
	@Autowired
	private DonHangService im;

	@GetMapping("/all")
	public ResponseEntity<List<DonHang>> findAllDonHang() {
		return ResponseEntity.ok(im.findAll());
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<DonHang> findDonHangById(@PathVariable long id) {
		Optional<DonHang> m = im.findById(id);
		if (m.isPresent()) {
			return ResponseEntity.ok(m.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}

	}

	@PostMapping("/add")
	public ResponseEntity<DonHang> addDonHang(@RequestBody DonHangDto DonHang) {
		DonHang mcd = im.save(DonHang);
		try {
			return ResponseEntity.created(new URI("/api/DonHang/add/" + mcd.getId())).body(mcd);

		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/all/{id}")
	public ResponseEntity<Void> updateDonHang(@RequestBody DonHangDto DonHang, @PathVariable long id) {
		try {
			im.update(id, DonHang);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/all/{id}")
	public ResponseEntity<Void> updateDonHangName(@RequestBody String nameString, @PathVariable long id) {
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
