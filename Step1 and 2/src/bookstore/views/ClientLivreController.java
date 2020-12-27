/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Livre;
import bookstore.services.livreService;
import bookstore.viewsControllers.BaseController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author user
 */
public class ClientLivreController extends BaseController implements Initializable  {
    public ClientLivreController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
 
    @FXML
    private TableView<Livre> livreClient;
    @FXML
    private TableColumn<Livre, String> Titre;
    @FXML
    private TableColumn<Livre, String> Auteur;
    @FXML
   private TableColumn<Livre, String> Id_livre;
    @FXML
    private TableColumn<Livre, String> Prix;
    @FXML
    private TableColumn<Livre, String> Image;
    @FXML
    private Button tfSupp ;
     @FXML
    private Button tfmodif ;
      
     public void UpdateTable(){
         livreService ls = new livreService ();
         List<Livre> ab =new ArrayList<>();
         ab = ls.afficher();
         ObservableList<Livre>list=FXCollections.observableArrayList();
         livreClient.setItems(list);
     }

    /**
     * Initializes the controller class.
     */
   /* public void initialize(URL url, ResourceBundle rb) {
         livreService ls = new livreService();
        ArrayList ab;
        ab = (ArrayList) ls.afficher();
        Prix.setCellValueFactory(new PropertyValueFactory<Livre, Float>("prix"));
        Image.setCellValueFactory(new PropertyValueFactory<Livre, String>("Image"));
        Auteur.setCellValueFactory(new PropertyValueFactory<Livre, String>("Auteur"));
        Titre.setCellValueFactory(new PropertyValueFactory<Livre, String>("Titre"));
              
           // label.setCellValueFactory(new PropertyValueFactory<Livre, String>("label"));
    }    
    public ObservableList<Livre> getItems() {
        ObservableList<Livre> list = FXCollections.observableArrayList();
        livreService ls = new livreService();
        list.addAll(ls.afficher());
        livreClient.setItems(list);
        return list;
    }
    */
    private ObservableList<Livre> clientData = FXCollections.observableArrayList();

    livreService us = new livreService();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        Prix.setCellValueFactory(l -> new SimpleStringProperty(String.valueOf(l.getValue().getPrix())));
        Titre.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getTitre()));
        Auteur.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getAuteur()));
       Image.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getImage()));
       Id_livre.setCellValueFactory(l -> new SimpleStringProperty(String.valueOf(l.getValue().getId_livre())));
        //Prix.setCellValueFactory(l-> new SimpleStringProperty(c.getValue().getPrix()));
        clientData.addAll(us.afficher());
        System.out.println(clientData);
        livreClient.setItems(clientData);
}
    
@FXML
    private void Supprimerunlivre (ActionEvent event) throws IOException {
        Livre orderSelected= livreClient.getSelectionModel().getSelectedItem();
        livreService ls = new livreService ();
       ls.Supprimer(orderSelected);
      // UpdateTable();
       //JOptionPane.showMessageDialog(null,"Livre supprimé !");
       livreClient.getItems().clear();
     Prix.setCellValueFactory(l -> new SimpleStringProperty(String.valueOf(l.getValue().getPrix())));
        Titre.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getTitre()));
        Auteur.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getAuteur()));
       Image.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getImage()));
       Id_livre.setCellValueFactory(l -> new SimpleStringProperty(String.valueOf(l.getValue().getId_livre())));
        //Prix.setCellValueFactory(l-> new SimpleStringProperty(c.getValue().getPrix()));
         clientData.addAll(us.afficher());
        System.out.println(clientData);
        livreClient.setItems(clientData);
    }
    @FXML
     private void modunlivre (ActionEvent event) throws IOException {
        Livre orderSelected= livreClient.getSelectionModel().getSelectedItem();
        livreService ls = new livreService ();
       ls.modifier(orderSelected);
       UpdateTable();
     JOptionPane.showMessageDialog(null,"Livre modifié !");
    }
}