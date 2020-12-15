/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import bookstore.services.ClientService;
import bookstore.views.ViewFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Malek
 */
public class PasswordController extends BaseController implements Initializable{
    public PasswordController(ViewFactory vf , String FxmlName){
       super(vf,FxmlName);
    }
   @FXML
    private Button codeText;

    @FXML
    private TextField passField;
  
    
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void codebtnAction(ActionEvent event) throws IOException {
        Connection cnx = DBConnection.getInstance().getCnx();
        ClientService cs = new ClientService();
        //cs.updatePassword(new Client(passField.getText(),"text"),MailWindowController.mailField.getText());
        
        JOptionPane.showMessageDialog(null, "Pwd changed with succes");
    
            vf.showLoginWindow();
    }
}


