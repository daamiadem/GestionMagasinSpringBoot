package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.FactureEntity;

import java.util.List;
// Author: AZZABI HAMZA
public interface FactureRepository extends CrudRepository<FactureEntity, Long> {

    List<FactureEntity> findAll();

    @Modifying
    @Query("update FactureEntity  set active = :active where idFacture = :id")
    void updateActive(@Param("id") Long id,@Param("active") boolean active);

    @Modifying
    @Query("delete from FactureEntity f where f.idFacture = :id")
    void deleteFactureEntityById(@Param("id") Long id);

    @Query("select f from FactureEntity f where f.active = true ")
    List<FactureEntity> retrieveAllActiveFacture();

    @Query("select f from FactureEntity f where f.active = false ")
    List<FactureEntity> retrieveAllInActiveFacture();

    @Query("select f from FactureEntity f where f.dateFacture between :date1 and :date2")
    List<FactureEntity> retirveAllFactureBetweenDate(@Param("date1") String date1, @Param("date2") String date2);

    @Query("SELECT f from FactureEntity f order by f.dateFacture desc ")
    List<FactureEntity> retrieveAllFactureByDateFactureDesc();

    @Query("select f from FactureEntity f order by f.dateFacture")
    List<FactureEntity> retrieveAllFactureByDateFactureAsc();

    @Query("select f from FactureEntity f where f.idFacture = :idFacture")
    FactureEntity retrieveFactureById(@Param("idFacture") Long idFacture);

    @Query("select f from FactureEntity f order by f.montantRemise asc ")
    List<FactureEntity> retrieveAllFactureByRemiseAsc();

    @Query("select f from FactureEntity f order by f.montantRemise desc ")
    List<FactureEntity> retrieveAllFactureByRemiseDesc();

    @Query("select f from FactureEntity f order by f.montantFacture asc ")
    List<FactureEntity> retrieveAllFactureByTTCAsc();

    @Query("select f from FactureEntity f order by f.montantFacture desc ")
    List<FactureEntity> retrieveAllFactureByTTCDesc();

    @Query("select f from FactureEntity f where f.dateFacture = :date")
    List<FactureEntity> retrieveAllFactureByDate(@Param("date") String date);

    @Query("select f from FactureEntity f where f.dateFacture = :date and f.active = true")
    List<FactureEntity> retrieveAllFactureByDateAndActive(@Param("date") String date);

    @Query("select f from FactureEntity f where f.dateFacture = :date and f.active = false")
    List<FactureEntity> retrieveAllFactureByDateAndInActive(@Param("date") String date);

    @Query("select f from FactureEntity f where f.dateFacture between :date1 and :date2 ")
    List<FactureEntity> retrieveAllFactureBetweenDate(String date1, String date2);

    @Query("select f from FactureEntity f where f.active = true and f.dateFacture between :date1 and :date2 ")
    List<FactureEntity> retrieveAllFactureBetweenDateAndActive(String date1, String date2);

    @Query("select f from FactureEntity f where f.active = false and f.dateFacture between :date1 and :date2 ")
    List<FactureEntity> retrieveAllFactureBetweenDateAndInActive(String date1, String date2);

    @Query("select f from FactureEntity f where f.montantFacture between :max and :min")
    List<FactureEntity> retrieveAllFactureByTTCRange(double min, double max);

    @Query("select f from FactureEntity f where f.client.idClient = :idClient")
    List<FactureEntity> retrieveAllFactureByClient(@Param("idClient") Long idClient);

    @Query(value = "Select SUM(f.montantFacture) FROM FactureEntity f where f.active=false")
    Float calculCA();
}
