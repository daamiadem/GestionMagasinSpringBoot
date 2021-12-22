package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Stock;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StockRepository extends CrudRepository <Stock,Long>{
    @Query("SELECT s FROM Stock s WHERE s.libelleStock= :test")
    List<Stock> retrievestocksbylibelle(@Param ("test") String test);

    @Query("SELECT s FROM Stock s WHERE s.qteStock=0 and s.idStock=:test")
    Stock retrivenoqtestocks (@Param ("test") long test);
    List<Stock> findByqteStockLessThan(int qtestock);

    int countByqteMin(int qtemin);


    @Query("SELECT new tn.esprit.spring.DAO.entity.Stock(s.qteStock,s.qteMin) FROM Stock s")
    List<Stock> retrieveqtestockandqtemin();

//	@Query("SELECT new responses.Fournisseurprod(p.fournisseurEntities,p.libelleProduit) FROM ProduitEntity p WHERE p.stock.idStock =?1  ")
//	List<Fournisseurprod> retrievefournisseurandlibprodparstock(long test);


//	@Query("SELECT new responses.stockandfournisseurs(s.libelleStock,f.libelleFournisseur, p.libelleProduit) FROM Stock s RIGHT JOIN Produit p LEFT OUTER JOIN produit_fournisseurs pf ON p.idProduit = pf.ProduitidProduit LEFT OUTER JOIN Fournisseur f ON pf.FournisseuridFournisseur=f.idFournisseur ")
//	List<OrderResponse> retrievefournisseurparstock();
//
//	@Query("SELECT new responses.Fournisseur(s.produits.fournisseurs.codeFournisseur,p.fournisseurs.libelleFournisseur) FROM Stock s INNER JOIN Produit p ON s.idStock = p.stock.idStock AND p.idProduit IN (?1)  ")
//	List<Fournisseur> retrievefournisseurparstocks(@Param ("test") long test);

    @Query("SELECT p FROM ProduitEntity p INNER JOIN p.fournisseurEntities f WHERE f IN (?1) AND p.stock.idStock =?2  ")
    List<ProduitEntity> retrieveproduitsparfournisseursetstocks(FournisseurEntity p,Long test);

    @Query("SELECT s FROM Stock s INNER JOIN ProduitEntity p ON p.stock.idStock=?1 AND p.libelleProduit=?2")
    List<Stock> retrievestockparidstockdeproduit(Long id,String libellep);



    @Query("SELECT s FROM Stock s WHERE s.qteStock= :test")
    List<Stock> retrievestocksbyqtestock(@Param ("test") String test);

    @Query("SELECT AVG(s.qteStock) FROM Stock s")
    float retrieveavgstocksbylibstock();

    @Query("SELECT SUM(s.qteStock) FROM Stock s")
    Long retrievesumstocksbyqtestock();

    @Query("select s from Stock s order by s.libelleStock asc ")
    List<Stock> retrieveStocksasc();

    @Query("select s from Stock s order by s.libelleStock desc ")
    List<Stock> retrieveStocksdesc();

    @Query("SELECT COUNT(s.qteStock) FROM Stock s WHERE s.qteStock<s.qteMin")
    int retreievecount();


    @Query("SELECT s FROM Stock s WHERE s.qteStock BETWEEN :test AND :test2")
    List<Stock> retrievestocksbyqtestockbetween(@Param ("test") int test,@Param ("test2") int test2);

    @Query("SELECT s FROM Stock s WHERE s.qteMin= :test")
    List<Stock> retrievestocksbyqteMin(@Param ("test") String test);


    @Modifying
    @Transactional

    @Query("update Stock s set s.qteStock = :qtes where s.libelleStock = :libstock")
    void updatestockqtebylibelle(@Param("qtes") int qtes,@Param ("libstock") String libstock);

    @Modifying
    @Transactional
    @Query("update Stock s set s.qteMin = :qtmin where s.qteStock = :qtestock")
    void updatestockqtebylibelles(@Param("qtmin") int qtemin,@Param("qtestock") int qtest);

    @Modifying
    @Transactional
    @Query("DELETE FROM Stock s WHERE s.libelleStock= :test AND s.qteMin = :qtemin")
    void deletestockbylibandqtmin(@Param("test") String test, @Param("qtemin") int qtemin);


}


