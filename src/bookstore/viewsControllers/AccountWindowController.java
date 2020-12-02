/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.viewsControllers;

import bookstore.Testing.DBConnection;
import bookstore.views.ViewFactory;
import java.sql.Connection;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author PC-Hamouda
 */
public class AccountWindowController extends BaseController {

	public AccountWindowController(ViewFactory vf, String fxmlName) {
		super(vf, fxmlName);
		// TODO Auto-generated constructor stub
	}
	
	
	    @FXML
	    private Button editButton;
	    @FXML
	    private Button deleteButton;

	    @FXML
	    void deleteButtonAction() {
	    	Connection cnx = DBConnection.getInstance().getCnx();
	    	String req = "DELETE from client WHERE id_client=52 ";
	    	try {
	    		Statement st = cnx.createStatement();	  		  
	  		    st.executeUpdate(req);
	  		    vf.showLoginWindow();
	  		    Stage stage = (Stage) editButton.getScene().getWindow();
          	    vf.closeStage(stage);
				
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		e.getCause();		
	    	}
	    }

	    @FXML
	    void editButttonAction() {
            vf.showAccountEditWindow();
	    }

	


}
