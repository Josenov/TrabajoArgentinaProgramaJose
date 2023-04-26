
package com.portfolioweb.argentinaprograma.Service;


import com.portfolioweb.argentinaprograma.Entity.Persona;
import com.portfolioweb.argentinaprograma.Repository.InterfacePersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService{
    
    @Autowired 
    InterfacePersonaRepository interfacepersonaRepository;
    
    public List <Persona> list(){
        return interfacepersonaRepository.findAll();
        
    }
    
    public Optional <Persona> getOne(int id){
        return interfacepersonaRepository.findById(id);
    }
    
    public Optional <Persona> getByNombre(String nombre){
        return interfacepersonaRepository.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        interfacepersonaRepository.save(persona);
        
    }
    
       public void delete(int id){
        interfacepersonaRepository.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return interfacepersonaRepository.existsById(id);
       }
    
    public boolean existsByNombre(String nombre){
           return interfacepersonaRepository.existsByNombre(nombre);
       }

    
}
