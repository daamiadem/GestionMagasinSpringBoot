package tn.esprit.spring.service;

import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.model.Facture;

import java.util.List;
// Auther: AZZABI HAMZA
public interface FactureService {
    List<Facture> retrieveAllFactures();

    void cancelFacture(FactureEntity facture);

    Facture retrieveFacture(Long id);

    Facture createFacture(Facture facture);

    void updateFacture(Facture facture);

    void deleteFacture(Long id);

    List<Facture> retrieveFacturesInActive();

    List<Facture> retrieveFacturesActive();

    List<Facture> retrieveFacturesByDateDesc();

    List<Facture> retrieveFacturesByDateAsc();

    List<Facture> retrieveFacturesBetweenDates(String date1, String date2);

    List<FactureEntity> retrieveFacturesByPriceRange(double min, double max);

    List<FactureEntity> retrieveFacturesByDateRange(String date1, String date2);

    List<FactureEntity> retrieveFacturesByDate(String date);

    List<FactureEntity> retrieveFacturesByStatusAndDate(String status, String date);

    FactureEntity assignClientToFacture(FactureEntity factureEntity, Long id);

    void sendFactureByEmail(Facture facture, String text);

}
