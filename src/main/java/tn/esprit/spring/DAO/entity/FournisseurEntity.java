package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.crypto.Data;

@SuppressWarnings("serial")
@Entity
@Table( name ="Fournisseur")
public class FournisseurEntity implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private long idFournisseur; //clé primaire
	private String codeFournisseur;
	private String libelleFournisseur;
	private String adresseFournisseur;
	private String numtel;
	private Date dateCreation;

	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;



	public FournisseurEntity(long idFournisseur, String codeFournisseur, String libelleFournisseur, String adresseFournisseur,
							 String numtel, Date dateCreation, CategorieProduit categorieProduit) {
		super();
		this.idFournisseur = idFournisseur;
		this.codeFournisseur = codeFournisseur;
		this.libelleFournisseur = libelleFournisseur;
		this.adresseFournisseur = adresseFournisseur;
		this.numtel = numtel;
		this.dateCreation = dateCreation;
		this.categorieProduit = categorieProduit;
	}
	public FournisseurEntity() {
		super();
	}
	public long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getLibelleFournisseur() {
		return libelleFournisseur;
	}
	public void setLibelleFournisseur(String libelleFournisseur) {
		this.libelleFournisseur = libelleFournisseur;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}
	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}


}
