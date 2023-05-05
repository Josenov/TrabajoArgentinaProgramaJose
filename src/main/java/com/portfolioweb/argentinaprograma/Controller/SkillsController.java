
package com.portfolioweb.argentinaprograma.Controller;

import com.portfolioweb.argentinaprograma.Dto.DtoSkills;
import com.portfolioweb.argentinaprograma.Entity.Skills;
import com.portfolioweb.argentinaprograma.Security.Controller.Mensaje;
import com.portfolioweb.argentinaprograma.Service.ServiceSkills;
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
@CrossOrigin(origins = {"https://portfoliofrontend-be4c7.web.app","http://localhost:4200"})
@RequestMapping("/skills")
public class SkillsController {
    
    @Autowired
    ServiceSkills serviceSkills;
    
     
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = serviceSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")int id){
        if(!serviceSkills.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
       Skills skills = serviceSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
            
            
     }   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (serviceSkills.existsByNombre(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Skill ya existente"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoSkills.getNombre(), dtoSkills.getPorcentaje());
        serviceSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {
        if (!serviceSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }

        if (serviceSkills.existsByNombre(dtoSkills.getNombre()) && serviceSkills.getByNombre(dtoSkills.getNombre()).get().
                getId() != id) {
            return new ResponseEntity(new Mensaje("Skill existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = serviceSkills.getOne(id).get();
        skills.setNombre(dtoSkills.getNombre());
        skills.setPorcentaje((dtoSkills.getPorcentaje()));

        serviceSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);

    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        serviceSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill borrada correctamente"), HttpStatus.OK);

    }
    
    
    
    
}
