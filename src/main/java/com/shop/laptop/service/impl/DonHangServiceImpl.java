package com.shop.laptop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.laptop.dto.DonHangDto;
import com.shop.laptop.entities.DonHang;
import com.shop.laptop.repository.DonHangRepository;
import com.shop.laptop.service.DonHangService;

import jakarta.persistence.EntityNotFoundException;



@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	private DonHangRepository mr;

	

@Override
    public void deleteById(long id) {
        Optional<DonHang> optionalMe = mr.findById(id);
        if (optionalMe.isPresent()) {      
          mr.delete(optionalMe.get());
        } else {
          try {
            throw new Exception("Can't delete it!");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        } 
        
    }

    @Override
    public List<DonHang> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<DonHang> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public DonHang save(DonHangDto medi) {
        DonHang med = new DonHang(medi.getDanhSachChiTiet(), medi.getDiaChiNhan(), medi.getSdtNhanHang(), medi.getHoTenNguoiNhan(),medi.getNgayDatHang(), medi.getNgayGiaoHang(),medi.getNgayNhanHang(),medi.getTrangThaiDonHang(),medi.getGhiChu(),medi.getTongGiaTri());
    return mr.save(med);
    }

    @Override
    public void update(long id, DonHangDto medi) {
       DonHang cine= new DonHang();
       cine.setId(id);
       cine.setDanhSachChiTiet(medi.getDanhSachChiTiet());
       cine.setDiaChiNhan(medi.getDiaChiNhan());
       cine.setHoTenNguoiNhan(medi.getHoTenNguoiNhan());
       cine.setNgayDatHang(medi.getNgayDatHang());
       cine.setNgayGiaoHang(medi.getNgayGiaoHang());
       cine.setNgayNhanHang(medi.getNgayNhanHang());
	   cine.setTrangThaiDonHang(medi.getTrangThaiDonHang());
       cine.setGhiChu(medi.getGhiChu());
       cine.setTongGiaTri(medi.getTongGiaTri());
       Optional<DonHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateName(long id, String name) {
       Optional<DonHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        DonHang cine=optionalMe.get();
        cine.setId(id);
        cine.setGhiChu(name);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    

	
}
