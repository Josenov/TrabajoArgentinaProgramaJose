/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioweb.argentinaprograma.Service;

import com.portfolioweb.argentinaprograma.Entity.FormacionAcademica;
import com.portfolioweb.argentinaprograma.Repository.FormacionAcademicaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceFormacionAcademica {
    
   @Autowired
  FormacionAcademicaRepository formacionaAcademicaRepository ;
    
    public List <FormacionAcademica> list(){
        return formacionaAcademicaRepository.findAll();
        
    }
    
    public Optional <FormacionAcademica> getOne(int id){
        return formacionaAcademicaRepository.findById(id);
    }
    
    public Optional <FormacionAcademica> getByNombreForm(String nombreForm){
        return formacionaAcademicaRepository.findByNombreForm(nombreForm);
    }
    
    public void save(FormacionAcademica Form){
        formacionaAcademicaRepository.save(Form);
        
    }
    
       public void delete(int id){
        formacionaAcademicaRepository.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return formacionaAcademicaRepository.existsById(id);
       }
    
    public boolean existsByNombreForm(String nombreForm){
           return formacionaAcademicaRepository.existsByNombreForm(nombreForm);
       }
    
}
