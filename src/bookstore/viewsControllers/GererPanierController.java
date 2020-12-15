package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.Facture;
import bookstore.entities.Livre;
import bookstore.entities.Panier_livre;
import bookstore.services.PanierService;
import bookstore.services.livreService;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GererPanierController extends BaseController implements Initializable{

    public GererPanierController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }
    
    @FXML
    private TableView<Panier_livre> table_panier;
    
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
    private TableColumn<Panier_livre, String> nomlivre_id;

    @FXML
    private TableColumn<Panier_livre, String> prix;

    @FXML
    private TableColumn<Panier_livre, Spinner> Quantite;

    @FXML
    private TableColumn<Panier_livre, Button> supprimer;
    
        private ObservableList<Panier_livre> data;


        
    @FXML
    void onCliqPasserCommande(ActionEvent event) {
      
        vf.showCommandeForm();
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
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  
    
  affichage();
  //  editableCols();

}

/*
public void editableCols()
{
    
    nomlivre_id.setCellFactory(TextFieldTableCell.forTableColumn());
    nomlivre_id.setOnEditCommit(e ->{ 
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(String.valueOf(e.getNewValue()));
    });
    
    prix.setCellFactory(TextFieldTableCell.forTableColumn());
    prix.setOnEditCommit(e ->{ 
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_comm((int) Float.parseFloat(e.getNewValue()));
    });
    
    Quantite.setCellFactory(TextFieldTableCell.forTableColumn());
    Quantite.setOnEditCommit(e ->{ 
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_comm(Integer.parseInt(e.getNewValue()));
    });
   table_panier.setEditable(true);
}*/
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
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  

        table_panier.setItems(null);
        table_panier.setItems(data);

    }
}


