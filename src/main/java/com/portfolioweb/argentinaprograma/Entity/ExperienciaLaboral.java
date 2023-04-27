
package com.portfolioweb.argentinaprograma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombreExpe;
    private String descripcionExpe; 

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreExpe, String descripcionExpe) {
        this.nombreExpe = nombreExpe;
        this.descripcionExpe = descripcionExpe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
