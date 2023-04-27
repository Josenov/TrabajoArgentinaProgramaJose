
package com.portfolioweb.argentinaprograma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperienciaLaboral {
    @NotBlank
    private String nombreExpe;
    @NotBlank
    private String descripcionExpe; 

    public DtoExperienciaLaboral() {
    }

    public DtoExperienciaLaboral(String nombreExpe, String descripcionExpe) {
        this.nombreExpe = nombreExpe;
        this.descripcionExpe = descripcionExpe;
    }

    public String getNombreExpe() {
        return nombreExpe;
    }

    public void setNombreExpe(String nombreExpe) {
        this.nombreExpe = nombreExpe;
    }

    public String getDescripcionExpe() {
        return descripcionExpe;
    }

    public void setDescripcionExpe(String descripcionExpe) {
        this.descripcionExpe = descripcionExpe;
    }
    
    
    
}
