package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.service.DetailFactureService;
import tn.esprit.spring.DAO.model.DetailFacture;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DetailFactureRestController {

    @Autowired
    DetailFactureService detailFactureService;

    @PostMapping(value="/addDetailFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDetailFacture(@RequestBody DetailFacture detailFacture) {
        detailFactureService.addDetailFacture(detailFacture);
    }

    @DeleteMapping(value="/deleteDetailFacture/{id}")
    public void deleteDetailFacture(@PathVariable("id") Long id) {
        detailFactureService.deleteDetailFacture(id);
    }

    @PutMapping(value="/updateDetailFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDetailFacture(@RequestBody DetailFacture detailFacture) {
        detailFactureService.updateDetailFacture(detailFacture);
    }

    @GetMapping(value="/getDetailFacture/{id}")
    public DetailFacture getDetailFacture(@PathVariable("id") Long id) {
        return detailFactureService.getDetailFacture(id);
    }

    @GetMapping(value="/getAllDetailFacture")
    public List<DetailFacture> getAllDetailFacture() {
        return detailFactureService.getAllDetailFactures();
    }

    @GetMapping(value="/getDetailFactureByFacture/{id}")
    public List<DetailFacture> getDetailFactureByFacture(@PathVariable("id") Long id) {
        return detailFactureService.retrieveAllDetailFactureByFacture(id);
    }
}
