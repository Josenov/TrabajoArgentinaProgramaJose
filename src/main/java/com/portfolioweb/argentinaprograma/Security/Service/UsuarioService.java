
package com.portfolioweb.argentinaprograma.Security.Service;

import com.portfolioweb.argentinaprograma.Security.Entity.Usuario;
import com.portfolioweb.argentinaprograma.Security.Repository.InterfaceUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    InterfaceUsuarioRepository interfaceUsuarioRepository;
    
       public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
        return interfaceUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return interfaceUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
     public boolean existsByEmail(String email){
        return interfaceUsuarioRepository.existsByEmail(email);
    }
     
      public void save(Usuario usuario){
        interfaceUsuarioRepository.save(usuario);
    }
    
}
