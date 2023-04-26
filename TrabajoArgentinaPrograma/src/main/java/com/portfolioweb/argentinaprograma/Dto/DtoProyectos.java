
package com.portfolioweb.argentinaprograma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyectos {
    @NotBlank
     private  String nombreProyecto;
     @NotBlank
     private String descripcionProyecto;
     @NotBlank
     private String urlProyecto;
     @NotBlank
     private String imgProyecto;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProyecto, String descripcionProyecto, String urlProyecto, String imgProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
        this.imgProyecto = imgProyecto;
    }
    
    

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }
     
     
    
}
