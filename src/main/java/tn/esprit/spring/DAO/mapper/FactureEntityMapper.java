package tn.esprit.spring.DAO.mapper;


import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.model.*;

import java.util.ArrayList;
import java.util.List;
// Auther: AZZABI HAMZA
public class FactureEntityMapper {
   public static Facture mapFactureEntityToFacture(FactureEntity factureEntity) {
        return new Facture(factureEntity.getIdFacture(), factureEntity.getMontantRemise(),factureEntity.getMontantFacture(),factureEntity.getDateFacture(),factureEntity.isActive(),getClient(factureEntity.getClient()) /*,factureEntity.getDetailfactures()*/);
    }

    public static List<Facture> mapFactureEntityListToFactureList(List<FactureEntity> factureEntityList) {
       List<Facture> factures = new ArrayList<>();
        for (FactureEntity factureEntity : factureEntityList) {
           factures.add(new Facture(factureEntity.getIdFacture(), factureEntity.getMontantRemise(),factureEntity.getMontantFacture(),factureEntity.getDateFacture(),factureEntity.isActive(), getClient(factureEntity.getClient())/*,factureEntity.getDetailfactures()*/));
        }
        return factures;

    }

    public static FactureEntity mapFactureToFactureEntity(Facture facture) {
        return new FactureEntity(facture.getIdFacture(), facture.getMontantRemise(),facture.getMontantFacture(),facture.getDateFacture(),facture.isActive()/*,facture.getDetailfactures()*/,null);
    }

    /*private static ClientEntity getClientEntity(Client client) {
       return new ClientEntity(client.getIdClient(),client.getNom(), client.getPrenom(), client.getEmail(), client.getPassword() ,client.getDateNaissance(),tn.esprit.spring.DAO.entity.Profession.valueOf(client.getProfession().toString())  , tn.esprit.spring.DAO.entity.CategorieClient.valueOf(client.getCategorieClient().toString()) );
    }*/

    private static Client getClient(ClientEntity clientEntity) {
        return new Client(clientEntity.getIdClient(),clientEntity.getNom(), clientEntity.getPrenom(), clientEntity.getEmail(), clientEntity.getPassword() ,clientEntity.getDateNaissance(), Profession.valueOf(clientEntity.getProfession().toString()) , CategorieClient.valueOf(clientEntity.getCategorieClient().toString()));
    }
    
    /*private static Set<DetailFacture> getDetailFactures (Set<DetailFacture> detailFacturesEntity){
        Set<DetailFacture> detailFactures = new HashSet<>();
        for()
    }*/
}
