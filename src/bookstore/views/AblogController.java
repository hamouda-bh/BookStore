/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.entities.Blog;
import bookstore.services.serviceBlog;
import bookstore.viewsControllers.BaseController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class AblogController  extends BaseController implements Initializable {
    public AblogController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

    @FXML
    private TableView<Blog> tawla;
    @FXML
    private TableColumn<Blog, String> columncat;
    @FXML
    private TableColumn<Blog, String> columndesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        columncat.setCellValueFactory(new PropertyValueFactory<>("categorie_blog"));
        columndesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        
serviceBlog sb = new serviceBlog();

tawla.setItems(sb.afficherBlog());

    }    
     
   
    
   /* @FXML
    private void actualiser (ActionEvent event) throws IOException {
       serviceBlog sb = new serviceBlog();
       tawla.getItems().clear();
       tawla.setItems(sb.afficherBlog()); 
    }*/
}
