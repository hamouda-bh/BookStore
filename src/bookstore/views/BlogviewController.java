/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import bookstore.entities.Blog;
import bookstore.services.serviceBlog;
import bookstore.viewsControllers.BaseController;
import bookstore.viewsControllers.DetailsBlogController;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class BlogviewController extends BaseController implements Initializable {
    public BlogviewController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

    @FXML
    private TextField tfid;
    @FXML
    private Button btn;
    @FXML
    private TextField tfidc;
    @FXML
    private TextField tfcategorie;
    @FXML
    private TextField tfdescription;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button logOut;
  
      @FXML
    private Button btn_panier;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private Button myAccountButton;
@FXML
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }
    /*
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
    */
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
    }
    /*
    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }*/
     @FXML
    void panier(ActionEvent event) {
        vf.showPanier();
    }
    /**
     * Initializes the controller class.
     */
    @Override
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

    @FXML
    private void modifierBlog(ActionEvent event) {
        int a = Integer.parseInt(tfid.getText());
                int b = Integer.parseInt(tfidc.getText());
            serviceBlog sb = new serviceBlog();
        sb.modifier(new Blog(a,b,tfcategorie.getText(),tfdescription.getText()));
    }

    @FXML
    private void suppressionBlog(ActionEvent event) {
         int a = Integer.parseInt(tfid.getText());
                int b = Integer.parseInt(tfidc.getText());
            serviceBlog sb = new serviceBlog();
        sb.supprimer(new Blog(a,b,"",""));
    }
@FXML
    private void newPub(ActionEvent event) {
        vf.showPublication();
    }
    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void logOutAction(ActionEvent event) {
    }
    
}