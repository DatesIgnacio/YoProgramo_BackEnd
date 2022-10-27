
package com.porfolioUno.ignacioDates.Service;

import com.porfolioUno.ignacioDates.Entity.Educacion;
import com.porfolioUno.ignacioDates.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEducacion(String nombreEducacion){
        return iEducacionRepository.findByNombreEducacion(nombreEducacion);
    }
    
    public void save(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
    
    public void delete(int id){
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByNombreEducacion(String nombreEducacion){
        return iEducacionRepository.existsByNombreEducacion(nombreEducacion);
    }
}