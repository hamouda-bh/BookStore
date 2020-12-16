/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.entities.Annonce;
import bookstore.services.ServiceAnnonce;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AMesAnnoncesViewController extends BaseController implements Initializable {

    public AMesAnnoncesViewController(ViewFactory vf, String fxmlName) {
       super(vf, fxmlName);
    }
    
    @FXML
    private Button modifierUneAnnonce;
    @FXML
    private Button AjouterUneAnnonce;
    @FXML
    private Button SupprimerUneAnnonce;
    @FXML
    private TextField findAnnonce;
    @FXML
    private Button btnChercher;
    @FXML
    private TableView<Annonce> tvMesAnnonces;
    @FXML
    private TableColumn<Annonce, String> tcDatePublication;
    @FXML
    private TableColumn<Annonce, Float> tcPrix;
    @FXML
    private TableColumn<Annonce, String> tcEtat;
    @FXML
    private TableColumn<Annonce, String> tcDateAchat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcDatePublication.setCellValueFactory(new PropertyValueFactory<>("date_publication"));
        tcPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tcDateAchat.setCellValueFactory(new PropertyValueFactory<>("date_achat"));
        ServiceAnnonce sa = new ServiceAnnonce();
        tvMesAnnonces.setItems(sa.afficherMesAnnonces());
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
    private void afficherAnnonce(ActionEvent event) {
    }
    
}
