package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Profession;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	EmailServiceImpl emailService;
	@Autowired
	FactureRepository FactureRepo;



	//methode1
	public  float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date StartDate,Date endDate)
	{
		List<ClientEntity> Clients = (List<ClientEntity>) clientRepository.retrieveClientByCategorie(categorieClient);
		List<FactureEntity> Factures = (List<FactureEntity>) FactureRepo.findAll();

		float totale=0;

		for(ClientEntity client: Clients){
			for(FactureEntity facture: Factures){

				if(client.getIdClient()==facture.getClient().getIdClient())
				{
					totale = totale+ facture.getMontantFacture();
				}


			}
		}
		return totale;
	}

	//methode2
	public  float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient,Date StartDate,Date endDate)
	{
		List<FactureEntity> Factures = (List<FactureEntity>) clientRepository.FactureClientByCategorie(categorieClient);

		float totale=0;

		for(FactureEntity facture: Factures){

			totale = totale+ facture.getMontantFacture();

		}
		return totale;
	}

	public int countnbrclient(){

		return clientRepository.coutnbreClient();
	}

	//Methode qui met a jour la categorie des clients chaque 30 min en fonction du nombre d'achat qu'ils ont effectué
	//En fonction du nombre d'achat, leur catégorie change et il reçoive un code promo par mail pour leur prochains achats
	//@Scheduled(cron = "*/20 * * * * *")

	@Scheduled(cron = "0 0/30 * * * *")
	@Override
	public int updateCategorieClient()
	{
		List<ClientEntity> Clients = (List<ClientEntity>) clientRepository.findAll();
		for(ClientEntity client: Clients){
			//	System.out.println("clients +++: " + client );

			System.out.println("verif de la categorie");
			if(client.getFactures().size()<=3 && client.getCategorieClient()!=CategorieClient.ORDINAIRE )
			{

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");
				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.ORDINAIRE);

			}
			if(client.getFactures().size()>=4 && client.getFactures().size()<=5  && client.getCategorieClient()!=CategorieClient.FIDELE)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 5% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");


				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.FIDELE);


				try {
					emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			if(client.getFactures().size()>=6 && client.getCategorieClient()!=CategorieClient.PRENUIM)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 10% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");

				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.PRENUIM);


				try {
					emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}
		return 1;
	}


	//Méthode pour afficher la liste des clients
	@Override
	public List<ClientEntity> retrieveAllClients() {

		List<ClientEntity> Clients = (List<ClientEntity>) clientRepository.findAll();
		for(ClientEntity client: Clients){
			System.out.println("clients +++: " + client );

		}
		return Clients;
	}

	//Méthode pour afficher la liste de facture pour chaque client
	@Override
	public  List<FactureEntity> FactureParClient(long id){
		return clientRepository.FactureParClient(id);

	}

	//Méthode pour ajouter un client
	@Override
	public ClientEntity addClient(ClientEntity u) {

		clientRepository.save(u);
		return u;
	}

	//Méthode pour ajouter un client
	public ClientEntity addClientRepo(ClientEntity u) {

		clientRepository.insertClient(u.getNom(), u.getPrenom(), u.getDateNaissance(),u.getEmail(), u.getPassword(), u.getProfession(), u.getCategorieClient());
		return u;
	}

	//Méthode pour supprimer un client

	@Override
	public void deleteClient(Long id) {

		clientRepository.deleteById(id);

	}




	//Méthode pour afficher les clients par profession

	@Override
	public
	List<ClientEntity> retrieveClientbyProfession(Profession Profession){
		return clientRepository.retrieveClientByProfession(Profession);

	}

	//Méthode pour afficher les clients par categorie
	@Override
	public List<ClientEntity> retrieveClientbyCategorie(CategorieClient categorieClient) {
		return clientRepository.retrieveClientByCategorie(categorieClient);


	}

	//Méthode pour modifier un client
	@Override
	public ClientEntity updateClient(ClientEntity u) {
		long id= u.getIdClient();
		Optional<ClientEntity> Clients = clientRepository.findById(id);

		if(Clients!=null)
			clientRepository.save(u);

		return u;
	}

	//Méthode pour afficher un clients par id
	@Override
	public ClientEntity retrieveClient(long id) {

		ClientEntity Client = null;

		try {
			Client = clientRepository.findById(id).get();

		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}

		return Client;
	}


	//Méthode pour modifier un clients par id
	@Override
	public ClientEntity updateClientById(ClientEntity u, Long id) {
		long idd= u.getIdClient();
		if(id==idd)
		{
			Optional<ClientEntity> Clients = clientRepository.findById(id);

			if(Clients!=null)
				clientRepository.save(u);
		}
		return u;
	}


	//Méthode pour afficher les clients par profession et categorie

	public List<ClientEntity> retrieveClientbyCategorieAndProfession(Profession Profession , CategorieClient CategorieClient)
	{

		return clientRepository.retrieveClientByProfessionANDcategorie(Profession, CategorieClient)	 ;

	}

	//Methode qui retourne l'argent depensé par un client
	public float getMoneySpentByOneClient(Long idClient){

		List<FactureEntity> factures = clientRepository.FactureParClient(idClient);
		float totale=0;

		for(FactureEntity facture: factures){

			totale = totale+ facture.getMontantFacture();

		}
		return totale;

	}

	//Méthode pour statistique qui retourne le nombre de client par catégorie
	public int statClientByCat(CategorieClient cat){
		return clientRepository.statClientByCat(cat);
	}

	//Méthode qui affiche la liste des produits achetes pour un client et une facture donnée
	public List<ProduitEntity> ListProduitAcheteByClient( Long idClient,Long idFacture){

		return clientRepository.ListProduitByFacture(idClient,idFacture);
	}

}