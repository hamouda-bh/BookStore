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
import java.sql.Statement;

import bookstore.views.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;

	
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
	    private TextField photoField;

	    @FXML
	    private TextField adressField;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    void registerButtonAction() {
	    	Connection cnx = DBConnection.getInstance().getCnx();
	    	String req = "INSERT INTO client (nom, prenom, username, email, tel, photo, password, adresse) VALUES ('"+nameField.getText()+"','"+prenomField.getText()+"','"+userNameField.getText()+"','"+emailField.getText()+"','"+telField.getText()+"','"+photoField.getText()+"','"+adressField.getText()+"','"+passwordField.getText()+"')";
	    	try {
	    		Statement st = cnx.createStatement();	  		  
	  		    st.executeUpdate(req);
	  		    System.out.println("F�licitations !");
				
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		e.getCause();		
	    	}

	    }

}	