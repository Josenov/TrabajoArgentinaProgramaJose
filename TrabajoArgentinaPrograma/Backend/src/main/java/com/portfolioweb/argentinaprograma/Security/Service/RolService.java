
package com.portfolioweb.argentinaprograma.Security.Service;

import com.portfolioweb.argentinaprograma.Security.Entity.Rol;
import com.portfolioweb.argentinaprograma.Security.Enums.RolNombre;
import com.portfolioweb.argentinaprograma.Security.Repository.InterfaceRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
   InterfaceRolRepository interfaceRolRepository;
    
    public Optional <Rol> getByRolNombre(RolNombre rolNombre){
        return interfaceRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        interfaceRolRepository.save(rol);
    }
    
}
