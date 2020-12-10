package bookstore.viewsControllers;

import bookstore.services.FactureService;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PaiementController extends BaseController implements Initializable{
    public PaiementController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

    @FXML
    private TextField nom_id;

    @FXML
    private TextField tel_id;

    @FXML
    private TextField prenom_id;

    @FXML
    private TextField adresse_id;

    @FXML
    private TextField code_id;

    @FXML
    private TextField num_compte_id;

    @FXML
    private Button payer_btn_id;

    @FXML
    private Button annuler_btn_id;

    @FXML
    private CheckBox check_bancaire_id;

    @FXML
    private CheckBox check_postale_id;
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void onCliqPayer(ActionEvent event) {
            vf.showCommandeFaite();
         //   FactureService f = new FactureService();
        //    f.ajouter(p, c);
    }
}
