/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.entities;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author PC-Hamouda
 */
public class Utilisateur {
    
	  private int  id_user;
	  private String nom ; 
	  private String prenom ; 
	  private String username; 
	  private String email;
	  private String tel ;
	  private String password;
	
	  private String adress; 
	  
	  
	  
	  
	  
	  
	public Utilisateur() {
		
	}
	  
	public Utilisateur(String nom, String prenom, String username, String email, String tel, String password,
			String adress) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.password = password;
	
		this.adress = adress;
	}
	
	public Utilisateur(String nom, String prenom, String username, String email, String tel,
			String adress) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;

	
		this.adress = adress;
	}
	
	public Utilisateur(int id_user, String nom, String prenom, String username, String email, String tel,
			String adress) {
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.adress = adress;
	}


	public Utilisateur(int id_user, String nom, String prenom, String username, String email, String tel,
			String password,String adress) {
	
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.adress = adress;
	}
	

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void modifierPrix() {
		  
	  }
	  public void ajouterVente( ) {
		  
	  }
	  public void  retirerVente( ) {
		  
	  }
	  public void modifierMonProfil( ) {
		  
	  }
	  public void changerMonMdp() {
		  
	  }
	  
	  public void authentifier() {
		  
	  }
	  public void logout() {
		  
	  }

	

	@Override
	public String toString() {
		return "Utilisateur [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username
				+ ", email=" + email + ", tel=" + tel + ", password=" + password + ", adress="
				+ adress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	  

}