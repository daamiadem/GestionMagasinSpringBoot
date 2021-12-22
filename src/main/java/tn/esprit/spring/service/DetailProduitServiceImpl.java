package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;

import java.util.List;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {

    @Autowired
    DetailProduitRepository detailProduitRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<DetailProduitEntity> retrieveAllDetailProduits() {
        return (List<DetailProduitEntity>) detailProduitRepository.findAll();
    }

    @Override
    public void addDetailProduit(DetailProduitEntity detailProduit) {
        detailProduitRepository.save(detailProduit);

    }

    @Override
    public void deleteDetailProduit(long id) {
        detailProduitRepository.deleteDetailProduitEntityById(id);
    }

    @Override
    public DetailProduitEntity retrieveDetailProduit(long id) {
        return null;
    }

    @Override
    public void updateDetailProduit(DetailProduitEntity detailProduit) {
        DetailProduitEntity dp = detailProduitRepository.findById(detailProduit.getIdDetailProduit()).get();
        if (dp != null) {
            dp.setCategorieProduit(detailProduit.getCategorieProduit());
            dp.setDateDerniereModification(new java.sql.Date(new java.util.Date().getTime()));
            detailProduitRepository.save(dp);
        }
    }
    @Override
    public int CountDistinctByCategorieProduit(CategorieProduit categorie_produit) {
        return detailProduitRepository.CountDistinctByCategorieProduit(categorie_produit);
    }
}
