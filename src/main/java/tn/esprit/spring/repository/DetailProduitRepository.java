package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;

public interface DetailProduitRepository extends CrudRepository<DetailProduitEntity, Long> {
    @Query("SELECT COUNT(DISTINCT idDetailProduit) FROM DetailProduitEntity  WHERE categorieProduit = :cat")
    int CountDistinctByCategorieProduit(@Param("cat") CategorieProduit categorie_produit);

    @Query("select max(idDetailProduit) from DetailProduitEntity")
    DetailProduitEntity getLastDetailProduitAdded();

    @Modifying
    @Query("delete FROM DetailProduitEntity dp where dp.idDetailProduit = :id")
    void deleteDetailProduitEntityById(@Param("id") Long idDetailProduit);
}
