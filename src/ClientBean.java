import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dal.beans.Client;
import dal.beans.Compte;
import dal.services.SpringFactoryClient;

@Named
@RequestScoped
public class ClientBean implements Serializable {
	private Long num;
	private String nom;
	private String prenom ;
	private List<Compte> comptes;
	//pas la peine car depuis d'un jar  //pas distribué
	
	SpringFactoryClient factclient; 
	
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String listeComptes(){
		
		factclient=new SpringFactoryClient();
		Client c=new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		
		
		this.comptes=new ArrayList<Compte>(factclient.getClientService().findClient(c).getComptes());
		
		if(this.comptes.isEmpty())
		return "authentification";
		else return "affiche";
	
	}
	
	public String connect(){
		
		return "Comptes";
	}
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	
	

}
