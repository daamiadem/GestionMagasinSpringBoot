package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.repository.FournisseurRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FournisseurServiceImpl implements IFournisseurService {

    @Autowired
    FournisseurRepository FournisseurRepostry;

    @Override
    public List<FournisseurEntity> retrieveAllFournisseur() {
        System.out.println(FournisseurRepostry.findAll());

        return (List<FournisseurEntity>) FournisseurRepostry.findAll();
    }

    @Override
    public FournisseurEntity addFournisseur(FournisseurEntity p) {
        List<FournisseurEntity> fournisseur = new ArrayList<FournisseurEntity>();
        fournisseur.add(FournisseurRepostry.save(p));
        return p;
    }

    @Override
    public void deleteFournisseur(Long id) {
        FournisseurRepostry.deleteById(id);
    }

    @Override
    public FournisseurEntity UpdateFournisseur(FournisseurEntity f) {
        FournisseurEntity a = FournisseurRepostry.findById(f.getIdFournisseur()).get();
        a.setCodeFournisseur(f.getCodeFournisseur());
        a.setLibelleFournisseur(f.getLibelleFournisseur());
        a.setCategorieProduit(f.getCategorieProduit());
        a.setAdresseFournisseur(f.getAdresseFournisseur());
        a.setDateCreation(f.getDateCreation());
        a.setNumtel(f.getNumtel());

        return FournisseurRepostry.save(a);
    }

    @Override
    public FournisseurEntity retrieveFournisseur(Long id) {
        return FournisseurRepostry.findById(id).get();
    }

    @Override
    public List<FournisseurEntity> retrieveFournissersByCategorieProduit(CategorieProduit categorie_produit) {
        return FournisseurRepostry.retrieveFournissersByCategorieProduit(categorie_produit);
    }

    @Override
    public List<FournisseurEntity> retrieveFournissersByDateCreation(Date dateDebut, Date dateFin) {
        return FournisseurRepostry.retrieveFournissersByDateCreation(dateDebut, dateFin);
    }

    @Override
    public int CountDistinctByCategorieProduit(CategorieProduit categorie_produit) {
        return FournisseurRepostry.CountDistinctByCategorieProduit(categorie_produit);
    }

    @Override
    public List<FournisseurEntity> CountDistinctByCategorieProduitbydate(CategorieProduit categorie_produit, Date dateDebut, Date dateFin) {
        return FournisseurRepostry.CountDistinctByCategorieProduitbydate(categorie_produit, dateDebut, dateFin);
    }

    @Override
    public int nombreTotalFournisseur() {
        return FournisseurRepostry.nombreTotalFournisseur();
    }


}