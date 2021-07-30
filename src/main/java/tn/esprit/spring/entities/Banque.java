package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_banque;
	@OneToMany(mappedBy="banque")
	private Set<Agence> agences;
	@OneToMany(mappedBy="banque")
	private Set<Compte> comptes;
	@OneToMany(mappedBy="banque")
	private Set<PackProduit> packproduits;
	
	private String nom;
	private String addrese;

	public Banque() {
		super();
	}

	public Banque(long id_banque, Set<Agence> agences, Set<Compte> comptes, Set<PackProduit> packproduits, String nom,
			String addrese) {
		super();
		this.id_banque = id_banque;
		this.agences = agences;
		this.comptes = comptes;
		this.packproduits = packproduits;
		this.nom = nom;
		this.addrese = addrese;
	}

	public long getId_banque() {
		return id_banque;
	}


	public Set<Agence> getAgences() {
		return agences;
	}

	public void setAgences(Set<Agence> agences) {
		this.agences = agences;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Set<PackProduit> getPackproduits() {
		return packproduits;
	}

	public void setPackproduits(Set<PackProduit> packproduits) {
		this.packproduits = packproduits;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAddrese() {
		return addrese;
	}

	public void setAddrese(String addrese) {
		this.addrese = addrese;
	}

   
	
	
	

}
