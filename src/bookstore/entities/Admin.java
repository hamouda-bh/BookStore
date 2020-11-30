package bookstore.entities;



public class Admin extends Utilisateur {
	
	
    Utilisateur util ;
	Facture facture ;
	
	
	
	public Admin() {
		super();
	}
	public Admin( int id_user, String nom ,String prenom ,String username,String email,String tel, 	String password,String photo ) {
		super(id_user,nom,prenom,username,email,tel,password,photo);
	}
	
	public void ajouterLivre( ) {
		
	}
	public void retirerLivre( ) {
		
	}
	public void consulterFacture(Facture facture) {
		
	}
	public void imprimerFacture(Facture facture) {
		
	}
	public void ajouterUtilisateur(Utilisateur util) {
		
	}
	public void bloquerUtilisateur(Utilisateur util) {
		
	}
	@Override
	public String toString() {
		return "Admin [getId_user()=" + getId_user() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getTel()=" + getTel()
				+ ", getPassword()=" + getPassword() + ", getPhoto()=" + getPhoto() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
	
	
	
	
}