package tn.esprit.spring.DAO.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Auther: AZZABI HAMZA

@Entity
@Table(name = "DetailFacture")
public class DetailFactureEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private int montantRemise;
	@ManyToOne
	ProduitEntity produit;
	@JsonIgnore
	@ManyToOne
    FactureEntity factureEntity;

	public DetailFactureEntity(long idDetailFacture, int qte, float prixTotal, int pourcentageRemise, int montantRemise,
							   ProduitEntity produit, FactureEntity factureEntity) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
		this.produit = produit;
		this.factureEntity = factureEntity;
	}

	public DetailFactureEntity() {

	}

	public ProduitEntity getProduit() {
		return produit;
	}

	public void setProduit(ProduitEntity produit) {
		this.produit = produit;
	}

	public FactureEntity getFacture() {
		return factureEntity;
	}

	public void setFacture(FactureEntity factureEntity) {
		this.factureEntity = factureEntity;
	}

	public long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(int pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public int getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(int montantRemise) {
		this.montantRemise = montantRemise;
	}

}
