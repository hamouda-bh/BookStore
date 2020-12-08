/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Annonce;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AnnoncesViewController implements Initializable {

    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableView<?> fxTableAnnonces;
    @FXML
    private TableColumn<?, ?> datepublicationcell;
    @FXML
    private TableColumn<?, ?> prixcell;
    @FXML
    private TableColumn<?, ?> etatcell;
    @FXML
    private TableColumn<?, ?> dateachatcell;

    private ObservableList<Annonce> ob;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ob = FXCollections.observableArrayList();
        
        datepublicationcell.setCellValueFactory(new PropertyValueFactory<>("date_publication"));
        prixcell.setCellValueFactory(new PropertyValueFactory<>("prix"));
        etatcell.setCellValueFactory(new PropertyValueFactory<>("etat_de_livre"));
        dateachatcell.setCellValueFactory(new PropertyValueFactory<>("date_achat"));
        
        fxTableAnnonces.setItems(null);
    }    

    @FXML
    private void ajouterAnnonce(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AAjoutAnnonceView.fxml"));
        Parent root = loader.load();
        
        AjouterUneNouvelleAnnonce.getScene().setRoot(root);
    }
    
}
