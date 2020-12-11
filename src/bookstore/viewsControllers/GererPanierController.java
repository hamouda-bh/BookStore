package bookstore.viewsControllers;

import bookstore.entities.Facture;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class GererPanierController extends BaseController {

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
    private Button passerC_btn_id;

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
    void onCliqPasserCommande(ActionEvent event) {
        vf.showCommandeForm();
    }

    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();
    }

    private void initTable() {
        intiCols();
    }



private void intiCols()
{
    

    nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("id_comm"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("somme_ajoute"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite_ajouter"));  
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  
  
    editableCols();

}

public void editableCols()
{
    
    nomlivre_id.setCellFactory(TextFieldTableCell.forTableColumn());
    nomlivre_id.setOnEditCommit(e ->{ 
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_comm(Integer.parseInt(e.getNewValue()));
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
}
private void loadData()
{
    ObservableList<Panier_livre> data= FXCollections.observableArrayList();
    PanierService a = new PanierService();
    
            List<Panier_livre> panier = new ArrayList<>();
            panier = a.afficher();

         for (Panier_livre p : panier) {
             p.toString();
            System.out.println("tttttt");
                
               data.add(p);
            }

    table_panier.setItems(data); 
        
       
    
}
 private void affichage(ActionEvent event) {

        data = FXCollections.observableArrayList();

        PanierService Ac = new PanierService();

        Ac.afficherActivite1().forEach((a) -> {

            data.add(a);
        });
          nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("id_comm"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("somme_ajoute"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite_ajouter"));  
    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  

        table_panier.setItems(null);
        table_panier.setItems(data);

    }
    

}


