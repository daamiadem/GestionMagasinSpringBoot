package tn.esprit.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.repository.DetailFactureRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DetailFactureServiceImplTest {

    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Test
    void addDetailFacture() {
    }

    @Test
    void deleteDetailFacture() {
        detailFactureRepository.deleteDetailFactureEntityById(5L);
    }

    @Test
    void updateDetailFacture() {
    }

    @Test
    void getDetailFacture() {
    }

    @Test
    void getAllDetailFactures() {
    }

    @Test
    void retrieveAllDetailFactureByFacture() {
    }
}