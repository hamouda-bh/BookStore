/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import bookstore.services.PanierService;
import java.util.ArrayList;

public abstract class Panier {
  
    public abstract void retirerLivre(Livre b);
    
   
    public abstract int modifierQuantité (ArrayList<Livre> list);
    
    
}
