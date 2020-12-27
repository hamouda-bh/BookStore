/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import static bookstore.Testing.Cache.client;
import bookstore.entities.Annonce;
import bookstore.services.ServiceAnnonce;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AMesAnnoncesViewController extends BaseController implements Initializable {

    public AMesAnnoncesViewController(ViewFactory vf, String fxmlName) {
       super(vf, fxmlName);
    }
    
    @FXML
    private Button modifierUneAnnonce;
    @FXML
    private Button AjouterUneAnnonce;
    @FXML
    private Button SupprimerUneAnnonce;
    
    @FXML
    private TextField findAnnonce;
    @FXML
    private TextField txtDatePublication;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtEtat;
    @FXML
    private TextField txtDateAchat;
    
    @FXML
    private TableView<Annonce> tvMesAnnonces;
    
    @FXML
    private TableColumn<Annonce, String> tcDatePublication;
    @FXML
    private TableColumn<Annonce, String> tcPrix;
    @FXML
    private TableColumn<Annonce, String> tcEtat;
    @FXML
    private TableColumn<Annonce, String> tcDateAchat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcDatePublication.setCellValueFactory(new PropertyValueFactory<Annonce,String>("date_publication"));
        tcPrix.setCellValueFactory(new PropertyValueFactory<Annonce,String>("prix"));
        tcEtat.setCellValueFactory(new PropertyValueFactory<Annonce,String>("etat_de_livre"));
        tcDateAchat.setCellValueFactory(new PropertyValueFactory<Annonce,String>("date_achat"));  
        ServiceAnnonce sa = new ServiceAnnonce();
        tvMesAnnonces.setItems(sa.afficherAnnonces());
        
        
    }   
    
    int index = -1;
    @FXML
    private void getSelected(MouseEvent event) {
        index = tvMesAnnonces.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        txtDatePublication.setText(tcDatePublication.getCellData(index).toString());
        txtPrix.setText(tcPrix.getCellData(index).toString());
        txtEtat.setText(tcEtat.getCellData(index).toString());
        txtDateAchat.setText(tcDateAchat.getCellData(index).toString());
    }

    @FXML
    private void modifierAnnonce(ActionEvent event) {
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.modifierAnnonce(new Annonce(txtDatePublication.getText(),txtPrix.getText(),txtEtat.getText(),txtDateAchat.getText()));
        JOptionPane.showMessageDialog(null,"Annonce modifiée !");
    }

    @FXML
    private void ajouterAnnonce(ActionEvent event) {
        vf.showAjoutAnnonces();
        Stage stage = (Stage) txtPrix.getScene().getWindow();
    	vf.closeStage(stage);
    }

    @FXML
    private void supprimerAnnonce(ActionEvent event) {
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.supprimerAnnonce(new Annonce(txtDatePublication.getText(),txtPrix.getText(),txtEtat.getText(),txtDateAchat.getText()));
        JOptionPane.showMessageDialog(null,"Annonce Supprimée !");
    }

    
}
