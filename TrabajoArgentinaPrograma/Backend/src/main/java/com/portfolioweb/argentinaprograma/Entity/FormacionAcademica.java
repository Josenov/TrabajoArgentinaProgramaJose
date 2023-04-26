
package com.portfolioweb.argentinaprograma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormacionAcademica {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombreForm;
    private String descripcionForm;

    public FormacionAcademica() {
    }

    public FormacionAcademica(String nombreForm, String descripcionForm) {
        this.nombreForm = nombreForm;
        this.descripcionForm = descripcionForm;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
