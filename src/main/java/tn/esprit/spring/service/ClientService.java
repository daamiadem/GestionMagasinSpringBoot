package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Profession;

public interface ClientService {

	List<ClientEntity> retrieveAllClients();
	ClientEntity addClient(ClientEntity u);
	ClientEntity addClientRepo(ClientEntity u);
	void deleteClient(Long id);
	ClientEntity updateClient(ClientEntity u);
	ClientEntity updateClientById(ClientEntity u,Long id);

	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date StartDate, Date endDate);
	float getMoneySpentByOneClient(Long idClient);
	List<ClientEntity> retrieveClientbyProfession(Profession Profession);
	List<ClientEntity> retrieveClientbyCategorie(CategorieClient CategorieClient);
	List<ClientEntity> retrieveClientbyCategorieAndProfession(Profession Profession , CategorieClient CategorieClient);
	ClientEntity retrieveClient(long id);
	int countnbrclient();
	float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient,Date StartDate,Date endDate);
	int updateCategorieClient();
	List<FactureEntity> FactureParClient(long id);
	int statClientByCat(CategorieClient categorie);
	List<ProduitEntity> ListProduitAcheteByClient( Long idClient,Long idFacture);

}