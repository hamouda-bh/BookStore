/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.entities.Blog;
import bookstore.entities.Publication;
import bookstore.services.serviceBlog;
import bookstore.services.servicePublication;
import bookstore.views.DetailsPublicationController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class PublicationviewController implements Initializable {

    @FXML
    private TextField tfidp;
    @FXML
    private TextField tfidb;
    @FXML
    private TextField tfidc;
    @FXML
    private TextField tfcontenue;
    @FXML
    private TextField tfcommentaire;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPublication(ActionEvent event) throws IOException {
         int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());

        servicePublication sp = new servicePublication();
        sp.ajouter(new Publication(a,b,c,tfcontenue.getText(),tfcommentaire.getText()));
        JOptionPane.showMessageDialog(null, "Publication ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsPublication.fxml"));
        
        Parent root = loader.load();
        
        tfidb.getScene().setRoot(root);
        
        DetailsPublicationController dpc = loader.getController();
     
        dpc.setLbidb(a);
        dpc.setLbidc(b);
        dpc.setLbidp(c);

        dpc.setLbcontenue(tfcontenue.getText());
        dpc.setLbcommentaire(tfcommentaire.getText());
    }
     private void modifierPublication(ActionEvent event) throws IOException {
       int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());
            servicePublication sp = new servicePublication();
        sp.ajouter(new Publication(a,b,c,tfcontenue.getText(),tfcommentaire.getText()));
        JOptionPane.showMessageDialog(null, "Publication modifiée !");

    }
     private void supprimerPublication(ActionEvent event) throws IOException {
       int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());
            servicePublication sp = new servicePublication();
        sp.supprimer(new Publication(a,b,c,"",""));
        JOptionPane.showMessageDialog(null, "Publication supprimée !");
    }
}
