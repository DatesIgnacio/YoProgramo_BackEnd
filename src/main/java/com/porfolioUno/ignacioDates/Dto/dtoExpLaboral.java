
package com.porfolioUno.ignacioDates.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExpLaboral {
    @NotBlank
    private String nombreExpLaboral;
    @NotBlank
    private String descripcionExpLaboral;
    
    //constructores
    public dtoExpLaboral() {
    }

    public dtoExpLaboral(String nombreExpLaboral, String descripcionExpLaboral) {
        this.nombreExpLaboral = nombreExpLaboral;
        this.descripcionExpLaboral = descripcionExpLaboral;
    }
    
    //getters y setters

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



