package tn.esprit.spring.service;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.FournisseurEntity;

import java.util.Date;
import java.util.List;

public interface IFournisseurService {

    public List<FournisseurEntity> retrieveAllFournisseur();
    public FournisseurEntity addFournisseur(FournisseurEntity p);
    public void deleteFournisseur (Long id);
    public FournisseurEntity UpdateFournisseur (FournisseurEntity F) ;
    public FournisseurEntity retrieveFournisseur(Long id );
    public List<FournisseurEntity> retrieveFournissersByCategorieProduit(CategorieProduit categorieProduit);
    public List<FournisseurEntity> retrieveFournissersByDateCreation(Date dateDebut, Date dateFin );
    public int CountDistinctByCategorieProduit(CategorieProduit categorie_produit);
    public List<FournisseurEntity> CountDistinctByCategorieProduitbydate(CategorieProduit categorie_produit,  Date dateDebut, Date dateFin );
    public int nombreTotalFournisseur();
    //public List<Produit> retrieveProduitsOfFournisseur(@Param("idf") Long idf);
}