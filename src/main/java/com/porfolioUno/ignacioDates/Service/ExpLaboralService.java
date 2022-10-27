
package com.porfolioUno.ignacioDates.Service;

import com.porfolioUno.ignacioDates.Entity.ExpLaboral;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.porfolioUno.ignacioDates.Repository.IExpLaboralRepository;
import java.util.Optional;

@Service
@Transactional
public class ExpLaboralService {
    @Autowired
    IExpLaboralRepository iExpLaboralRepository;
    
    public List<ExpLaboral> list(){
        return iExpLaboralRepository.findAll();
    }
    
    public Optional<ExpLaboral> getOne(int id){
        return iExpLaboralRepository.findById(id);
    }
    
    public Optional<ExpLaboral> getByNombreExpLaboral(String nombreExpLaboral){
        return iExpLaboralRepository.findByNombreExpLaboral(nombreExpLaboral);
        
    }
    
    public void save(ExpLaboral expLaboral){
        iExpLaboralRepository.save(expLaboral);
    }
    
    public void delete(int id){
        iExpLaboralRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExpLaboralRepository.existsById(id);
    }
    
    public boolean existsByNombreExpLaboral(String nombreExpLaboral){
        return iExpLaboralRepository.existsByNombreExpLaboral(nombreExpLaboral);
    }
}
