package tn.esprit.spring.DAO.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.spring.DAO.entity.ProduitEntity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rayon")
public class Rayon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRayon;
	private String codeRayon;
	private String libelleRayon;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rayon")
	private Set<ProduitEntity> produits;

	public Rayon(long idRayon, String codeRayon, String libelleRayon, Set<ProduitEntity> produits) {
		super();
		this.idRayon = idRayon;
		this.codeRayon = codeRayon;
		this.libelleRayon = libelleRayon;
		this.produits = produits;
	}

	public Rayon() {

	}

	public Set<ProduitEntity> getProduits() {
		return produits;
	}

	public void setProduits(Set<ProduitEntity> produits) {
		this.produits = produits;
	}

	public long getIdRayon() {
		return idRayon;
	}

	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
	}

	public String getCodeRayon() {
		return codeRayon;
	}

	public void setCodeRayon(String codeRayon) {
		this.codeRayon = codeRayon;
	}

	public String getLibelleRayon() {
		return libelleRayon;
	}

	public void setLibelleRayon(String libelleRayon) {
		this.libelleRayon = libelleRayon;
	}

}
