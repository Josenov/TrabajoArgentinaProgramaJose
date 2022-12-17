
package com.portfolioweb.argentinaprograma.Repository;

import com.portfolioweb.argentinaprograma.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePersonaRepository extends JpaRepository <Persona,Long> {
    
    
    
    
}
