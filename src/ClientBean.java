import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dal.beans.Compte;
import dal.services.SpringFactoryClient;

@Named
@RequestScoped
public class ClientBean {
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
	
	public String listComptes(){
		
		factclient=new SpringFactoryClient();
		
		this.comptes=new ArrayList<Compte>(factclient.getClientService().findClient(num).getComptes());
		
		return "affichage.xhtml";
		
			
		
		
		
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	
	

}
