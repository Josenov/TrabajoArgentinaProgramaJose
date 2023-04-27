
package com.portfolioweb.argentinaprograma.Controller;

import com.portfolioweb.argentinaprograma.Dto.DtoFormacionAcademica;
import com.portfolioweb.argentinaprograma.Entity.FormacionAcademica;
import com.portfolioweb.argentinaprograma.Security.Controller.Mensaje;
import com.portfolioweb.argentinaprograma.Service.ServiceFormacionAcademica;
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
@CrossOrigin(origins = "https://portfoliofrontend-be4c7.web.app")
@RequestMapping("/formacionacademica")
public class FormacionAcademicaController {
    @Autowired
    ServiceFormacionAcademica serviceFormacionAcademica;
    
    @GetMapping("/lista")
    public ResponseEntity<List<FormacionAcademica>> list() {
        List<FormacionAcademica> list = serviceFormacionAcademica.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<FormacionAcademica> getById(@PathVariable("id")int id){
        if(!serviceFormacionAcademica.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
       FormacionAcademica formacionAcademica = serviceFormacionAcademica.getOne(id).get();
        return new ResponseEntity(formacionAcademica, HttpStatus.OK);
            
            
     }   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoFormacionAcademica dtoForm) {
        if (StringUtils.isBlank(dtoForm.getNombreForm())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (serviceFormacionAcademica.existsByNombreForm(dtoForm.getNombreForm())) {
            return new ResponseEntity(new Mensaje("Formacion Academica ya existente"), HttpStatus.BAD_REQUEST);
        }

        FormacionAcademica formacionAcademica = new FormacionAcademica(dtoForm.getNombreForm(), dtoForm.getDescripcionForm());
        serviceFormacionAcademica.save(formacionAcademica);
        return new ResponseEntity(new Mensaje("Formacion Academica agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoFormacionAcademica dtoForm) {
        if (!serviceFormacionAcademica.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }

        if (serviceFormacionAcademica.existsByNombreForm(dtoForm.getNombreForm()) && serviceFormacionAcademica.getByNombreForm(dtoForm.getNombreForm()).get().
                getId() != id) {
            return new ResponseEntity(new Mensaje("Formacion Academica existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoForm.getNombreForm())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        FormacionAcademica formacionAcademica = serviceFormacionAcademica.getOne(id).get();
        formacionAcademica.setNombreForm(dtoForm.getNombreForm());
        formacionAcademica.setDescripcionForm((dtoForm.getDescripcionForm()));

        serviceFormacionAcademica.save(formacionAcademica);
        return new ResponseEntity(new Mensaje("Formacion Academica actualizada correctamente"), HttpStatus.OK);

    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceFormacionAcademica.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        serviceFormacionAcademica.delete(id);
        return new ResponseEntity(new Mensaje("Formacion Academica borrada correctamente"), HttpStatus.OK);

    }
    
    
}
