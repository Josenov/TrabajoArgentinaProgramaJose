
package com.portfolioweb.argentinaprograma.Controller;

import com.portfolioweb.argentinaprograma.Dto.DtoExperienciaLaboral;
import com.portfolioweb.argentinaprograma.Entity.ExperienciaLaboral;
import com.portfolioweb.argentinaprograma.Security.Controller.Mensaje;
import com.portfolioweb.argentinaprograma.Service.ServiceExperienciaLaboral;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/explab")
public class ExperienciaLaboralController {
    @Autowired
    ServiceExperienciaLaboral serviceExperienciaLaboral ;

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list() {
        List<ExperienciaLaboral> list = serviceExperienciaLaboral.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id")int id){
        if(!serviceExperienciaLaboral.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        ExperienciaLaboral experienciaLaboral = serviceExperienciaLaboral.getOne(id).get();
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
            
            
     }   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperienciaLaboral dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExpe())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (serviceExperienciaLaboral.existsByNombreExpe(dtoExp.getNombreExpe())) {
            return new ResponseEntity(new Mensaje("Experiencia Laboral ya existente"), HttpStatus.BAD_REQUEST);
        }

        ExperienciaLaboral experinciaLaboral = new ExperienciaLaboral(dtoExp.getNombreExpe(), dtoExp.getDescripcionExpe());
        serviceExperienciaLaboral.save(experinciaLaboral);
        return new ResponseEntity(new Mensaje("Experiencia Laboral agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperienciaLaboral dtoExp) {
        if (!serviceExperienciaLaboral.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }

        if (serviceExperienciaLaboral.existsByNombreExpe(dtoExp.getNombreExpe()) && serviceExperienciaLaboral.getByNombreExpe(dtoExp.getNombreExpe()).get().
                getId() != id) {
            return new ResponseEntity(new Mensaje("Experiencia Laboral existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoExp.getNombreExpe())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        ExperienciaLaboral experienciaLaboral = serviceExperienciaLaboral.getOne(id).get();
        experienciaLaboral.setNombreExpe(dtoExp.getNombreExpe());
        experienciaLaboral.setDescripcionExpe((dtoExp.getDescripcionExpe()));

        serviceExperienciaLaboral.save(experienciaLaboral);
        return new ResponseEntity(new Mensaje("Experiencia Laboral actualizada correctamente"), HttpStatus.OK);

    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceExperienciaLaboral.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        serviceExperienciaLaboral.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Laboral borrada correctamente"), HttpStatus.OK);

    }

    
}
