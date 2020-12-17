/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.CategorieKids;
import bookstore.entities.LivreKids;
import bookstore.services.CategorieKidsService;
import bookstore.services.LivreKidsService;
import bookstore.views.ViewFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class AjouterLivreKidsController extends BaseController implements Initializable {
    public AjouterLivreKidsController (ViewFactory vf,String fxmlName){
        super(vf, fxmlName);
    }
@FXML
    private TextField Titre;

    @FXML
    private Button Annuler;

    @FXML
    private Button AjouterLivre;

    @FXML
    private TextField auteur;

    @FXML
    private TextField Description;

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

    @FXML
    private Button BrowseBtn;

    @FXML
    private Label Path;

    @FXML
    private ComboBox<CategorieKids> categorie;
    
    private ObservableList<CategorieKids> cats;
    
    private ArrayList<String> lstFile;

    
    
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
    
    @FXML
    void AfficherPageLivreKids(ActionEvent event) {
        vf.ShowLivreKids();
    }

    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstFile = new ArrayList<>();
        lstFile.add("*.jpg");
        lstFile.add("*.jpeg");
        lstFile.add("*.png");
        cats = FXCollections.observableArrayList();
        CategorieKidsService as = new CategorieKidsService();
        as.afficherLesCategorieKids(cats);
        for (int i = 0; i < cats.size(); i++) {
            categorie.getItems().add(cats.get(i));
        }
        categorie.setConverter(new StringConverter<CategorieKids>() {
            @Override
            public String toString(CategorieKids object) {
                return (object.getNomCategorie());
            }

            @Override
            public CategorieKids fromString(String string) {
                return categorie.getItems().stream().filter(ap
                        -> ap.getNomCategorie().equals(string)).findFirst().orElse(null);

            }
        });
        
    }
    @FXML
    void BrowseFile() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", lstFile));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            Path.setText(f.getPath());
        }
    }
    
    @FXML
    void AjouterLivreBD(ActionEvent event) {
        LivreKids L1 = new LivreKids();
        L1.setTitre(Titre.getText());
        L1.setDescription(Description.getText());
        L1.setImage(Path.getText());
        LivreKidsService s1 = new LivreKidsService();
        s1.ajouterLivreKids(L1);
    }
    
    
}   
