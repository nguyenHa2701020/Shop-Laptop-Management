package com.shop.laptop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.laptop.dto.GioHangDto;
import com.shop.laptop.entities.GioHang;
import com.shop.laptop.repository.GioHangRepository;
import com.shop.laptop.service.GioHangService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository mr;

	@Override
    public void deleteById(long id) {
        Optional<GioHang> optionalMe = mr.findById(id);
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
    public List<GioHang> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<GioHang> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public GioHang save(GioHangDto medi) {
        GioHang med = new GioHang(medi.getTong_tien());
    return mr.save(med);
    }

    @Override
    public void update(long id, GioHangDto medi) {
       GioHang cine= new GioHang();
       cine.setId(id);
       cine.setTong_tien(medi.getTong_tien());
       Optional<GioHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateName(long id, String name) {
       Optional<GioHang> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        GioHang cine=optionalMe.get();
        cine.setId(id);
        cine.setTong_tien(name);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    
}
