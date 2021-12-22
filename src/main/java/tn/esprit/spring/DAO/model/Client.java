package tn.esprit.spring.DAO.model;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class Client {
    private Long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Date dateNaissance;
    private Profession profession;
    private CategorieClient categorieClient;

    public Client() {
    }

    public Client(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance, Profession profession, CategorieClient categorieClient) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.profession = profession;
        this.categorieClient = categorieClient;

    }

}
