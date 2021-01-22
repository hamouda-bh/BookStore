/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;
import javafx.scene.control.Alert;

import bookstore.Testing.Cache;
import bookstore.entities.Blog;
import bookstore.services.serviceBlog;
import bookstore.utils.TrayIconDemo;
import bookstore.viewsControllers.BaseController;
import bookstore.viewsControllers.DetailsBlogController;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    /*
    private boolean validatecategorie(){
        Pattern p = Pattern.compile("[a-z A-Z]+");
        Matcher m = p.matcher(tfcategorie.getText());
        if(m.find() && m.group().equals(tfcategorie.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate categorie");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer une categorie valide");
                alert.showAndWait();
            
            return false;            
        }
    }
     private boolean validatedescription(){
        Pattern p = Pattern.compile("[a-z A-Z]+");
        Matcher m = p.matcher(tfdescription.getText());
        if(m.find() && m.group().equals(tfdescription.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate categorie");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer une categorie valide");
                alert.showAndWait();
            
            return false;            
        }
    }
     
      private boolean validateidb(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tfidc.getText());
        if(m.find() && m.group().equals(tfdescription.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate categorie");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer une categorie valide");
                alert.showAndWait();
            
            return false;            
        }
    }
      
       private boolean validateidc(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tfid.getText());
        if(m.find() && m.group().equals(tfdescription.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate categorie");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer une categorie valide");
                alert.showAndWait();
            
            return false;            
        }
    }*/
    Alert alert=new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void ajouterBlog(ActionEvent event) throws IOException, AWTException {
        int a=0;
        int b=0;
      try{   a = Integer.parseInt(tfid.getText());
                 b = Integer.parseInt(tfidc.getText());
      } catch (NumberFormatException ex){
        }
      
          if((!"".equals(a))&&(!"".equals(b))&&(!"".equals(tfcategorie.getText()))&&(!"".equals(tfdescription.getText()))){

        serviceBlog sb = new serviceBlog();
        sb.ajouter(new Blog(a,b,tfcategorie.getText(),tfdescription.getText()));
                                          JOptionPane.showMessageDialog(null, "blog ajouté");

        
         if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTrayblog();
            System.err.println("notiiiifff");
        } else {
            System.err.println("Erreur!!!!");
        }
         }
        else if(("".equals(a))||("".equals(b))||("".equals(tfcategorie.getText()))||("".equals(tfdescription.getText()))){
        {
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("type valide information !");
            alert.showAndWait();
        }

        }

    }
      // vf.showAblog();
        /*
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsBlog.fxml"));
        
        Parent root = loader.load();
        
        tfid.getScene().setRoot(root);
        
        DetailsBlogController dbc = loader.getController();
     
        dbc.setLbid(a);
        dbc.setLbidc(b);
        dbc.setLbcategorie(tfcategorie.getText());
        dbc.setLbdescription(tfdescription.getText());
vf.showDetailsBlog();*/


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
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    }
    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void logOutAction(ActionEvent event) {
    }
    
}