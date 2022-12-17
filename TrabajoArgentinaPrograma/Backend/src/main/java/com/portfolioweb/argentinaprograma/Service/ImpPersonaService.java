
package com.portfolioweb.argentinaprograma.Service;

import com.portfolioweb.argentinaprograma.Entity.Persona;
import com.portfolioweb.argentinaprograma.Interface.InterfacePersonaService;
import com.portfolioweb.argentinaprograma.Repository.InterfacePersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements InterfacePersonaService{
    
    @Autowired InterfacePersonaRepository interfacepersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = interfacepersonaRepository.findAll(); 
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        interfacepersonaRepository.save(persona); 
    }

    @Override
    public void deletePersona(Long id) {
         interfacepersonaRepository.deleteById(id); 
    }

    @Override
    public Persona findPersona(Long id) {
         Persona persona=interfacepersonaRepository.findById(id).orElse(null);
         return(persona);
    }
    
}
