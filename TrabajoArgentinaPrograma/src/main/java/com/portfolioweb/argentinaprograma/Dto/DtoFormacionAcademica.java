
package com.portfolioweb.argentinaprograma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoFormacionAcademica {
    @NotBlank
    private String nombreForm;
    @NotBlank
    private String descripcionForm; 

    public DtoFormacionAcademica() {
    }

    public DtoFormacionAcademica(String nombreForm, String descripcionForm) {
        this.nombreForm = nombreForm;
        this.descripcionForm = descripcionForm;
    }

    public String getNombreForm() {
        return nombreForm;
    }

    public void setNombreForm(String nombreForm) {
        this.nombreForm = nombreForm;
    }

    public String getDescripcionForm() {
        return descripcionForm;
    }

    public void setDescripcionForm(String descripcionForm) {
        this.descripcionForm = descripcionForm;
    }
    
    
    
}
