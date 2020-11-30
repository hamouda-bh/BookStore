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
    private String Description;


    public CategorieKids() {
    }

    public CategorieKids(int idLivreKids) {
        this.idCategorieKids = idLivreKids;
    }

    public CategorieKids(int idLivreKids, String Description) {
        this.idCategorieKids = idLivreKids;
        this.Description = Description;

    }

    @Override
    public String toString() {
        return "CategorieKids{" + "idCategorieKids=" + idCategorieKids + ", Description=" + Description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idCategorieKids;
        hash = 13 * hash + Objects.hashCode(this.Description);
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
