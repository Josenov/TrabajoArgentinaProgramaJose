
package com.portfolioweb.argentinaprograma.Service;

import com.portfolioweb.argentinaprograma.Entity.Skills;
import com.portfolioweb.argentinaprograma.Repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceSkills {
    
    @Autowired
  SkillsRepository skillsRepository ;
    
    public List <Skills> list(){
        return skillsRepository.findAll();
        
    }
    
    public Optional <Skills> getOne(int id){
        return skillsRepository.findById(id);
    }
    
    public Optional <Skills> getByNombre(String nombre){
        return skillsRepository.findByNombre(nombre);
    }
    
    public void save(Skills skills){
        skillsRepository.save(skills);
        
    }
    
       public void delete(int id){
        skillsRepository.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return skillsRepository.existsById(id);
       }
    
    public boolean existsByNombre(String nombre){
           return skillsRepository.existsByNombre(nombre);
       }
    
}
