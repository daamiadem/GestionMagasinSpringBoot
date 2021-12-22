package tn.esprit.spring.service;

import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.response.OrderResponse;

import java.util.List;

public interface StockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);
    void deleteStock(long id);

    List<Stock> retrieveStocksByLibelle(String test);
    //	Stock updatestockqtebylibelle()
    void deletebylibandminqte(String lib,int qte);
    /*
    List<OrderResponse> retrieveproduitandstock();
    List<OrderResponse> retrieveproduitsandstocksbylibelle(String test);*/
    void updatestockqtebylibelle(int qte,String libStock);
    List<Stock> retrievestocksbyqtestockbetween(int var1,int var2);
    List<Stock> stockqtelessthan(int qtestock);
    int countbyqtemin(int qtemin);
    float retrieveavgstocksbylibstock();
    int retreievecount();
    void assignProduitToStock(Long idProduit, Long idStock);
    void fixedRateMethod() ;
    String retrieveStatusStock();
}
