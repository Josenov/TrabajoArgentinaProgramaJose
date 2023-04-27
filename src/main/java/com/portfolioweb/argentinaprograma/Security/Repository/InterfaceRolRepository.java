
package com.portfolioweb.argentinaprograma.Security.Repository;

import com.portfolioweb.argentinaprograma.Security.Entity.Rol;
import com.portfolioweb.argentinaprograma.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
