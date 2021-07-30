package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_client;
	@OneToOne(mappedBy="client")
	private Credit credit;
	@OneToMany(mappedBy="client")
	private Set<Compte> comptes;
	@OneToMany(mappedBy="client")
	private Set<Facture> factures;
	@ManyToMany
	private Set<Intervention> interventions;
	@ManyToOne
	private Admin admin;
	private float salaire;
	private Type typeClient;
	private String nom_client;
	private String prenom_client;
	private String CIN;
	private String telephone;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(long id_client, Credit credit, Set<Compte> comptes, Set<Facture> factures, Set<Intervention> interventions,
			Admin admin, float salaire, Type typeClient, String nom_client, String prenom_client, String cIN,
			String telephone) {
		super();
		this.id_client = id_client;
		this.credit = credit;
		this.comptes = comptes;
		this.factures = factures;
		this.interventions = interventions;
		this.admin = admin;
		this.salaire = salaire;
		this.typeClient = typeClient;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		CIN = cIN;
		this.telephone = telephone;
	}

	public long getId_client() {
		return id_client;
	}
	
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public Set<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	public Set<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	public Set<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Type getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(Type typeClient) {
		this.typeClient = typeClient;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getPrenom_client() {
		return prenom_client;
	}
	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
