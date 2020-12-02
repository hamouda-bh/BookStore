/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.viewsControllers;

/**
 *
 * @author PC-Hamouda
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import bookstore.views.ViewFactory;
import bookstore.Testing.DBConnection;
public class EditAccountController extends BaseController implements Initializable {

    public EditAccountController(ViewFactory viewFactory, String fxmlName) {
		super(viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private TextField nameField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telField;

    @FXML
    private TextField photoField;

    @FXML
    private TextField adressField;

    @FXML
    private PasswordField passwordField;
    @FXML
    private Button editButton;

    @FXML
    void editButtonAction() {
    	Connection cnx = DBConnection.getInstance().getCnx();
    	String req = "UPDATE client SET nom='"+nameField.getText()+"',prenom='"+prenomField.getText()+"',username='"+userNameField.getText()+"',email='"+emailField.getText()+"',tel='"+telField.getText()+"',photo='"+photoField.getText()+"',password='"+passwordField.getText()+"',adresse='"+adressField.getText()+"' WHERE id_client=50 ";
    	try {
    		Statement st = cnx.createStatement();	  		  
  		    st.executeUpdate(req);
  		    vf.showMainWindow();
			
    	}catch(Exception e){
    		e.printStackTrace();
    		e.getCause();		
    	}

  	  
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}