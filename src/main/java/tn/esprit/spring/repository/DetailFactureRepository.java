package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;

import java.util.List;
// Auther: AZZABI HAMZA
public interface DetailFactureRepository extends CrudRepository<DetailFactureEntity, Long> {

    List<DetailFactureEntity> findAll();

    @Query("select d from DetailFactureEntity d where d.idDetailFacture = :id")
    DetailFactureEntity retieveDetailFactureById(@Param("id") Long id);

    @Query("select d from DetailFactureEntity d where d.factureEntity.idFacture = :id")
    List<DetailFactureEntity> retrieveAllDetailFactureByFacture(@Param("id") Long id);

    @Modifying
    @Query("delete from DetailFactureEntity d where d.idDetailFacture = :id")
    void deleteDetailFactureEntityById(@Param("id") Long id);
}
