package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class GererPanierController extends BaseController{

   public GererPanierController(ViewFactory vf, String fxmlName)
   {
       super(vf,fxmlName);
   }
    
    @FXML
    private Button passerC_btn_id;

    @FXML
    private TableColumn<?, ?> nomlivre_id;

    @FXML
    private TableColumn<?, ?> pic_id;

    @FXML
    private TableColumn<?, ?> nomlivre_id1;

    @FXML
    private TableColumn<?, ?> nomlivre_id2;

    @FXML
    private TableColumn<?, ?> nomlivre_id21;

   @FXML
    void onCliqPasserCommande() {
        vf.showCommandeForm();
    }  
}

