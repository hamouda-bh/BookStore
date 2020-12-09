/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class CommandeFaiteController extends BaseController implements Initializable {
    
    public CommandeFaiteController(ViewFactory vf, String fxmlName)
   {
       super(vf,fxmlName);
   }

    @FXML
    private Text telecharger_id;
    @FXML
    private Text mail_id;
    @FXML
    private Text imprimer_id;
    @FXML
    private Button retour_btn_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
