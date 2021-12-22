package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.service.ProduitService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    @GetMapping(value = "getAllProduits")
    public List<ProduitEntity> getAllProduits(){
        return produitService.retrieveAllProduits();
    }

    @PostMapping(value = "addProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduit(@RequestBody ProduitEntity produitEntity){
        produitService.addProduit(produitEntity);
    }
    @PutMapping(value = "/updateProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduit(@RequestBody ProduitEntity produit){produitService.updateProduit(produit);
    }
    @DeleteMapping("/deleteProduit/{idProduit}")
    public void deleteProduit(@PathVariable("idProduit") Long idProduit){
        produitService.deleteProduit(idProduit);
    }

    @GetMapping("getProduitByPriceRange/{min}/{max}")
    public List<ProduitEntity> retrieveProduitByPriceRange(@PathVariable("min") float min,@PathVariable("max") float max){

        return  produitService.retrieveProduitByPriceRange(min,max);
    }

    @GetMapping(value = "/getAllProduitByPriceAsc")
    public List<ProduitEntity> retireveAllProduitByPriceAsc() {
        return produitService.retireveAllProduitByPriceAsc();
    }

    @GetMapping(value = "/getAllProduitByPriceDesc")
    public List<ProduitEntity> retireveAllProduitByPriceDesc() {
        return produitService.retireveAllProduitByPriceDesc();
    }

    @GetMapping(value = "/getProduitByLibelle/{libelle}")
    public List<ProduitEntity> retrieveProduitByLibelle(@PathVariable("libelle") String libelle) {
        return produitService.retrieveProduitByLibelle(libelle);
    }

    @GetMapping(value="/getProduitById/{id}")
    public ProduitEntity findById(@PathVariable("id") Long id){
        return produitService.retrieveProduit(id);
    }

    @GetMapping(value = "/getProduitByPrice")
    public List<ProduitEntity> retrieveProduitByPrice() {
        return produitService.retrieveProduitByPrice();
    }

    @GetMapping(value = "/getChiffreAffaire")
    public float AffichageChiffreAffaire() {
        return produitService.AffichageChiffreAffaire();
    }


    //DAAMIAdem
    //affecter un fournisseur a un produit
    @ResponseBody
    @PutMapping("/assignFournisseurToProduit/{idFournisseur}/{idProduit}")
    public void assignFournisseurToProduit(@PathVariable("idFournisseur") Long fournisseurId,@PathVariable("idProduit") Long produitId) {
        produitService.assignFournisseurToProduit(fournisseurId, produitId);
    }

    @GetMapping("getFournisseurProduit/{idProduit}")
    public List<FournisseurEntity> getFournisseurProduit(@PathVariable("idProduit") Long idProduit){
        return produitService.retrieveFournisseurByProduit(idProduit);
    }

    }


