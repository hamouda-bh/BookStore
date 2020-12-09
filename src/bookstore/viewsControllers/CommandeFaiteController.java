package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javax.swing.Icon;

public class CommandeFaiteController extends BaseController {
    

    public CommandeFaiteController(ViewFactory vf, String fxmlName)
   {
       super(vf,fxmlName);
   }
    @FXML
    private Icon imprimer_icon_id;

    @FXML
    private Icon mail_icon_id;

    @FXML
    private Icon telecharger_icon_id;

    @FXML
    private Text telecharger_id;

    @FXML
    private Text mail_id;

    @FXML
    private Text imprimer_id;

    @FXML
    private Button retour_btn_id;

}