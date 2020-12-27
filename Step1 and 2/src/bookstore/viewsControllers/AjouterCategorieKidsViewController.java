/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.Testing.MailApi;
import bookstore.entities.CategorieKids;
import bookstore.services.CategorieKidsService;
import bookstore.viewsControllers.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import bookstore.Testing.Cache;
import static bookstore.Testing.Cache.client;
import bookstore.Testing.*;
import bookstore.views.ViewFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;


/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class AjouterCategorieKidsViewController extends BaseController implements Initializable {
    public AjouterCategorieKidsViewController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);    
    }
    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField Nom_categorie_field;

    @FXML
    private Button Annuler;

    @FXML
    private Button AjouterCategorie;

    @FXML
    private TextField Description_categorie_field;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button myAccountButton;

    @FXML
    private Button tflivre;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btn_panier;

    @FXML
    private Button goToEspaceKids;

    @FXML
    private Button logOut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
        @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace(); 
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }

    @FXML
    void goBlog() {
        vf.showBlog();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }

    @FXML
    void goLivre() {
        vf.showLivre();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
         
    }

    @FXML
    void logOutAction() {
        Cache.client = null ;
    	vf.showLoginWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	
    }

    @FXML
    void panier() {
        vf.showPanier();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }
    private boolean validateNom_categorie_field(){
        Pattern p = Pattern.compile("[a-z A-Z]+");
        Matcher m = p.matcher(Nom_categorie_field.getText());
        if(m.find() && m.group().equals(Nom_categorie_field.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur dans nom_categorie");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer un nom de categorie valide");
                alert.showAndWait();
            
            return false;            
        }
    }
    private boolean validateDescription_categorie_field(){
        Pattern p = Pattern.compile("[a-z A-Z]+");
        Matcher m = p.matcher(Description_categorie_field.getText());
        if(m.find() && m.group().equals(Description_categorie_field.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur dans la description");
                alert.setHeaderText(null);
                alert.setContentText("Veuiller Entrer une description valide pour la  categorie ");
                alert.showAndWait();
            
            return false;            
        }
    }
    @FXML
    void AjouterCategorieBD(ActionEvent event) throws Exception {
        CategorieKids c1 = new CategorieKids();
        c1.setNomCategorie(Nom_categorie_field.getText());
        c1.setDescription(Description_categorie_field.getText());
        CategorieKidsService cs1 = new CategorieKidsService();
        cs1.ajouterCategorieKids(c1);        
        NotificationAPI.notifInfo("cat", "la catégorie est ajouté avec succés dans la BD");
        CategorieKidsMailApi.sendMail(client.getEmail());
    }
    @FXML
    void returnToPageCategorieKids(ActionEvent event) {
        vf.showCategoriesKids();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }
}
