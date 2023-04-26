
package com.portfolioweb.argentinaprograma.Repository;

import com.portfolioweb.argentinaprograma.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePersonaRepository extends JpaRepository <Persona,Integer> {
     public Optional <Persona>findByNombre(String nombre);
     public boolean existsByNombre(String nombre);
    
    
    
}
