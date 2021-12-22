package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;

public interface ProduitService {

	List<ProduitEntity> retrieveAllProduits();

	public void addProduit(ProduitEntity p);

	ProduitEntity retrieveProduit(Long id);

	public void deleteProduit (Long id);

    public void updateProduit(ProduitEntity p);

    public List<ProduitEntity> retrieveProduitsByRayon(Long idRayon);

    public List<ProduitEntity> retrieveProduitsByStock(Long idStock);

    public List<ProduitEntity> retrieveProduitsByRayonAndStock(Long idRayon, Long idStock);

    public Float AffichageChiffreAffaire();

    public List<ProduitEntity> retrieveProduitByPrice();

    public List<ProduitEntity> retrieveProduitByPriceRange(float min,float max);

    public List<ProduitEntity> retrieveProduitByLibelle(String x);

    public List<ProduitEntity> retireveAllProduitByPriceAsc();

    public List<ProduitEntity> retireveAllProduitByPriceDesc();

    //DAAMI Adem
    //affichage de la liste de fournisseur de chaque produit
    public List<FournisseurEntity> retrieveFournisseurByProduit(Long idProduit);
    //assignFournisseurToProduit
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
    
    


}
