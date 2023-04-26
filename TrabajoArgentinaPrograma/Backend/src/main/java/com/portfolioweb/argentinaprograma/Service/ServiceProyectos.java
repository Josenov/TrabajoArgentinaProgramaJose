
package com.portfolioweb.argentinaprograma.Service;

import com.portfolioweb.argentinaprograma.Entity.Proyectos;
import com.portfolioweb.argentinaprograma.Repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceProyectos {
    @Autowired ProyectosRepository proyectosRepository;
    
    public List<Proyectos> list(){
    return proyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return proyectosRepository.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyectos proyectos){
        proyectosRepository.save(proyectos);
    }
    
    public void delete(int id){
        proyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
          return proyectosRepository.existsById(id);
      }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return proyectosRepository.existsByNombreProyecto(nombreProyecto);
        
      }
    
}
