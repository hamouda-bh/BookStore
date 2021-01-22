
package bookstore.Testing;

import bookstore.entities.Client;
import bookstore.entities.Commande;
import bookstore.entities.Facture;
import bookstore.entities.Panier_livre;
import bookstore.services.CommandeService;
import bookstore.services.FactureService;

import bookstore.services.LivreKidsService;
import bookstore.services.PanierService;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class MainProg {
    public static void main(String[] args) throws SQLException, IOException {
        
        DBConnection.getInstance();
             /*   PanierService service = new PanierService();
            //service.supprimer(15);
          //  service.modifier(20, 1);
                  float i=          service.afficherp();
         System.out.println(i);*/
       // Commande c = new Commande ("2020-12-10",1,10);
                   // CommandeService cs = new CommandeService();
                   // cs.ajouter(c);
          
            /*Facture fact = new Facture(5,5,"2020-12-10",15);
            FactureService serv= new FactureService ();
            serv.ajouter(fact);
            serv.affichage();
            
            */
            
        LivreKidsService l = new LivreKidsService();
        boolean x=l.rechercheTitre("colorer");
        System.out.println(x);        
    }
 
}
