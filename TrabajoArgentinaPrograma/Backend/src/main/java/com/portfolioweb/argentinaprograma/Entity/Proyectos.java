
package com.portfolioweb.argentinaprograma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyectos {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @NotNull
     @Size (min = 1, max = 60, message = "error longitud caracteres" )
     private  String nombreProyecto;
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String descripcionProyecto;
    
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String urlProyecto;
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String imgProyecto;

    public Proyectos() {
    }

    public Proyectos(String nombreProyecto, String descripcionProyecto, String urlProyecto, String imgProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
        this.imgProyecto = imgProyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
