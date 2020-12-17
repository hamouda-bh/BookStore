package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Facture;
import bookstore.entities.Livre;
import bookstore.entities.Panier_livre;
import bookstore.services.PanierService;
import bookstore.services.livreService;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GererPanierController extends BaseController implements Initializable{

    public GererPanierController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }
    public GererPanierController() {
        super();
    }
    
    @FXML
    private TableView<Panier_livre> table_panier;
    
         @FXML
    private Button btnOverview;
         @FXML
    private Button update;

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
    private Button passerC_btn_id;
    
    @FXML
    private Button btnCustomers;
    private float summ;
    @FXML
    private Button btnMenus;
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
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }
  
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
        Stage stage = (Stage) passerC_btn_id.getScene().getWindow();
	               	vf.closeStage(stage);
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    Stage stage = (Stage) passerC_btn_id.getScene().getWindow();
	               	vf.closeStage(stage);
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
        Stage stage = (Stage) passerC_btn_id.getScene().getWindow();
	               	vf.closeStage(stage);
    }
    
     @FXML
    void panier(ActionEvent event) {
         vf.showPanier();
         	Stage stage = (Stage) passerC_btn_id.getScene().getWindow();
		vf.closeStage(stage);
    }

    @FXML
    private TableColumn<Panier_livre, String> nomlivre_id;

    @FXML
    private TableColumn<Panier_livre, String> prix;

    @FXML
    private TableColumn<Panier_livre, String> Quantite;
    

    @FXML
    private TableColumn<Panier_livre, Button> supprimer;
    
    private ObservableList<Panier_livre> data;


        
    @FXML
    void onCliqPasserCommande(ActionEvent event) throws SQLException {
     
        if (validateFields())
        {PanierService ps = new PanierService();
            ps.modifier(String.valueOf(Quantite.getText().toString()),nomlivre_id.getText().toString());}
        vf.showCommandeForm();
        	Stage stage = (Stage) passerC_btn_id.getScene().getWindow();
	               	vf.closeStage(stage);
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
    Quantite.setCellFactory(TextFieldTableCell.forTableColumn());
   // updateQuantite.setCellValueFactory(new PropertyValueFactory<>("update")); 
     Quantite.setEditable(true);
    table_panier.setEditable(true);
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  

    
  affichage();

}

private void loadData()
{
    ObservableList<Panier_livre> data= FXCollections.observableArrayList();
   PanierService a = new PanierService();
  
            List<Panier_livre> panier = new ArrayList<>();
            panier = a.afficherL();
            for (Panier_livre p : panier) {
               p.toString();           
               System.out.println("tttttt");               
               data.add(p);
            }
             table_panier.setEditable(true);
    Quantite.setEditable(true);
   
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
   // Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite_ajouter"));  
    Quantite.setCellFactory(TextFieldTableCell.forTableColumn());
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  
    table_panier.setEditable(true);
    Quantite.setEditable(true);
   
        table_panier.setItems(null);
        table_panier.setItems(data);

    }
 
 
Connection cnx = DBConnection.getInstance().getCnx();

 public void supprimer(int i) {
        String req = "DELETE From panier_livre WHERE panier_livre.id_livre=?";
        try {
        PreparedStatement pst2 = cnx.prepareStatement(req);
            pst2.setInt(1, i);
            pst2.executeUpdate();
          
            System.out.println("p supprimée");
             vf.showPanier();
             Stage stage = (Stage) logOut.getScene().getWindow();
    	    vf.closeStage(stage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
 @FXML
 public void update( ) throws SQLException {
     
     ObservableList<Panier_livre> datarows = FXCollections.observableArrayList();
    	for (Panier_livre p : data)
        {
    	if (validateFields())	
       { 
           datarows.add(p);
            PanierService ps = new PanierService();
            ps.modifier(String.valueOf(p.getQuantite_ajouter().toString()),p.getTitre());
         }
      }
    }
 
 
    private boolean validateFields() {   	
    	if (!(Quantite.getText().isEmpty()) && (Quantite.getText().length()<=2)&&(Quantite.getText().length()>1))
        {Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Validate fields");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter into fields ");
    		alert.showAndWait();
    		
    		return true;
    	}else
    		return false;
    }
}
