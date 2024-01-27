package com.shop.laptop.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.laptop.dto.ChiTietDonHangDto;
import com.shop.laptop.entities.ChiTietDonHang;
import com.shop.laptop.repository.ChiTietDonHangRepository;
import com.shop.laptop.service.ChiTietDonHangService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	
	@Autowired
	private ChiTietDonHangRepository mr;
	
	@Override
    public void deleteById(long id) {
        Optional<ChiTietDonHang> optionalMe = mr.findById(id);
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
    public List<ChiTietDonHang> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<ChiTietDonHang> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public ChiTietDonHang save(ChiTietDonHangDto medi) {
        ChiTietDonHang med = new ChiTietDonHang(medi.getSanPham(), medi.getDonGia(), medi.getSoLuongDat(), medi.getSoLuongNhanHang(),medi.getDonHang());
    return mr.save(med);
    }

    @Override
    public void update(long id, ChiTietDonHangDto medi) {
       ChiTietDonHang cine= new ChiTietDonHang();
       cine.setId(id);
       cine.setSanPham(medi.getSanPham());
       cine.setDonGia(medi.getDonGia());
       cine.setSoLuongDat(medi.getSoLuongDat());
       cine.setSoLuongNhanHang(medi.getSoLuongNhanHang());
       cine.setDonGia(medi.getDonGia());
       
       Optional<ChiTietDonHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateSL(long id, int sl) {
       Optional<ChiTietDonHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        ChiTietDonHang cine=optionalMe.get();
        cine.setId(id);
        cine.setSoLuongDat(sl);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    
}
