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

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AnnoncesViewController implements Initializable {

    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableColumn<?, ?> cella;
    @FXML
    private TableColumn<?, ?> celld;
    @FXML
    private TableColumn<?, ?> cellp;
    @FXML
    private TableColumn<?, ?> celle;

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
