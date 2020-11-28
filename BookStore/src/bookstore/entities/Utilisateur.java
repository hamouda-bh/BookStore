package bookstore.entities;



public class Utilisateur {
    
	  private int  id_user;
	  private String nom ; 
	  private String prenom ; 
	  private String username; 
	  private String email;
	  private String tel ;
	  private String password;
	  private String photo ; // LE schéma des images 
	  
	  
	  
	  
	  
	  
	  public Utilisateur() {
		
	}
	  
	public Utilisateur(String nom, String prenom, String username, String email, String tel, String password,
			String photo) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.photo = photo;
	}

	public Utilisateur(int id_user, String nom, String prenom, String username, String email, String tel,
			String password, String photo) {
	
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.photo = photo;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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
				+ ", email=" + email + ", tel=" + tel + ", password=" + password + ", photo=" + photo + "]";
	}

	  

}
