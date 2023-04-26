
package com.portfolioweb.argentinaprograma.Repository;

import com.portfolioweb.argentinaprograma.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
     public Optional <Skills>findByNombre(String nombre);
     public boolean existsByNombre(String nombre);
    
}
