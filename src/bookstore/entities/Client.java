package bookstore.entities;
public class Client extends Utilisateur {
    
	
	public Client() {
		super();
	}
	public Client(int id_user, String nom ,String prenom ,String username,String email,String tel, 	String password,String photo ) {
		super(id_user,nom,prenom,username,email,tel,password,photo);
	}
	
	
	
	
	
	
	
	
	public void rechercheLivre( ) {
		
	}
	public void passerCommande( ) {
		
	}
	public void payerEnLigne( ) {
		
	}
	public void afficherMonHistorique( ) {
		
	}
	public void sélectionnerModePaiement( ) {
		
	}
	public void inscrire() {
		  
	  }
	@Override
	public String toString() {
		return "Client [getId_user()=" + getId_user() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getTel()=" + getTel()
				+ ", getPassword()=" + getPassword() + ", getPhoto()=" + getPhoto() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
