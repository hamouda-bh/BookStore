  package bookstore.views;
import bookstore.Testing.Cache;
import bookstore.entities.Livre;
import bookstore.services.livreService;
import bookstore.utils.TrayIconDemo;
import bookstore.viewsControllers.BaseController;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AjoutLivreController extends BaseController{
    public AjoutLivreController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }

    private TextField tfId;

    @FXML
    private TextField tfLabelCat;

    @FXML
    private TextField tfTitre;

    @FXML
    private TextField tfAuteur;

    @FXML
    private TextField tfGenre;

    @FXML
    private TextField tfPrix;

    @FXML
    private TextField tfImage;

    @FXML
    private Button tfENV;

    
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
    
    
    public AjoutLivreController()   {
        
    }
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
Alert alert=new Alert(Alert.AlertType.INFORMATION);
    
    @FXML
    void Ajouterunlivre(ActionEvent event) throws IOException, SQLException, AWTException {
        int a = 0;
        float f = 0 ;
        String str = "N/A";
        try {
          a=Integer.parseInt(tfLabelCat.getText());
         f = Float.parseFloat(tfPrix.getText());
        } catch (NumberFormatException ex){
        }
    if((!"".equals(a))&&(!"".equals(tfTitre.getText()))&&(!"".equals(tfAuteur.getText()))&&(!"".equals(f))&&(!"".equals(tfImage.getText()))){
     livreService ls = new livreService ();
     ls.ajouter(new Livre (a,tfTitre.getText(),tfAuteur.getText(),f,tfImage.getText()));
       
    
    if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTrayajout();
            System.err.println("notiiiifff");
        } else {
            System.err.println("Erreur!!!!");
        }
    
    }
        else if(("".equals(a))||("".equals(tfTitre.getText()))||("".equals(tfAuteur.getText()))||("".equals(f))||("".equals(tfImage.getText()))){
        {
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("type valide information !");
            alert.showAndWait();
        }
        
        }
    JOptionPane.showMessageDialog(null,"Livre ajouté!");
    }

//FXMLLoader loader = new FXMLLoader (getClass().getResource("DetailsLivre.fxml"));
//Parent root = loader.load();
//tfId.getScene().setRoot(root);

//DetailsLivreController dlc= loader.getController();
    
        
      //  dlc.setLbLabelCat(tfLabelCat.getText());
       // dlc.setLbTitre(tfTitre.getText());
        //dlc.setLbAuteur(tfAuteur.getText());
        //dlc.setLbGenre(tfGenre.getText());
        //dlc.setLbPrix(tfPrix.getLength());
        //dlc.setLbImage(tfImage.getText());
        
        
        
   /* private void Modifierunlivre (ActionEvent event) throws IOException {
        int a=Integer.parseInt(tfId.getText());
        float f = Float.parseFloat(tfPrix.getText());
     livreService ls = new livreService ();
     ls.modifier(new Livre (a,tfLabelCat.getText(),tfTitre.getText(),tfAuteur.getText(),tfGenre.getText(),f,tfImage.getText()));
     JOptionPane.showMessageDialog(null,"Livre modifié !");
    }*/
    /*@FXML
    private void Supprimerunlivre (ActionEvent event) throws IOException {
        int a=Integer.parseInt(tfId.getText());
        float f = Float.parseFloat(tfPrix.getText());
     livreService ls = new livreService ();
     ls.Supprimer(new Livre (a,tfTitre.getText(),tfAuteur.getText(),f,tfImage.getText()));
     JOptionPane.showMessageDialog(null,"Livre supprimé !");
    }
  */
}


