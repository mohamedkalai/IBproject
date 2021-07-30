package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.CompteType;

@Service
public interface ICompteServices {

	public void ajouterCompte (Compte compte);
	//public List<Compte> rechercheCompte (long id);
	public Compte recherCompte(Compte compte);
	public void SupprimerAc (long id);
	public List<Compte> afficher();
	public List<Compte> compplusdébit();
	 public Page<Compte> findByOrderBySoldeAsc();
	 public Compte updateCompte(Compte compte);
	 public Compte affecterBanque(long id, long id_banque);
	 public int Nbrcomptepartybe(CompteType comptype);
	 public Compte findCompte(long id_client);
	 public float moyenneSal();
}
