package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Profession;

import java.util.Date;
import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    @Query("select c from ClientEntity c where c.profession = :profession")
    List<ClientEntity> retrieveClientsByProffession(@Param("profession")Profession profession);

    @Modifying
    @Query("update ClientEntity c set c.categorieClient = :categorie where c.profession = :profession")
    int updateClientCategorieByProffession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Modifying
    @Query("DELETE FROM ClientEntity c where c.categorieClient= :categorie and c.profession= :profession")
    Long deleteClientByCategorieClientAndProfession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Query("select c from ClientEntity c where c.dateNaissance between :date1 and :date2")
    List<ClientEntity> retrieveClientsBetweenDates(@Param("date1")String date1, @Param("date2")String date2);


    @Transactional
    @Modifying
    @Query("update ClientEntity c set c.categorieClient = :categorie where c.idClient= :idClient")
    int updateCategorieClient(@Param("idClient") Long idClient,@Param("categorie") CategorieClient categorieClient);

    @Modifying
    @Query("DELETE FROM ClientEntity c WHERE c.idClient= :idclient")
    int deleteClientByidClient(@Param("idclient") Long idClient);

    @Query("SELECT c FROM ClientEntity c WHERE c.categorieClient= :categorie")
    List<ClientEntity> retrieveClientByCategorie(@Param("categorie") CategorieClient CategorieClient);

    //@Query("SELECT sum(c.idClient) FROM Client c order by c.categorieClient")
    //int statCatClient();

    @Query("SELECT c FROM ClientEntity c WHERE c.profession= :profession")
    List<ClientEntity> retrieveClientByProfession(@Param("profession") Profession Profession);

    @Query("SELECT COUNT(c.idClient) FROM ClientEntity c WHERE c.categorieClient= :categorie")
    int statClientByCat(@Param("categorie") CategorieClient CategorieClient);


    @Query("SELECT c FROM ClientEntity c WHERE c.profession= :profession and  c.categorieClient= :categorie")
    List<ClientEntity> retrieveClientByProfessionANDcategorie(@Param("profession") Profession Profession,@Param("categorie") CategorieClient CategorieClient);

    @Query("SELECT COUNT(c) FROM ClientEntity c ")
    int coutnbreClient();


    @Query("SELECT c.factureEntities FROM ClientEntity c WHERE c.categorieClient= :categorie")
    List<FactureEntity> FactureClientByCategorie(@Param("categorie") CategorieClient CategorieClient);

    @Query("SELECT c.factureEntities FROM ClientEntity c WHERE c.idClient= :idClient")
    List<FactureEntity> FactureParClient(@Param("idClient") Long idClient);

    @Query("SELECT c FROM ClientEntity c WHERE c.idClient= :idClient")
    List<ClientEntity> ClientById(@Param("idClient") Long idClient);

    @Modifying
    @Query(value = "INSERT INTO ClientEntity (nom, prenom,dateNaissance,email,password,profession,categorieClient) VALUES (:nom, :prenom, :dateN, :email, :password, :profession, :categorieClient)",
            nativeQuery = true)
    void insertClient(@Param("nom") String nom, @Param("prenom") String prenom,
                      @Param("dateN") Date dateNaissance, @Param("email") String email,
                      @Param("password") String password, @Param("profession") Profession
                              profession, @Param("categorieClient") CategorieClient categorieClient);


    @Query("SELECT df.produit FROM DetailFactureEntity df,ClientEntity c ,FactureEntity f WHERE (c.idClient= :idclient) and (f.client.idClient= :idclient) and (f.idFacture=:idfacture) and(df.factureEntity.idFacture=:idfacture)")
    List<ProduitEntity> ListProduitByFacture(@Param("idclient") Long idClient,@Param("idfacture") Long idfacture);





}