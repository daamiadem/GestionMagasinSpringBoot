package tn.esprit.spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.model.DetailFacture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FactureServiceImplTest {

    @Autowired
    FactureRepository factureRepository;

    @Test
    void retrieveAllFactures() {
        List<FactureEntity> factureEntities = (List<FactureEntity>) factureRepository.findAll();
        for (FactureEntity factureEntity : factureEntities)
            System.out.println(factureEntity);
    }

    @Test
    void cancelFacture() {
    }

    @Test
    void retrieveFacture() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRetrieveAllFactures() {
    }

    @Test
    void testCancelFacture() {
    }

    @Test
    void testRetrieveFacture() {
    }

    @Test
    void createFacture() {
    }

    @Test
    void updateFacture() {
    }

    @Test
    void deleteFacture() {
        factureRepository.deleteFactureEntityById(17L);
    }


    @Test
    void retrieveFacturesByClientAndStatus() {
    }

    @Test
    void retrieveFacturesByClientAndStatusAndDate() {
    }

    @Test
    void retrieveFacturesByClientAndStatusAndDateAndType() {
    }
}