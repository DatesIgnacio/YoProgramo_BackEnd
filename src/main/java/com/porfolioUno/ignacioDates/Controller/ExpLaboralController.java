/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioUno.ignacioDates.Controller;

import com.porfolioUno.ignacioDates.Dto.dtoExpLaboral;
import com.porfolioUno.ignacioDates.Entity.ExpLaboral;
import com.porfolioUno.ignacioDates.Security.Controller.Mensaje;
import com.porfolioUno.ignacioDates.Service.ExpLaboralService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://frontendporfoliodatesignacio.web.app", "http://localhost:4200"})
public class ExpLaboralController {

    @Autowired
    ExpLaboralService expLaboralService;

    @GetMapping("/lista")
    public ResponseEntity<List<ExpLaboral>> list() {
        List<ExpLaboral> list = expLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExpLaboral> getById(@PathVariable("id") int id){
        if(!expLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExpLaboral expLaboral = expLaboralService.getOne(id).get();
        return new ResponseEntity(expLaboral, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExpLaboral dtoexpLab) {
        if (StringUtils.isBlank(dtoexpLab.getNombreExpLaboral())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (expLaboralService.existsByNombreExpLaboral(dtoexpLab.getNombreExpLaboral())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        ExpLaboral expLaboral = new ExpLaboral(dtoexpLab.getNombreExpLaboral(), dtoexpLab.getDescripcionExpLaboral());
        expLaboralService.save(expLaboral);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExpLaboral dtoexpLab) {
        //Validamos si existe el ID
        if (!expLaboralService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (expLaboralService.existsByNombreExpLaboral(dtoexpLab.getNombreExpLaboral()) && expLaboralService.getByNombreExpLaboral(dtoexpLab.getNombreExpLaboral()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexpLab.getNombreExpLaboral())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        ExpLaboral expLaboral = expLaboralService.getOne(id).get();
        expLaboral.setNombreExpLaboral(dtoexpLab.getNombreExpLaboral());
        expLaboral.setDescripcionExpLaboral((dtoexpLab.getDescripcionExpLaboral()));

        expLaboralService.save(expLaboral);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expLaboralService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        expLaboralService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia laboral eliminada"), HttpStatus.OK);
    }

}
