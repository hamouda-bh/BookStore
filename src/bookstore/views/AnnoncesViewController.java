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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AnnoncesViewController implements Initializable {

    @FXML
    private Button fxmesannonces;
    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableView<Annonce> fxTableAnnonces;
    @FXML
    private TableColumn<Annonce, String> datepublicationcell;
    @FXML
    private TableColumn<Annonce, Float> prixcell;
    @FXML
    private TableColumn<Annonce, String> etatcell;
    @FXML
    private TableColumn<Annonce, String> dateachatcell;

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
        
        fxTableAnnonces.setItems(ob);
    }    

    @FXML
    private void ajouterAnnonce(ActionEvent event) throws IOException {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("AAjoutAnnonceView.fxml"));
        Stage st = new Stage();
        st.setTitle("BookStore : Toute les annonces");
        st.setScene(new Scene(root,450,450));
        st.show();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    private void mesAnnonces(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AMesAnnonces.fxml"));
        fxmesannonces.getScene().setRoot(root);
    }
}
