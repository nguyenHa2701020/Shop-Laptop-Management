package com.shop.laptop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.laptop.dto.HangSXDto;
import com.shop.laptop.entities.HangSanXuat;

import com.shop.laptop.repository.HangSanXuatRepository;
import com.shop.laptop.service.HangSanXuatService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class HangSanXuatServiceImpl implements HangSanXuatService {

	@Autowired
	private HangSanXuatRepository mr;

@Override
    public void deleteById(long id) {
        Optional<HangSanXuat> optionalMe = mr.findById(id);
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
    public List<HangSanXuat> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<HangSanXuat> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public HangSanXuat save(HangSXDto medi) {
        HangSanXuat med = new HangSanXuat(medi.getTenHangSanXuat(), medi.getListSanPham());
    return mr.save(med);
    }

    @Override
    public void update(long id, HangSXDto medi) {
       HangSanXuat cine= new HangSanXuat();
       cine.setId(id);
       cine.setTenHangSanXuat(medi.getTenHangSanXuat());
       cine.setListSanPham(medi.getListSanPham());
      
       Optional<HangSanXuat> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateName(long id, String name) {
       Optional<HangSanXuat> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        HangSanXuat cine=optionalMe.get();
        cine.setId(id);
        cine.setTenHangSanXuat(name);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    

	

}
