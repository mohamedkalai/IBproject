package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.CompteType;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long>{
	public Compte findByAccountNumber (int AccountNumber);
	 public List<Compte> findBySolde (Sort sort);
	public Compte findByClient (Client client);
	@Query("select c from Compte c where c.typeCompte=:x")
	public List<Compte> findByTypeCompte(@Param("x") CompteType typeCompte);
}
