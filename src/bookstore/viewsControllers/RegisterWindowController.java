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
import bookstore.Testing.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import bookstore.views.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

	
public class RegisterWindowController extends BaseController {
	
    public RegisterWindowController(ViewFactory vf, String fxmlName) {
		super(vf, fxmlName);
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
    private PasswordField passwordField;
    @FXML
    private Button cancelButton;
	
    @FXML
    void registerButtonAction(ActionEvent event) {
    	
    	if (validateEmail() & validateNom() & validatePassword() & validatePrenom() & validateTel() & validateFields())	
    	
    	//----------------------------------------------------------------
    	
    	
    	try {
    		Connection cnx = DBConnection.getInstance().getCnx();
        	String req = "INSERT INTO client (nom, prenom, username, email, tel,password, adresse) VALUES ('"+nameField.getText()+"','"+prenomField.getText()+"','"+userNameField.getText()+"','"+emailField.getText()+"','"+telField.getText()+"','"+BCrypt.hashpw(passwordField.getText(),BCrypt.gensalt ())+"','"+adressField.getText()+"')";
    		Statement st = cnx.createStatement();	  		  
  		    st.executeUpdate(req);
  		    System.out.println("Felicitations votre compte a ete creer!");
  		    vf.showLoginWindow();
		    Stage stage = (Stage) emailField.getScene().getWindow();
    	    vf.closeStage(stage);
			
    	}catch(SQLException ex){
    		System.out.println("Mail dupliqué");		
    	}catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	}
    }
    

    @FXML
    void cancelButtonAction(ActionEvent event) {
    	vf.showLoginWindow();
	    Stage stage = (Stage) emailField.getScene().getWindow();
	    vf.closeStage(stage);
    }
    private boolean validateEmail() {
    	Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
    	Matcher m = p.matcher(emailField.getText());
    	if (m.find() && m.group().equals(emailField.getText())){
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate Email");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter Valid Email");
    		alert.showAndWait();
    		return false;
    	}
    }
    private boolean validateTel() {
    	Pattern p = Pattern.compile("[2-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]+");
    	Matcher m = p.matcher(telField.getText());
    	if (m.find() && m.group().equals(telField.getText())){
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate number");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter Valid Tel Number");
    		alert.showAndWait();
    		return false;
    	}
    }
    private boolean validateNom() {
    	Pattern p = Pattern.compile("[a-zA-Z]+");
    	Matcher m = p.matcher(nameField.getText());
    	if (m.find() && m.group().equals(nameField.getText())){
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate name");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter Valid name ");
    		alert.showAndWait();
    		return false;
    	}
    }
    private boolean validatePrenom() {
    	Pattern p = Pattern.compile("[a-zA-Z]+");
    	Matcher m = p.matcher(prenomField.getText());
    	if (m.find() && m.group().equals(prenomField.getText())){
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate prenom");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter Valid prenom ");
    		alert.showAndWait();
    		return false;
    	}
    }
    private boolean validatePassword() {
    	Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
    	Matcher m = p.matcher(passwordField.getText());
    	if (m.find() && m.group().equals(passwordField.getText())){
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate password");
    		alert.setHeaderText(null);
    		alert.setContentText("Password must contain at least one(Digit,Lowercase, Uppercase and Specials charac");
    		alert.showAndWait();
    		return false;
    	}
    }
    private boolean validateFields() {   	
    	if (nameField.getText().isEmpty() | prenomField.getText().isEmpty() | userNameField.getText().isEmpty() | 
    		emailField.getText().isEmpty() | telField.getText().isEmpty() |  adressField.getText().isEmpty() | passwordField.getText().isEmpty() ) {
    	
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate fields");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter into fields ");
    		alert.showAndWait();
    		
    		return false;
    	}else
    		return true;
    }
    
}	