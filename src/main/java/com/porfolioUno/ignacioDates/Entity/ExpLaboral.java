
package com.porfolioUno.ignacioDates.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ExpLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExpLaboral;
    private String descripcionExpLaboral;

    
    //constructores
    public ExpLaboral() {
    }

    public ExpLaboral(String nombreExpLaboral, String descripcionExpLaboral) {
        this.nombreExpLaboral = nombreExpLaboral;
        this.descripcionExpLaboral = descripcionExpLaboral;
    }
    
    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExpLaboral() {
        return nombreExpLaboral;
    }

    public void setNombreExpLaboral(String nombreExpLaboral) {
        this.nombreExpLaboral = nombreExpLaboral;
    }

    public String getDescripcionExpLaboral() {
        return descripcionExpLaboral;
    }

    public void setDescripcionExpLaboral(String descripcionExpLaboral) {
        this.descripcionExpLaboral = descripcionExpLaboral;
    }
    
    



    
}
