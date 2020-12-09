
package bookstore.Testing;

import bookstore.entities.Client;

import bookstore.services.LivreKidsService;

public class MainProg {
    public static void main(String[] args) {
        DBConnection.getInstance();
        //ClientService cs = new ClientService();
        //Client c1 = new Cliient( "qsdazdsqsdsqqfdsqfqss", "Ben qsqdqsd", "qsdqsdq", "qsdqdqsd.mohamed@esprit.tn","qsqdsqdqs", "C:/Users/Photo.jpg");
        //System.out.println(c1.toString()); 
        //cs.ajouterClientDB(c1);
        LivreKidsService l = new LivreKidsService();
        boolean x=l.rechercheTitre("colorer");
        System.out.println(x);        
    }
}
