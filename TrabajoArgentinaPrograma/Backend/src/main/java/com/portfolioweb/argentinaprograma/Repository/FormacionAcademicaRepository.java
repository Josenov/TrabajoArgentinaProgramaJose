
package com.portfolioweb.argentinaprograma.Repository;

import com.portfolioweb.argentinaprograma.Entity.FormacionAcademica;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionAcademicaRepository extends JpaRepository<FormacionAcademica, Integer> {
    public Optional <FormacionAcademica>findByNombreForm(String nombreForm);
    public boolean existsByNombreForm(String nombreForm);
}
