
package com.portfolioweb.argentinaprograma.Service;

import com.portfolioweb.argentinaprograma.Entity.ExperienciaLaboral;
import com.portfolioweb.argentinaprograma.Repository.ExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceExperienciaLaboral {
    
    @Autowired
    ExperienciaLaboralRepository experienciaLaboralRepository ;
    
    public List <ExperienciaLaboral> list(){
        return experienciaLaboralRepository.findAll();
        
    }
    
    public Optional <ExperienciaLaboral> getOne(int id){
        return experienciaLaboralRepository.findById(id);
    }
    
    public Optional <ExperienciaLaboral> getByNombreExpe(String nombreExpe){
        return experienciaLaboralRepository.findByNombreExpe(nombreExpe);
    }
    
    public void save(ExperienciaLaboral exp){
        experienciaLaboralRepository.save(exp);
        
    }
    
       public void delete(int id){
        experienciaLaboralRepository.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return experienciaLaboralRepository.existsById(id);
       }
    
    public boolean existsByNombreExpe(String nombreExpe){
           return experienciaLaboralRepository.existsByNombreExpe(nombreExpe);
       }
    
}
