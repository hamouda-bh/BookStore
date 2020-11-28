package bookstore.entities;

public class Blog {
private int idCatégorie;
private String Description;
Publication[] pub;

public int getIdCatégorie() {
	return idCatégorie;
}
public void setIdCatégorie(int idCatégorie) {
	this.idCatégorie = idCatégorie;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Description == null) ? 0 : Description.hashCode());
	result = prime * result + idCatégorie;
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
	Blog other = (Blog) obj;
	if (Description == null) {
		if (other.Description != null)
			return false;
	} else if (!Description.equals(other.Description))
		return false;
	if (idCatégorie != other.idCatégorie)
		return false;
	return true;
}
@Override
public String toString() {
	return "Blog [idCatégorie=" + idCatégorie + ", Description=" + Description + "]";
}

}
