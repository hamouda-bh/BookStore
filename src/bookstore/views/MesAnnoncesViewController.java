/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Annonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class MesAnnoncesViewController implements Initializable {

    @FXML
    private Button modifierUneAnnonce;
    @FXML
    private Button AjouterUneAnnonce;
    @FXML
    private Button SupprimerUneAnnonce;
    @FXML
    private TextField findannonce;
    @FXML
    private Button btnChercher;
    @FXML
    private TableColumn<Annonce, String> titre;
    @FXML
    private TableColumn<Annonce, String> auteur;
    @FXML
    private TableColumn<Annonce, String> genre;
    @FXML
    private TableColumn<Annonce, String> etat_de_livre;
    @FXML
    private TableColumn<Annonce, String> prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierAnnonce(ActionEvent event) {
    }

    @FXML
    private void ajouterAnnonce(ActionEvent event) {
    }

    @FXML
    private void supprimerAnnonce(ActionEvent event) {
    }

    @FXML
    private void afficherBy(ActionEvent event) {
    }

    @FXML
    private void afficherAnnonce(ActionEvent event) {
    }
    
}
