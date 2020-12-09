/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class LivreKidsController extends BaseController implements Initializable {

    @FXML
    private AnchorPane PageKidsBooks;

    @FXML
    private Button addKidsBook;

    @FXML
    private Button editBook;

    @FXML
    private JFXTextField SeachFieldKidsBooks;

    @FXML
    private TableView<?> KidsBooksList;

    public LivreKidsController(ViewFactory vf, String fxmlName) {
        super(vf,fxmlName);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
