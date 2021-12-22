package tn.esprit.spring.DAO.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class ClientEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private Long idClient; // Clé primaire
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client",fetch = FetchType.EAGER)
	private Set<FactureEntity> factureEntities;

	public ClientEntity(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance,
						Profession profession, CategorieClient categorieClient, Set<FactureEntity> factureEntities) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.profession = profession;
		this.categorieClient = categorieClient;
		this.factureEntities = factureEntities;
	}

	public ClientEntity() {

	}

	/*
	public Client(String nom, String prenom, String email, String password, Date dateNaissance,
				  Profession profession, CategorieClient categorieClient) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.profession = profession;
		this.categorieClient = categorieClient;
	}
	*/
	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public CategorieClient getCategorieClient() {
		return categorieClient;
	}

	public void setCategorieClient(CategorieClient categorieClient) {
		this.categorieClient = categorieClient;
	}

	public Set<FactureEntity> getFactures() {
		return factureEntities;
	}

	public void setFactures(Set<FactureEntity> factureEntities) {
		this.factureEntities = factureEntities;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Client{" +
				"idClient=" + idClient +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", dateNaissance=" + dateNaissance +
				", profession=" + profession +
				", categorieClient=" + categorieClient +
				", factures=" + factureEntities +
				'}';
	}
}
