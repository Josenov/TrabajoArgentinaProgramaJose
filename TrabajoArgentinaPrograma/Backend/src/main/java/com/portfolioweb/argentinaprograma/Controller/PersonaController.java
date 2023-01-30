package com.portfolioweb.argentinaprograma.Controller;

import com.portfolioweb.argentinaprograma.Entity.Persona;
import com.portfolioweb.argentinaprograma.Interface.InterfacePersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    InterfacePersonaService interfacepersonaService;

    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return interfacepersonaService.getPersona();

    }

    //@PreAuthorize("hasRole:('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        interfacepersonaService.savePersona(persona);
        return "La persona fue cargada correctamente";

    }

    //@PreAuthorize("hasRole:('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interfacepersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";

    }

    //@PreAuthorize("hasRole:('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {

        Persona persona = interfacepersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        interfacepersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("traer/perfil")
    public Persona findPersona(){
        return interfacepersonaService.findPersona((long)1);
    }

}
