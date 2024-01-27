package com.shop.laptop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.laptop.dto.DanhMucDto;
import com.shop.laptop.entities.DanhMuc;
import com.shop.laptop.repository.DanhMucRepository;
import com.shop.laptop.service.DanhMucService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DanhMucServiceImpl implements DanhMucService {

	@Autowired
	private DanhMucRepository mr;

	@Override
    public void deleteById(long id) {
        Optional<DanhMuc> optionalMe = mr.findById(id);
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
    public List<DanhMuc> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<DanhMuc> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public DanhMuc save(DanhMucDto medi) {
        DanhMuc med = new DanhMuc(medi.getTenDanhMuc(), medi.getListSanPham());
    return mr.save(med);
    }

    @Override
    public void update(long id, DanhMucDto medi) {
       DanhMuc cine= new DanhMuc();
       cine.setId(id);
       cine.setTenDanhMuc(medi.getTenDanhMuc());
       cine.setListSanPham(medi.getListSanPham());
     
       Optional<DanhMuc> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateName(long id, String name) {
       Optional<DanhMuc> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        DanhMuc cine=optionalMe.get();
        cine.setId(id);
        cine.setTenDanhMuc(name);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    

}
