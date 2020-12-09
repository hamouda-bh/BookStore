/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Categorie;
import bookstore.services.CategorieService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private AnchorPane tfAjouCat;
    @FXML
    private Label tfIdCategorie;
    @FXML
    private Label tfLabel;
    @FXML
    private Button tfAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterUneCategorie(ActionEvent event) {
        CategorieService Cs = new CategorieService ();
        int a=Integer.parseInt(tfIdCategorie.getText());
     Cs.ajouter(new Categorie (a,tfLabel.getText()));
     JOptionPane.showMessageDialog(null,"Categorie ajouté!");
     
    }
    
}
