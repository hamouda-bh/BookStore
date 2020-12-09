/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.entities.Blog;
import bookstore.services.serviceBlog;
import bookstore.views.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class BlogviewController extends BaseController implements Initializable {

    @FXML
    private TextField tfid;
    
    @FXML
    private TextField tfidc;
    
    @FXML
    private TextField tfcategorie;
    
    @FXML
    private TextField tfdescription;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterBlog(ActionEvent event) throws IOException {
        int a = Integer.parseInt(tfid.getText());
                int b = Integer.parseInt(tfidc.getText());

        serviceBlog sb = new serviceBlog();
        sb.ajouter(new Blog(a,b,tfcategorie.getText(),tfdescription.getText()));
        JOptionPane.showMessageDialog(null, "blog ajouté");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsBlog.fxml"));
        
        Parent root = loader.load();
        
        tfid.getScene().setRoot(root);
        
        DetailsBlogController dbc = loader.getController();
     
        dbc.setLbid(a);
        dbc.setLbidc(b);
        dbc.setLbcategorie(tfcategorie.getText());
        dbc.setLbdescription(tfdescription.getText());
    }
    
}