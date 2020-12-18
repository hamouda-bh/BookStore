/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.entities.Annonce;
import bookstore.services.ServiceAnnonce;
import bookstore.views.ViewFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AAjoutAnnonceViewController extends BaseController implements Initializable {
    
    public AAjoutAnnonceViewController(ViewFactory vf, String fxmlName) {
       super(vf, fxmlName);
    }

    @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker tfdate_publication;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfetat;
    @FXML
    private DatePicker tfdateachat;

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
        sa.ajouterAnnonce(new Annonce(tfdate_publication.getValue().toString(),tfprix.getText(),tfetat.getText(),tfdateachat.getValue().toString()));
        JOptionPane.showMessageDialog(null,"Annonce ajoutée !");
        
    }
    
}
