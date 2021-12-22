package tn.esprit.spring.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;
import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.Profession;
import tn.esprit.spring.repository.ClientRepository;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ClientEntityServiceImplTest {

    @Autowired
    ClientRepository clientRepository;



    @Test
    void retrieveAllClients() {
        List<ClientEntity> clientsList = (List<ClientEntity>) clientRepository.findAll();
        for (ClientEntity client: clientsList ) {
            System.out.println(client.toString());
        }
    }

    @Test
    @Rollback(false)
    void addClient() {
        ClientEntity client = new ClientEntity(null,"Azzabi","Hamza","hamza.azzabitest@esprit.tn","0000",new Date("17/12/1998") , Profession.ETUDIANT, CategorieClient.PRENUIM,null);
        System.out.println(client.toString());
        clientRepository.save(client);
    }

    @Test
    void deleteClient() {
        ClientEntity client = new ClientEntity(1L,"Azzabi","Hamza","hamza.azzabi@esprit.tn","0000",new Date("17/12/1998") , Profession.ETUDIANT, CategorieClient.PRENUIM,null);
        clientRepository.delete(client);
    }

    @Test
    void updateClient() {
        String nom = "azzabiUpdate";
        ClientEntity client = clientRepository.findById(1L).orElse(null);
        client.setNom(nom);
        clientRepository.save(client);
        ClientEntity clientUpdated = clientRepository.findById(1L).orElse(null);
        System.out.println(clientUpdated.toString());
        assertThat(clientUpdated.getNom()).isEqualTo(nom);

    }

    @Test
    void retrieveClient() {
        ClientEntity client =  clientRepository.findById(1L).orElse(null);
        System.out.println("Client :" + client);
    }
}