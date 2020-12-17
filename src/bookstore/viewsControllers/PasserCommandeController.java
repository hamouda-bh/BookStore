package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.Commande;
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
import bookstore.services.CommandeService;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private Text affSumid;
  
    @FXML
    private Button btn_panier;
   
    @FXML
    private Pane pnlCustomer;
    
    @FXML
    private Pane pnlOrders;
    
    public String prixF;
    
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
        Stage stage = (Stage) btn_panier.getScene().getWindow();
	vf.closeStage(stage);
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    Stage stage = (Stage) btn_panier.getScene().getWindow();
	vf.closeStage(stage);
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
        Stage stage = (Stage) btn_panier.getScene().getWindow();
	vf.closeStage(stage);
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
        Stage stage = (Stage) btn_panier.getScene().getWindow();
	vf.closeStage(stage);
    }
    

    @FXML
    void onCliqAnnuler(ActionEvent event) {
            vf.showPanier();
            Stage stage = (Stage) btn_panier.getScene().getWindow();
	    vf.closeStage(stage);
    }

    @FXML
    void onCliqConfirmer(ActionEvent event) throws SQLException {
       // Date date=java.util.Calendar.getInstance().getTime();
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
    
        Commande c = new Commande ( String.valueOf(date_sql) ,Float.parseFloat(prixF));
        CommandeService cs = new CommandeService();
      
        if (check2_id.isSelected())
        {
            vf.showPaiement();
             Stage stage = (Stage) btn_panier.getScene().getWindow();
	     vf.closeStage(stage);
             cs.ajouter(c);
             
             cs.vider();
        }
        else if (check1_id.isSelected())
        {
            vf.showCommandeFaite();
             Stage stage = (Stage) btn_panier.getScene().getWindow();
	     vf.closeStage(stage);
             cs.ajouter(c);
             cs.vider();
        }else if ((!check1_id.isSelected())&&(!check1_id.isSelected()))
        {
         JOptionPane.showMessageDialog(null, "check mode de paiement ");
         vf.showCommandeForm();
         Stage stage = (Stage) btn_panier.getScene().getWindow();
	 vf.closeStage(stage);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PanierService a = new PanierService();
        prixF =String.valueOf(a.afficherp());
        affSumid.setText(prixF);
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
           /* ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");*/
            
            prixF=String.valueOf(  Float.parseFloat(affSumid.getText())-((Float.parseFloat(affSumid.getText())*10)/100));
            affSumid.setText(prixF); 
            affSumid.isDisable();
           btn_code_id.isDisable();
        } else if (code == 20) {
           /* ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");*/
            prixF=String.valueOf(  Float.parseFloat(affSumid.getText())-((Float.parseFloat(affSumid.getText())*20)/100));
            affSumid.setText(prixF);       
            affSumid.isDisable();
            btn_code_id.isDisable();
        }else if (code == 30) {
           /* ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");*/
            prixF=String.valueOf(  Float.parseFloat(affSumid.getText())-((Float.parseFloat(affSumid.getText())*30)/100));
            affSumid.setText(prixF);       
            affSumid.isDisable();
            btn_code_id.isDisable();
        }else if (code == 40) {
           /* ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");*/
            prixF=String.valueOf(  Float.parseFloat(affSumid.getText())-((Float.parseFloat(affSumid.getText())*40)/100));
            affSumid.setText(prixF);       
            affSumid.isDisable();
            btn_code_id.isDisable();
        }else if (code == 50) {
           /* ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart();
            a=sc.setActiveCart(a);
            sc.setDiscount(a,code);
            JOptionPane.showMessageDialog(null, "Coupon Used");*/
            prixF=String.valueOf(  Float.parseFloat(affSumid.getText())-((Float.parseFloat(affSumid.getText())*50)/100));
            affSumid.setText(prixF);       
            affSumid.isDisable();
            btn_code_id.isDisable();
        }else{
            JOptionPane.showMessageDialog(null, "Please add a valid coupon ");
        }

    }
    
}
