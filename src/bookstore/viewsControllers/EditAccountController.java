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
import javafx.stage.Stage;
import bookstore.views.ViewFactory;
import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
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
    private TextField adressField;
    
    @FXML
    private Button editButton;
    @FXML
    private Button cancelButton;


    @FXML
    void editButtonAction() {
    	Connection cnx = DBConnection.getInstance().getCnx();
    	String req = "UPDATE client SET nom='"+nameField.getText()+"',prenom='"+prenomField.getText()+"',username='"+userNameField.getText()+"',email='"+emailField.getText()+"',tel='"+telField.getText()+"',adresse='"+adressField.getText()+"' WHERE id_client= "+Cache.client.getId_user();
    	try {
    		Statement st = cnx.createStatement();	  		  
  		    st.executeUpdate(req);
  		    Cache.client =  new Client(Cache.client.getId_user(),
  		    	nameField.getText().toString(),
  		    	prenomField.getText().toString(),
  		    	userNameField.getText().toString(),
  		    	emailField.getText().toString(),
  		    	telField.getText().toString(), 		    	  		    	
  		    	adressField.getText().toString());
  		    	
  		    
  		    vf.showMainWindow();
  		    Stage stage = (Stage) prenomField.getScene().getWindow();
  	        vf.closeStage(stage);
  		    
			
    	}catch(Exception e){
    		e.printStackTrace();
    		e.getCause();		
    	}

  	  
    }
    
    @FXML
    void cancelButtonAction() {
    	vf.showMainWindow();
	    Stage stage = (Stage) nameField.getScene().getWindow();
	    vf.closeStage(stage);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameField.setText(Cache.client.getNom());
		prenomField.setText(Cache.client.getPrenom());
		userNameField.setText(Cache.client.getUsername());
		emailField.setText(Cache.client.getEmail());
		telField.setText(Cache.client.getTel());			
		adressField.setText(Cache.client.getAdress());
	
	}
}