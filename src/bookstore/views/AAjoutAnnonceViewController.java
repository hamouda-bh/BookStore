/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Annonce;
import bookstore.services.ServiceAnnonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AAjoutAnnonceViewController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfdate_publication;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfetat;
    @FXML
    private TextField tfdateachat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterUneNouvelleAnnonce(ActionEvent event) {
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.ajouterAnnonce(new Annonce(tfdate_publication.getText(),tfprix.getLength(),tfetat.getText(),tfdateachat.getText()));
        
        JOptionPane.showMessageDialog(null,"Annonce ajoutée !");
        
    }
    
}
