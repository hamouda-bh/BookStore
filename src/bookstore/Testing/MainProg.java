/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import bookstore.entities.Client;
import bookstore.services.ClientService;
import bookstore.services.LivreKidsService;

/**
 *
 * @author PC-Hamouda
 */
public class MainProg {
    public static void main(String[] args) {
        DBConnection.getInstance();
        //ClientService cs = new ClientService();
        //Client c1 = new Client( "qsdazdsqsdsqqfdsqfqss", "Ben qsqdqsd", "qsdqsdq", "qsdqdqsd.mohamed@esprit.tn","qsqdsqdqs", "C:/Users/Photo.jpg");
        //System.out.println(c1.toString()); 
        //cs.ajouterClientDB(c1);
        LivreKidsService l = new LivreKidsService();
        l.afficherLesLivresKids();
        
    }
}
