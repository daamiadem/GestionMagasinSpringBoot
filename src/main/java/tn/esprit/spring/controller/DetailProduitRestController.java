package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;
import tn.esprit.spring.DAO.model.Facture;
import tn.esprit.spring.response.ResponseHandler;
import tn.esprit.spring.service.DetailProduitService;


import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class DetailProduitRestController {

    @Autowired
    DetailProduitService detailProduitService;

    @GetMapping(value = "getDetailProduits")
    public List<DetailProduitEntity> getAllDetailProduits(){
        return detailProduitService.retrieveAllDetailProduits();
    }

   /* @PostMapping(value="/addDetailProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addDetailProduit (@RequestBody DetailProduitEntity detailProduitEntity){
        try {
            DetailProduitEntity dp= detailProduitService.addDetailProduit(detailProduitEntity);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, dp);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Failed to add data!", HttpStatus.BAD_REQUEST, null);
        }
    }*/

    @PutMapping(value = "updateDetailProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDetailProduit(@RequestBody DetailProduitEntity detailProduitEntity){
        detailProduitService.updateDetailProduit(detailProduitEntity);
    }
    @GetMapping("/CountDistinctByCatProd/{categorieProduit}")
    public int CountDistinctByCategorieProduit(@PathVariable("categorieProduit") CategorieProduit categorieProduit) {
        return detailProduitService.CountDistinctByCategorieProduit(categorieProduit);
    }
}
