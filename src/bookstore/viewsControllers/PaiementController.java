package bookstore.viewsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PaiementController {

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

}
