package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Rayon;
import tn.esprit.spring.service.RayonService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RayonRestController {
    @Autowired
    RayonService rayonService;

    @GetMapping("getAllRayons")
    public List<Rayon> getRayons(){
        return rayonService.retrieveAllRayons();
    }

    @GetMapping("getRayon/{rayon-idRayon}")
    public Rayon retrieveRayon(@PathVariable("rayon-idRayon") long idRayon){
        return rayonService.retrieveRayon(idRayon);
    }

    @PutMapping(value="/updateRayon",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rayon updateRayon(@RequestBody Rayon rayon){
        return rayonService.updateRayon(rayon);
    }

    @PostMapping(value="/addRayon",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Rayon addRayon(@RequestBody Rayon rayon){
        return rayonService.addRayon(rayon);
    }

    @DeleteMapping(value="/deleteRayon/{idRayon}")
    public void deleteRayon(@PathVariable("idRayon") Long idRayon){
        rayonService.deleteRayon(idRayon);
    }
}
