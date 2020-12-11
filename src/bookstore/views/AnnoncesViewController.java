/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import bookstore.entities.Annonce;
import bookstore.viewsControllers.BaseController;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AnnoncesViewController extends BaseController implements Initializable {

    public AnnoncesViewController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }

    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableView<?> fxTableAnnonces;
    @FXML
    private TableColumn<Annonce, String> datepublicationcell;
    @FXML
    private TableColumn<Annonce, Float> prixcell;
    @FXML
    private TableColumn<Annonce, String> etatcell;
    @FXML
    private TableColumn<Annonce, String> dateachatcell;

    private ObservableList<Annonce> ob;
    
      @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
  
      @FXML
    private Button btn_panier;
    @FXML
    private Button logOut;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private Button myAccountButton;
@FXML
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }
    /*
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
    */
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
    }
    /*
    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }*/
     @FXML
    void panier(ActionEvent event) {
        vf.showPanier();
    }
    
    
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
    
}
