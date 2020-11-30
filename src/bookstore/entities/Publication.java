package bookstore.entities;

public class Publication {
private int id_publication;
private int id_blog;
private int id_client;
private String contenue ;
private String commentaire ;

    public Publication() {
    }

    public Publication(int id_publication, int id_blog, int id_client, String contenue, String commentaire) {
        this.id_publication = id_publication;
        this.id_blog = id_blog;
        this.id_client = id_client;
        this.contenue = contenue;
        this.commentaire = commentaire;
    }

    public int getId_publication() {
        return id_publication;
    }

    public void setId_publication(int id_publication) {
        this.id_publication = id_publication;
    }

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final publication other = (publication) obj;
        if (this.id_publication != other.id_publication) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publication{" + "id_publication=" + id_publication + ", id_blog=" + id_blog + ", id_client=" + id_client + ", contenue=" + contenue + ", commentaire=" + commentaire + '}';
    }


}
