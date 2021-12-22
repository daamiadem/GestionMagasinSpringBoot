package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.response.OrderResponse;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository stockrepository;
    @Autowired
    ProduitRepository ProduitRepository;
    @Override
    public List<Stock> retrieveAllStocks() {
        // TODO Auto-generated method stub
        List<Stock> Stocks = (List<Stock>) stockrepository.findAll();
        for (Stock Stock: Stocks)
        {
            System.out.println("Stocks:"+Stock);
        }
        // TODO Auto-generated method stub
        return Stocks;	}

    @Override
    public Stock addStock(Stock s) {
        // TODO Auto-generated method stub
        stockrepository.save(s);

        return s;
    }

    @Override
    public Stock updateStock(Stock u) {
        // TODO Auto-generated method stub

        stockrepository.save(u);

        // TODO Auto-generated method stub
        return u;	}

    @Override
    public Stock retrieveStock(Long id) {
        // TODO Auto-generated method stub
        Stock p = stockrepository.findById(id).get();
        // TODO Auto-generated method stub
        return p;	}

    @Override
    public void deleteStock(long id) {
        // TODO Auto-generated method stub
        stockrepository.deleteById(id);
    }

    @Override
    public List<Stock> retrieveStocksByLibelle(String test) {
        // TODO Auto-generated method stub
        List<Stock> stocks = (List<Stock>) stockrepository.retrievestocksbylibelle(test);

        return stocks;	}

    @Override
    public void deletebylibandminqte(String lib, int qte) {
        // TODO Auto-generated method stub
        stockrepository.deletestockbylibandqtmin(lib, qte);

    }
/*
    @Override
    public List<OrderResponse> retrieveproduitandstock() {
        // TODO Auto-generated method stub
        List<OrderResponse> stocks = (List<OrderResponse>) stockrepository.retrieveproduitsandstocks();
        return stocks;
    }

    @Override
    public List<OrderResponse> retrieveproduitsandstocksbylibelle(String test) {
        List<OrderResponse> stocks = (List<OrderResponse>) stockrepository.retrieveproduitsandstocksbylibelle(test);
        return stocks;
    }
*/
    @Override
    public void updatestockqtebylibelle(int qte, String libStock) {
        // TODO Auto-generated method stub
        stockrepository.updatestockqtebylibelle(qte, libStock);
    }

    @Override
    public List<Stock> retrievestocksbyqtestockbetween(int var1, int var2) {
        List<Stock> stocks = (List<Stock>) stockrepository.retrievestocksbyqtestockbetween(var1,var2);

        return stocks;
    }

    @Override
    public List<Stock> stockqtelessthan(int qtestock) {
        // TODO Auto-generated method stub
        List<Stock> stocks = (List<Stock>) stockrepository.findByqteStockLessThan(qtestock);
        return stocks;

        // TODO Auto-generated method stub
    }

    @Override
    public int countbyqtemin(int qtemin) {
        // TODO Auto-generated method stub
        return stockrepository.countByqteMin(qtemin);

    }

    @Override
    public float retrieveavgstocksbylibstock() {
        // TODO Auto-generated method stub
        return stockrepository.retrieveavgstocksbylibstock();
    }

    @Override
    public int retreievecount() {
        // TODO Auto-generated method stub
        return stockrepository.retreievecount();
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        // TODO Auto-generated method stub
        ProduitEntity p = ProduitRepository.findById(idProduit).get();
        Stock s = stockrepository.findById(idStock).get();
        p.setStock(s);
        ProduitRepository.save(p);
    }
    @Scheduled(fixedRate = 600000)
    @Override
    public void fixedRateMethod() {
        // TODO Auto-generated method stub
        //	if (stockrepository.retrivenoqtestocks(idStock)!=null)
        List<Stock> Stocks = (List<Stock>) stockrepository.findAll();
        for (Stock Stock: Stocks)
        {
            if (Stock.getQteStock()==0)
                System.out.println("Stock num : "+Stock.getIdStock() + "epuisé");
        }
    }


// you can test with this :
    //@Scheduled(fixedRate = 20000)

    @Scheduled(cron = "0 0 22 * * *")
    @Override
    public String retrieveStatusStock() {
        String sh="";
        List<Stock> Stocks = (List<Stock>) stockrepository.findAll();
        for (Stock Stock: Stocks)
        {
            if (Stock.getQteStock()<Stock.getQteMin() && !Stock.getProduits().isEmpty())
            {
                System.out.println("le stock suivant :"+Stock+"a la quantité inférieure au quantité minimum des produits suivant :" );
                for (ProduitEntity produit:Stock.getProduits())
                {
                    System.out.println("codeProduit : " +produit.getCodeProduit());
                    System.out.println("LibelleProduit : " +produit.getLibelleProduit());
                    System.out.println("PrixUnitaire : " +produit.getPrixUnitaire());

                    sh+=produit;
                }
            }
        }
        return sh;
    }
}
