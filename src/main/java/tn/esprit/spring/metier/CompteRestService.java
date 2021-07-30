package tn.esprit.spring.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.CompteType;
import tn.esprit.spring.service.CompteServices;

@RestController
public class CompteRestService {
@Autowired
CompteServices compteservices;

@PostMapping("/ajouter")
public void ajouterCompte(@RequestBody Compte compte) {
	
	compteservices.ajouterCompte(compte);
}
@GetMapping("/afficher")
public List<Compte> afficher() {
	
	return compteservices.afficher(); 
}
@DeleteMapping("/supprimer/{id}")
public void SupprimerAc(@PathVariable("id") long id) {
	compteservices.SupprimerAc(id);    	
}
@GetMapping("/findCompte/{/id_client}")
public Compte findCompte(@PathVariable("id_client") long id_client){
	
	return compteservices.findCompte(id_client);
}

@GetMapping("/recherCompte")
public Compte recherCompte(@RequestBody Compte compte) {
	return compteservices.recherCompte(compte);
	
}



@PutMapping("/updateCompte")
public Compte updateCompte(@RequestBody Compte compte) {
	
	return compteservices.updateCompte(compte);
}

@PostMapping("/affecterBanque/{id}/{id_banque}")
public Compte affecterBanque(@PathVariable("id") long id , @PathVariable("id_banque") long id_banque) {
	
	
	return compteservices.affecterBanque(id, id_banque);
}

@GetMapping("compplusdébit")
public List<Compte> compplusdébit() {
	
	return compteservices.compplusdébit();
}

@GetMapping("/findByOrderBySoldeAsc")
public Page<Compte> findByOrderBySoldeAsc() {
	
	return compteservices.findByOrderBySoldeAsc();
}



@GetMapping("/Nbrcomptepartybe")
public int Nbrcomptepartybe(@RequestBody CompteType comptype) {
	 
	return compteservices.Nbrcomptepartybe(comptype);
}



@GetMapping("/moyenneSal")
public float moyenneSal() {
	return compteservices.moyenneSal();
	
}


}
