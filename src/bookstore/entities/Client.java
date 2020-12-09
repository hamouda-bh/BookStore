/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.entities;

/**
 *
 * @author PC-Hamouda
 */
public class Client extends Utilisateur {
    
	
	public Client() {
		super();
	}
	
	public Client(int id_user, String nom ,String prenom ,String username,String email,String tel,String adress ) {
		super(id_user,nom,prenom,username,email,tel,adress);
	}
	
	public Client(int id_user, String nom ,String prenom ,String username,String email,String tel, 	String password,String adress ) {
		super(id_user,nom,prenom,username,email,tel,password,adress);
	}
	
	public void rechercheLivre( ) {
		
	}
	public void passerCommande( ) {
		
	}
	public void payerEnLigne( ) {
		
	}
	public void afficherMonHistorique( ) {
		
	}
	public void selectionnerModePaiement( ) {
		
	}
	public void inscrire() {
		  
	  }
	@Override
	public String toString() {
		return "Client [getId_user()=" + getId_user() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getTel()=" + getTel()
				+ ", getPassword()=" + getPassword() + ", getAdress()=" + getAdress()
				+ ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ "]";
	}
	
	
	
}
