/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import bookstore.entities.Annonce;
import bookstore.viewsControllers.BaseController;
import bookstore.services.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AnnoncesViewController extends BaseController implements Initializable {

    public AnnoncesViewController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }

    @FXML
    private Button fxmesannonces;
    @FXML
    private Button AjouterUneNouvelleAnnonce;
    @FXML
    private TableView<Annonce> fxTableAnnonces;
    @FXML
    private TableColumn<Annonce, String> datepublicationcell;
    @FXML
    private TableColumn<Annonce, Float> prixcell;
    @FXML
    private TableColumn<Annonce, String> etatcell;
    @FXML
    private TableColumn<Annonce, String> dateachatcell;

    private ObservableList<Annonce> ob = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceAnnonce sa = new ServiceAnnonce();

        datepublicationcell.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Date_publication"));
        prixcell.setCellValueFactory(new PropertyValueFactory<Annonce, Float>("Prix"));
        etatcell.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Etat_de_livre"));
        dateachatcell.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Date_achat"));
        fxTableAnnonces.setItems(ob);
        sa.afficherAnnonces(ob);
        //for(int i=0; i<ob.size();i++){
        //    System.out.println(ob.get(i));
        //}

    }

    @FXML
    private void ajouterAnnonce(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AAjoutAnnonceView.fxml"));
            Stage st = new Stage();
            st.setTitle("BookStore : Toute les annonces");
            st.setScene(new Scene(root, 450, 450));
            st.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void mesAnnonces(ActionEvent event) throws IOException {
         FXMLLoader fx = new FXMLLoader(getClass().getResource("AMesAnnoncesView.fxml"));
         Parent root1 = fx.load();
        fxmesannonces.getScene().setRoot(root1);
    }
}
