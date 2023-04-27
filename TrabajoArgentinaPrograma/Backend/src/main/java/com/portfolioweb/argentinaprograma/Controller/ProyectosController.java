
package com.portfolioweb.argentinaprograma.Controller;

import com.portfolioweb.argentinaprograma.Dto.DtoProyectos;
import com.portfolioweb.argentinaprograma.Entity.Proyectos;
import com.portfolioweb.argentinaprograma.Security.Controller.Mensaje;
import com.portfolioweb.argentinaprograma.Service.ServiceProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin (origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired  ServiceProyectos serviceProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = serviceProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!serviceProyectos.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        Proyectos proyectos = serviceProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
            
            
     } 
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!serviceProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
        }
        serviceProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (serviceProyectos.existsByNombreProyecto(dtoProyectos.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Informacion de Proyecto ya existente"), HttpStatus.BAD_REQUEST);
        }

       Proyectos proyectos= new Proyectos (dtoProyectos.getNombreProyecto(), dtoProyectos.getDescripcionProyecto(),dtoProyectos.getUrlProyecto(),dtoProyectos.getImgProyecto());
        serviceProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Informacion de Proyecto Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos){
        if(!serviceProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(serviceProyectos.existsByNombreProyecto(dtoProyectos.getNombreProyecto()) && serviceProyectos
                .getByNombreProyecto(dtoProyectos.getNombreProyecto()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtoProyectos.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = serviceProyectos.getOne(id).get();
        proyectos.setNombreProyecto(dtoProyectos.getNombreProyecto());
        proyectos.setDescripcionProyecto(dtoProyectos.getDescripcionProyecto());
        proyectos.setUrlProyecto(dtoProyectos.getUrlProyecto());
        proyectos.setImgProyecto(dtoProyectos.getImgProyecto());
        
        serviceProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Informacion de Proyectos Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
    
}
