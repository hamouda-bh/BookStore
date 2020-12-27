/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.entities.Client;
import bookstore.services.ClientService;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Malek
 */
public class DetailsController extends BaseController implements Initializable {
    public DetailsController(ViewFactory vf, String FxmlName){
       super (vf , FxmlName);
}
    
 @FXML
    private TableView<Client> idTable;
     @FXML
    private TableColumn<Client, String> id;
    @FXML
    private TableColumn<Client, String> nameTable;

    @FXML
    private TableColumn<Client, String> lastNameTable;

    @FXML
    private TableColumn<Client, String> userNameTable;

    @FXML
    private TableColumn<Client, String> emailTable;

    @FXML
    private TableColumn<Client, String> passwordTable;

    @FXML
    private TableColumn<Client, String> adressTable;
    
     private ObservableList<Client> clientData = FXCollections.observableArrayList();

    ClientService us = new ClientService();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getId_user())));
        nameTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        lastNameTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrenom()));
        userNameTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUsername()));
        emailTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        passwordTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPassword()));
        adressTable.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAdress()));

        clientData.addAll(us.getList());
        System.out.println(clientData);
        idTable.setItems(clientData);

       // idTableView.getSelectionModel().selectedItemProperty().addListener((a, b, c) -> showPersonDetails(c));

    }

    
    
}
