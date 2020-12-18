/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Mehdi
 */
public class CategorieKids {
    
    private int idCategorieKids;
    private String NomCategorie;
    private String Description;

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }
    
    public CategorieKids() {
    }

    public CategorieKids(int idLivreKids) {
        this.idCategorieKids = idLivreKids;
    }

    public CategorieKids(int idLivreKids, String Description) {
        this.idCategorieKids = idLivreKids;
        this.Description = Description;

    }

    public int getIdCategorieKids() {
        return idCategorieKids;
    }

    public void setIdCategorieKids(int idCategorieKids) {
        this.idCategorieKids = idCategorieKids;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "CategorieKids{" + "idCategorieKids=" + idCategorieKids + ", NomCategorie=" + NomCategorie + ", Description=" + Description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idCategorieKids;
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
        final CategorieKids other = (CategorieKids) obj;
        if (this.idCategorieKids != other.idCategorieKids) {
            return false;
        }
        return true;
    }
    


}
