/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioUno.ignacioDates.Service;

import com.porfolioUno.ignacioDates.Entity.Hys;
import com.porfolioUno.ignacioDates.Repository.IHysRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class HysService {
    @Autowired
    IHysRepository iHysRepository;
    
    public List<Hys> list(){
        return iHysRepository.findAll();
    }
    
    public Optional<Hys> getOne(int id){
        return iHysRepository.findById(id);
    }
    
    public Optional<Hys> getByNombre(String nombre){
        return iHysRepository.findByNombre(nombre);
        
    }
    
    public void save(Hys hys){
        iHysRepository.save(hys);
    }
    
    public void delete(int id){
        iHysRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iHysRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iHysRepository.existsByNombre(nombre);
    } 

 
}

