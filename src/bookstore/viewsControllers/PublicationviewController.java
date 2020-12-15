/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.Blog;
import bookstore.entities.Publication;
import bookstore.services.serviceBlog;
import bookstore.services.servicePublication;
import bookstore.views.ViewFactory;
import bookstore.viewsControllers.DetailsPublicationController;
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
public class PublicationviewController extends BaseController implements Initializable {

    public PublicationviewController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }

    @FXML
    private TextField tfidp;
    @FXML
    private TextField tfidb;
    @FXML
    private TextField tfidc;
    @FXML
    private TextField tfcontenue;
    @FXML
    private TextField tfcommentaire;
    @FXML
    private Button btn;
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
    private Button btn_panier;
    @FXML
    private Button logOut;
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
    private void ajouterPublication(ActionEvent event) throws IOException {
         int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());

        servicePublication sp = new servicePublication();
        sp.ajouter(new Publication(a,b,c,tfcontenue.getText(),tfcommentaire.getText()));
        JOptionPane.showMessageDialog(null, "Publication ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsPublication.fxml"));
        
        Parent root = loader.load();
        
        tfidb.getScene().setRoot(root);
        
        DetailsPublicationController dpc = loader.getController();
     
        dpc.setLbidb(a);
        dpc.setLbidc(b);
        dpc.setLbidp(c);

        dpc.setLbcontenue(tfcontenue.getText());
        dpc.setLbcommentaire(tfcommentaire.getText());
    }

    private void modifierPublication(ActionEvent event) throws IOException {

       int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());
            servicePublication sp = new servicePublication();
        sp.ajouter(new Publication(a,b,c,tfcontenue.getText(),tfcommentaire.getText()));
        JOptionPane.showMessageDialog(null, "Publication modifiée !");

    }
     private void supprimerPublication(ActionEvent event) throws IOException {
       int a = Integer.parseInt(tfidb.getText());
                  int c = Integer.parseInt(tfidp.getText());

                int b = Integer.parseInt(tfidc.getText());
            servicePublication sp = new servicePublication();
        sp.supprimer(new Publication(a,b,c,"",""));
        JOptionPane.showMessageDialog(null, "Publication supprimée !");
    }
}
