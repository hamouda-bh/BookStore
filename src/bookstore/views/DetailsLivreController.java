/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsLivreController implements Initializable {

    @FXML
    private Label lbId;
    @FXML
    private Label lbLabelCat;
    @FXML
    private Label lbTitre;
    @FXML
    private Label lbAuteur;
    @FXML
    private Label lbGenre;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setLbId(int n) {
        this.lbId.setText(Integer.toString(n)); 
    }

    public void setLbLabelCat(String str) {
        this.lbLabelCat=lbLabelCat; 
    }

    public void setLbTitre(String str) {
        this.lbTitre = lbTitre;
    }

    public void setLbAuteur(String str) {
        this.lbAuteur = lbAuteur;
    }

    public void setLbGenre(String str) {
        this.lbGenre = lbGenre;
    }

    public void setLbPrix(Float m) {
        this.lbPrix.setText(String.valueOf(m));
        
    }

    public void setLbImage(String str) {
        this.lbImage = lbImage;
    }
    
}
