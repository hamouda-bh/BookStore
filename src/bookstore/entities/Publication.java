package bookstore.entities;

public class Publication {
private int idPublication;
private String contenue ;
private String commentaire ;
 Livre [] livres;
public int getIdPublication() {
	return idPublication;
}
public void setIdPublication(int idPublication) {
	this.idPublication = idPublication;
}
public String getContenue() {
	return contenue;
}
public void setContenue(String contenue) {
	this.contenue = contenue;
}
public String getCommentaire() {
	return commentaire;
}
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
	result = prime * result + ((contenue == null) ? 0 : contenue.hashCode());
	result = prime * result + idPublication;
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
	Publication other = (Publication) obj;
	if (commentaire == null) {
		if (other.commentaire != null)
			return false;
	} else if (!commentaire.equals(other.commentaire))
		return false;
	if (contenue == null) {
		if (other.contenue != null)
			return false;
	} else if (!contenue.equals(other.contenue))
		return false;
	if (idPublication != other.idPublication)
		return false;
	return true;
}
@Override
public String toString() {
	return "Publication [idPublication=" + idPublication + ", contenue=" + contenue + ", commentaire=" + commentaire
			+ "]";
} 


}
