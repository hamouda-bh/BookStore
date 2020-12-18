
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Annonce;
import bookstore.entities.Client;
import bookstore.viewsControllers.BaseController;
import bookstore.services.ServiceAnnonce;
import bookstore.utils.JavaMailZay;
import bookstore.views.ViewFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AAnnoncesViewController extends BaseController implements Initializable {

    public AAnnoncesViewController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }
   
    @FXML
    private RadioButton btnMailing;

    @FXML
    public TableView<Annonce> fxTableAnnonces;
    @FXML
    private TableColumn<Annonce, String> datepublicationcell;
    @FXML
    private TableColumn<Annonce, Float> prixcell;
    @FXML
    private TableColumn<Annonce, String> etatcell;
    @FXML
    private TableColumn<Annonce, String> dateachatcell;
    
    @FXML
    private Button fxmesannonces;
    @FXML
    private Button AjouterUneNouvelleAnnonce;
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
    private Button myAccountButton;
    
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        datepublicationcell.setCellValueFactory(new PropertyValueFactory<>("date_publication"));
        prixcell.setCellValueFactory(new PropertyValueFactory<>("prix"));
        etatcell.setCellValueFactory(new PropertyValueFactory<>("etat_de_livre"));
        dateachatcell.setCellValueFactory(new PropertyValueFactory<>("date_achat"));  
        ServiceAnnonce sa = new ServiceAnnonce();
        fxTableAnnonces.setItems(sa.afficherAnnonces());

    }
    @FXML
    private void ajouterAnnonce(ActionEvent event) throws IOException {
        vf.showAjoutAnnonces();
    }
    @FXML
    private void mesAnnonces(ActionEvent event) throws IOException {
        vf.showMesAnnonces();
        }
    @FXML
    private void actualiser(ActionEvent event) throws IOException {
       ServiceAnnonce sa = new ServiceAnnonce();
       fxTableAnnonces.getItems().clear();
       fxTableAnnonces.setItems(sa.afficherAnnonces()); 
    }
    @FXML
    private void activeMailing(ActionEvent event) throws Exception {
        JavaMailZay.mailSending("medaziz.louzir@esprit.tn");
    }
    @FXML
    void logOutAction() {
        Cache.client = null;
        Stage stage = (Stage) logOut.getScene().getWindow();
        vf.closeStage(stage);
        vf.showLoginWindow();
    }
//    void myAccountAction() {
//        vf.showAccountEditWindow();
//        Stage stage = (Stage) logOut.getScene().getWindow();
//  	    vf.closeStage(stage);
//    }
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
    }
    @FXML
    private void goLivre() {

        vf.showLivre();
    }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
    }
//    @FXML
//    void myAccountAction() {
//        vf.showAccountEditWindow();
//        Stage stage = (Stage) logOut.getScene().getWindow();
//  	    vf.closeStage(stage);
//    }
    @FXML
    void panier(ActionEvent event) {
        vf.showPanier();
    }

}
