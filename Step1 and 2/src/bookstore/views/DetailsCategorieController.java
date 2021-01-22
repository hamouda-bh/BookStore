/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Categorie;
import bookstore.services.CategorieService;
import bookstore.viewsControllers.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsCategorieController extends BaseController implements Initializable  {
    public DetailsCategorieController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName); 
    }
    

 @FXML
    private TableView<Categorie> details;

    @FXML
    private TableColumn<Categorie,String> idcat;
    @FXML
    private TableColumn<Categorie,String> label;
    @FXML
    private Button supp;
    @FXML
    private Button modif;

    /**
     * Initializes the controller class.
     */
    
   
private ObservableList<Categorie> Categorie = FXCollections.observableArrayList();

    CategorieService cs = new CategorieService();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        idcat.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getId_categorie())));
        label.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLabel()));
 
        Categorie.addAll(cs.afficher());
        System.out.println(Categorie);
        details.setItems(Categorie);
}
    @FXML
    private void supprimerCategorie(ActionEvent event) {
          Categorie orderSelected= details.getSelectionModel().getSelectedItem();
        CategorieService cs = new CategorieService ();
       cs.supprimerCategorie(orderSelected.getId_categorie());
      // UpdateTable();
       //JOptionPane.showMessageDialog(null,"Livre supprimé !");
       details.getItems().clear();
    idcat.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getId_categorie())));
        label.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLabel()));
       
         Categorie.addAll(cs.afficher());
        System.out.println(Categorie);
        details.setItems(Categorie);
    }
    

    @FXML
    private void modifierCategorie(ActionEvent event) {
    }
    
}