/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class PasserCommandeController extends BaseController implements Initializable {
    public PasserCommandeController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

    @FXML
    private TextField inputId;
    @FXML
    private CheckBox check1_id;
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
    private CheckBox check2_id;
    @FXML
    private Button confirm_btn_id;
    @FXML
    private Button annuler_btn_id;
    @FXML
    private ToggleButton btn_code_id;
    @FXML
    private TableColumn<?, ?> nomlivre_id;
    @FXML
    private TableColumn<?, ?> pic_id;
    @FXML
    private TableColumn<?, ?> nomlivre_id2;
    @FXML
    private TableColumn<?, ?> nomlivre_id21;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void onCliqAnnuler(ActionEvent event) {
            vf.showPanier();
    }

    @FXML
    void onCliqConfirmer(ActionEvent event) {
            vf.showPaiement();
    }
    
}
