  package bookstore.views;

import bookstore.entities.Livre;
import bookstore.services.livreService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class AjoutLivreController {

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfIdCategorie;

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

    public AjoutLivreController()   {
        
    }
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void Ajouterunlivre(ActionEvent event) throws IOException {
        int a=Integer.parseInt(tfId.getText());
        int b=Integer.parseInt(tfIdCategorie.getText());
        float f = Float.parseFloat(tfPrix.getText());
     livreService ls = new livreService ();
     ls.ajouter(new Livre (a,b,tfTitre.getText(),tfAuteur.getText(),tfGenre.getText(),f,tfImage.getText()));
     JOptionPane.showMessageDialog(null,"Livre jouté!");
    
FXMLLoader loader = new FXMLLoader (getClass().getResource("DetailsLivre.fxml"));
Parent root = loader.load();
tfId.getScene().setRoot(root);

DetailsLivreController dlc= loader.getController();
    
    dlc.setLbId(a);
        dlc.setLbIdCategorie(b);
        dlc.setLbTitre(tfTitre.getText());
        dlc.setLbAuteur(tfAuteur.getText());
        dlc.setLbGenre(tfGenre.getText());
        dlc.setLbPrix(f);
        dlc.setLbImage(tfImage.getText());
    }
}