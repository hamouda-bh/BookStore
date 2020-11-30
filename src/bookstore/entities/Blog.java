package bookstore.entities;

public class Blog {
    private int id_blog;
private int id_client;
private String categorie_blog;
private String description;

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

    public String getCategorie_blog() {
        return categorie_blog;
    }

    public void setCategorie_blog(String categorie_blog) {
        this.categorie_blog = categorie_blog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_blog;
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
        final blog other = (blog) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Blog{" + "id_blog=" + id_blog + ", id_client=" + id_client + ", categorie_blog=" + categorie_blog + ", description=" + description + '}';
    }

    public Blog() {
    }

    public Blog(int id_blog, int id_client, String categorie_blog, String description) {
        this.id_blog = id_blog;
        this.id_client = id_client;
        this.categorie_blog = categorie_blog;
        this.description = description;
    }


}
