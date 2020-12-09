package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class PasserCommandeController extends BaseController{


     public PasserCommandeController(ViewFactory vf, String fxmlName)
   {
       super(vf,fxmlName);
   }
     @FXML
    private TextField inputId;

    @FXML
    private CheckBox check1_id;

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
    
    @FXML
    void onCliqAnnuler(ActionEvent event) {
            vf.showPanier();
    }

    @FXML
    void onCliqConfirmer(ActionEvent event) {
            vf.showCommandeFaite();
    }
    
}
