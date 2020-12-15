package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.Panier_livre;
import bookstore.services.PanierService;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import bookstore.entities.Coupon;
import com.booklab.models.ShoppingCart;
import bookstore.services.ServicesShoppingCart;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;




public class PasserCommandeController extends BaseController implements Initializable {
    public PasserCommandeController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
    @FXML
    private TableView<Panier_livre> table_panier;

    @FXML
    private TextField inputId;
    @FXML
    private CheckBox check1_id;
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
    private CheckBox check2_id;
    @FXML
    private Button confirm_btn_id;
    @FXML
    private Button annuler_btn_id;
    @FXML
    private ToggleButton btn_code_id;
  
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
    private TableColumn<Panier_livre, String> nomlivre_id;

    @FXML
    private TableColumn<Panier_livre, String> prix;

    @FXML
    private TableColumn<Panier_livre, Spinner> Quantite;

    private ObservableList<Panier_livre> data;
    
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
    void onCliqAnnuler(ActionEvent event) {
            vf.showPanier();
    }

    @FXML
    void onCliqConfirmer(ActionEvent event) {
            vf.showPaiement();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initTable();
        loadData();
    }

    private void initTable() {
        intiCols();
    }

    private void intiCols()
    {   
    nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("titre"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("prix"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));  
    
    affichage();
    }
    
    
    private void loadData(){
        
    ObservableList<Panier_livre> data= FXCollections.observableArrayList();
    PanierService a = new PanierService();
    
            List<Panier_livre> panier = new ArrayList<>();
            panier = a.afficherL();

         for (Panier_livre p : panier) {
             p.toString();
            System.out.println("tttttt");
                
               data.add(p);
            }

    table_panier.setItems(data); 
      
}
    
 private void affichage() {

        data = FXCollections.observableArrayList();
        PanierService Ac = new PanierService();
        Ac.afficherL().forEach((a) -> {
              data.add(a);
        });
    nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("titre"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("prix"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite_ajouter"));  
    table_panier.setItems(data);
    }
 
   @FXML
    public void useCoupon(ActionEvent event) {
        int code = Integer.parseInt(inputId.getText());
        if (code == 10) {
            ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");
        } else if (code == 20) {
            ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");
        }else{
            JOptionPane.showMessageDialog(null, "Please add a valid coupon ");
        }

    }
    
}
