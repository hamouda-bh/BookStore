/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;
import bookstore.views.ViewFactory;
import bookstore.viewsControllers.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LivreController extends BaseController implements Initializable {
    public LivreController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

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
    private Button btnSettings;
    @FXML
    private Button logOut;
    @FXML
    private Pane pnlCustomer1;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private Button tfAjouut;
    @FXML
    private Button tfModif;
    @FXML
    private Button tfSupp;
    @FXML
    private Pane pnlCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks() {
    }

    @FXML
    private void logOutAction() {
    }

    @FXML
    private void ajoute() {
        vf.showAjoutLivre();
    }

    @FXML
    private void Modifierunlivre() {
        
    }

    @FXML
    private void Supprimerunlivre() {
    }
    
}
