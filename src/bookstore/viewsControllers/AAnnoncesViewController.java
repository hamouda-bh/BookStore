/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AAnnoncesViewController implements Initializable {

    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableView<?> fxTableAnnonces;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> auteur;
    @FXML
    private TableColumn<?, ?> genre;
    @FXML
    private TableColumn<?, ?> etat_de_livre;
    @FXML
    private TableColumn<?, ?> prix1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterAnnonce(ActionEvent event) {
    }
    
}
