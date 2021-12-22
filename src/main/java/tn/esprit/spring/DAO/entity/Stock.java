package tn.esprit.spring.DAO.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.DAO.entity.ProduitEntity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity

public class Stock implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock; // Clé primaire
	private int qteStock;
	private int qteMin;
	private String libelleStock;
	@JsonManagedReference
	@OneToMany( cascade = CascadeType.ALL,mappedBy="stock",fetch = FetchType.EAGER)
	private Set<ProduitEntity> produits;
	public Long getIdStock() {
		return idStock;
	}
	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}
	public Stock(int qteStock, int qteMin) {
		super();
		this.qteStock = qteStock;
		this.qteMin = qteMin;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}
	public Stock(Long idStock, int qteStock, int qteMin, String libelleStock) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<ProduitEntity> getProduits() {
		return produits;
	}

	public void setProduits(Set<ProduitEntity> produits) {
		this.produits = produits;
	}
}
