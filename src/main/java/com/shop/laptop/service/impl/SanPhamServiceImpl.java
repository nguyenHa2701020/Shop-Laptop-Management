package com.shop.laptop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.laptop.dto.SanPhamDto;
import com.shop.laptop.entities.SanPham;

import com.shop.laptop.repository.SanPhamRepository;
import com.shop.laptop.service.SanPhamService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamRepository mr;

	@Override
    public void deleteById(long id) {
        Optional<SanPham> optionalMe = mr.findById(id);
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
    public List<SanPham> findAll() {
       return mr.findAll();
    }

    @Override
    public Optional<SanPham> findById(Long id) {
        return mr.findById(id);
    }

    @Override
    public SanPham save(SanPhamDto medi) {
        SanPham med = new SanPham(medi.getTenSanPham(), medi.getDonGia(), medi.getDonViKho(), medi.getDonViBan(),medi.getThongTinBaoHanh(), medi.getThongTinChung(),medi.getManHinh(), medi.getHeDieuHanh(), medi.getCpu(),medi.getRam(), medi.getThietKe(), medi.getDungLuongPin(),medi.getHinhAnh(), medi.getDanhMuc(), medi.getHangSanXuat());
    return mr.save(med);
    }

    @Override
    public void update(long id, SanPhamDto medi) {
       SanPham cine= new SanPham();
       cine.setId(id);
       cine.setTenSanPham(medi.getTenSanPham());
       cine.setDonGia(medi.getDonGia());
       cine.setDonViBan(medi.getDonViBan());
       cine.setThongTinBaoHanh(medi.getThongTinBaoHanh());
       cine.setThongTinChung(medi.getThongTinChung());
       cine.setManHinh(medi.getManHinh());
	   cine.setHeDieuHanh(medi.getHeDieuHanh());
       cine.setCpu(medi.getCpu());
       cine.setRam(medi.getRam());
       cine.setThietKe(medi.getThietKe());
       cine.setDungLuongPin(medi.getDungLuongPin());
       Optional<SanPham> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {      
         mr.save(cine);
       }
       else {
        throw new EntityNotFoundException();
      } 

        
    }

    @Override
    public void updateName(long id, String name) {
       Optional<SanPham> optionalMe = mr.findById(id);
       if (optionalMe.isPresent()) {   
        SanPham cine=optionalMe.get();
        cine.setId(id);
        cine.setTenSanPham(name);
         mr.save(cine);
       }
       else {
       throw new EntityNotFoundException();
      } 

    }
    
}
