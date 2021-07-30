package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.esprit.spring.entities.Client;
import org.springframework.data.domain.Sort;
import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.CompteType;
import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.repository.BanqueRepositoy;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteRepository;

public class CompteServices implements ICompteServices {

	@Autowired
	CompteRepository compRep;
	@Autowired
	BanqueRepositoy banqRep;
	@Autowired
	ClientRepository clientRep;
	float sal=0;
	@Override
	public void ajouterCompte(Compte compte) {
		// TODO Auto-generated method stub
		compRep.save(compte);
	}



	@Override
	public void SupprimerAc(long id) {
		// TODO Auto-generated method stub
		
		compRep.deleteById(id);
		
	}
	@Override
	public Compte findCompte(long id_client){
		
		Client cl1=clientRep.findById(id_client).get();
		
		return (Compte) cl1.getComptes();
	
	}

	@Override
	public List<Compte> afficher() {
		// TODO Auto-generated method stub
		List<Compte> comptes=(List<Compte>) compRep.findAll();
		return comptes; 
	}


	


	@Override
	public Compte recherCompte(Compte compte) {
		// TODO Auto-generated method stub
		Compte cp=compRep.findByAccountNumber(compte.getAccountNumber());
		return cp;
	}

	

	@Override
	public Compte updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		compRep.save(compte);
		return compte;
	}

	@Override
	@Transactional
	public Compte affecterBanque(long id, long id_banque) {
		// TODO Auto-generated method stub
		Banque banque = banqRep.findById(id_banque).get();
		Compte compte = compRep.findById(id).get();
		compte.setBanque(banque);
		compRep.save(compte);
		return compte;
	}

	@Override
	public List<Compte> compplusdébit() {
		// TODO Auto-generated method stub
		 List<Compte> comptes = (List<Compte>) compRep.findAll();
		comptes = compRep.findBySolde(Sort.by("solde").descending());
		return comptes;
	}
	
	@Override
	public Page<Compte> findByOrderBySoldeAsc() {
		// TODO Auto-generated method stub
		 Page<Compte> comp = (Page<Compte>) compRep.findAll();
		 comp = (Page<Compte>) compRep.findBySolde(Sort.by("solde").ascending());

		return comp;
	}



	@Override
	public int Nbrcomptepartybe(CompteType comptype) {
		// TODO Auto-generated method stub
		 
		return compRep.findByTypeCompte(comptype).size();
	}



	@Override
	public float moyenneSal() {
		// TODO Auto-generated method stub
		List<Client> client= (List<Client>) clientRep.findAll();
		
		
		client.forEach(e->sal=sal+e.getSalaire());
		return sal;
	}
}
