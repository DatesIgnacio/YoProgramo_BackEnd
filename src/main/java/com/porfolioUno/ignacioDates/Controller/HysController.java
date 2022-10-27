package com.porfolioUno.ignacioDates.Controller;


import com.porfolioUno.ignacioDates.Dto.dtoHys;
import com.porfolioUno.ignacioDates.Entity.Hys;
import com.porfolioUno.ignacioDates.Security.Controller.Mensaje;
import com.porfolioUno.ignacioDates.Service.HysService;
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
@CrossOrigin(origins = {"https://frontendporfoliodatesignacio.web.app", "http://localhost:4200"})
@RequestMapping("/habilidad")
public class HysController {

    @Autowired
    HysService hysService;

    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list() {
        List<Hys> list = hysService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hys hys = hysService.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hysService.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa habilidad  existe"), HttpStatus.BAD_REQUEST);
        }

        Hys hys = new Hys(dtohys.getNombre(), dtohys.getPorcentaje());
        hysService.save(hys);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys) {
        /*//Validamos si existe el ID*/
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        /*    //Compara nombre de experiencias */
        if (hysService.existsByNombre(dtohys.getNombre()) && hysService.getByNombre(dtohys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        /*//No puede estar vacio*/
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Hys hys = hysService.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje((dtohys.getPorcentaje()));

        hysService.save(hys);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hysService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

}


