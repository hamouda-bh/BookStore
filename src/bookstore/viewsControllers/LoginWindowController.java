/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.viewsControllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.*;
import bookstore.Testing.DBConnection;
import bookstore.views.ViewFactory;
/**
 *
 * @author PC-Hamouda
 */
public class LoginWindowController extends BaseController {

    public LoginWindowController(ViewFactory vf, String fxmlName) {
		super(vf, fxmlName);
		
	}
	@FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginField;
    
   @FXML
    private Button registerField;


    @FXML
    void loginButton(ActionEvent evt) {
         if (emailField.getText().isEmpty()==false && passwordField.getText().isEmpty()== false) {
        	validateLogin();
         }else 
        	 System.out.println("error");
    }
    public void validateLogin() {
    	Connection cnx = DBConnection.getInstance().getCnx();
    	String verifyLogin = "SELECT COUNT(1) FROM client WHERE email = '"+emailField.getText()+"' AND password = '"+passwordField.getText()+"' "  ;   
    	
    	
    	try {
    		Statement st = cnx.createStatement();			  
			ResultSet res = st.executeQuery(verifyLogin);
			while(res.next()) {
              if(res.getInt(1)==1) {
                	System.out.println("succes");
                	vf.showMainWindow();
                	Stage stage = (Stage) emailField.getScene().getWindow();
                	vf.closeStage(stage);
              }else {
                 	System.out.println("error");
              }
			}
    	}catch(Exception e){
    		e.printStackTrace();
    		e.getCause();
    		
    	}
    }
    @FXML
    void registerButtonAction() {
    	vf.showRegisterWindow();
    }

}