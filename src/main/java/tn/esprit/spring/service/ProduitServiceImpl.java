package tn.esprit.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;
import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.repository.*;


@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
    RayonRepository rayonRepository;
	@Autowired
    StockRepository stockRepository;
	@Autowired
	DetailProduitService detailProduitService;
	@Autowired
	FactureRepository factureRepository;

	@Autowired
	FournisseurRepository FournisseurRepository;
	@Override
	public List<ProduitEntity> retrieveAllProduits() {
		List<ProduitEntity> produits= (List<ProduitEntity>) produitRepository.findAll();
		for (ProduitEntity produit: produits)
			System.out.println("produit : " + produit);
		return produits;
	}

	@Override
	@Transactional
	public void addProduit(ProduitEntity p) {
		p.setRayon(rayonRepository.findById(p.getRayon().getIdRayon()).orElse(null));
		p.setStock(stockRepository.findById(p.getStock().getIdStock()).orElse(null));
		System.out.println("produit : "+ p);
		p.setDetailProduitEntity(saveDetailProduit(p));
		produitRepository.save(p);
	}

	private DetailProduitEntity saveDetailProduit(ProduitEntity p) {
		if (p.getDetailProduitEntity().getDateCreation() == null) {
			p.getDetailProduitEntity().setDateCreation(new java.sql.Date(new java.util.Date().getTime()));
			p.getDetailProduitEntity().setDateDerniereModification(new java.sql.Date(new java.util.Date().getTime()));
		}else {
			p.getDetailProduitEntity().setDateDerniereModification(new java.sql.Date(new java.util.Date().getTime()));
		}
		detailProduitService.addDetailProduit(p.getDetailProduitEntity());

		return p.getDetailProduitEntity();
	}

	@Override
	public ProduitEntity retrieveProduit(Long id) {
		ProduitEntity produit = produitRepository.findById(id).orElse(null);
		System.out.println("produit : "+ produit);
		return produit;
	}

	@Transactional
	@Override
	public void deleteProduit(Long id) {
		ProduitEntity produit = produitRepository.findById(id).orElse(null);
		if(produit != null) {
			detailProduitService.deleteDetailProduit(produit.getDetailProduitEntity().getIdDetailProduit());
			produitRepository.deleteProduitById(id);
		}
	}

	@Override
	public void updateProduit(ProduitEntity p) {
        produitRepository.save(p) ;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByRayon(Long idRayon) {
	    return null;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByStock(Long idStock) {
		return null;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByRayonAndStock(Long idRayon, Long idStock) {
		return null;
	}

	@Scheduled(fixedRate = 60000)
	@Override
	public Float AffichageChiffreAffaire() {
		Float x = factureRepository.calculCA();
		System.out.println(x);
		return factureRepository.calculCA();
	}

	@Override
	public List<ProduitEntity> retrieveProduitByPrice(){

		List<ProduitEntity> x=produitRepository.retrieveProduitByPrice();
		System.out.println(x);
		return produitRepository.retrieveProduitByPrice();
	}

	@Override
	public List<ProduitEntity> retrieveProduitByLibelle(String x){
		List<ProduitEntity> y=produitRepository.retrieveProduitByLibelle(x);
		System.out.println(y);
		return  produitRepository.retrieveProduitByLibelle(x);

	}

	@Override
	public List<ProduitEntity> retireveAllProduitByPriceDesc(){
		List<ProduitEntity> x=produitRepository.retireveAllProduitByPriceDesc();
		System.out.println(x);
		return  produitRepository.retireveAllProduitByPriceDesc();
	}

	@Override
	public List<ProduitEntity> retireveAllProduitByPriceAsc(){
		List<ProduitEntity> x=produitRepository.retireveAllProduitByPriceAsc();
		System.out.println(x);
		return  produitRepository.retireveAllProduitByPriceAsc();
	}

	public List<ProduitEntity> retrieveProduitByPriceRange(float min,float max){
		List<ProduitEntity> y=produitRepository.retrieveProduitByPriceRange(min,max);
		System.out.println(y);
		return  produitRepository.retrieveProduitByPriceRange(min,max);
	}



	//Daami Adem
	//DAAMI Adem
	//ASSIGNING FOURNISSEUR TO PRODUIT
	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		FournisseurEntity f = FournisseurRepository.findById(fournisseurId).get();
		ProduitEntity p = produitRepository.findById(produitId).get();
		p.getFournisseurEntities().add(f);
		produitRepository.save(p);
	}

	@Override
	public List<FournisseurEntity> retrieveFournisseurByProduit(Long idProduit){
		ProduitEntity Produit = produitRepository.findById(idProduit).get();
		Iterator<FournisseurEntity> it = Produit.getFournisseurEntities().iterator();
		if (it ==null){
			return null ;
		}
		List<FournisseurEntity> LF = new ArrayList<>();
		while(it.hasNext()){
			LF.add(it.next());
		}
		return LF;
	}
}
