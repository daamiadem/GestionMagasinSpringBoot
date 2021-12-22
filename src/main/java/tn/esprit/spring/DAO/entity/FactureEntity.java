package tn.esprit.spring.DAO.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

//@Author : AZZABI HAMZA

@Entity
@Table(name = "Facture")
@Getter
@Setter
public class FactureEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	@JsonBackReference
	@ManyToOne
	private ClientEntity client;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factureEntity")
	private Set<DetailFactureEntity> detailfactures;

	public FactureEntity(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active,
						 ClientEntity client, Set<DetailFactureEntity> detailfactures) {
		super();
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.client = client;
		this.detailfactures = detailfactures;
	}

	public FactureEntity(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active, Set<DetailFactureEntity> detailfactures) {
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.detailfactures = detailfactures;
	}

	public FactureEntity() {

	}


}
