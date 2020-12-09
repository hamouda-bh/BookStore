/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class DetailsPublicationController implements Initializable {

    @FXML
    private Label lbidp;
    @FXML
    private Label lbidb;
    @FXML
    private Label lbidc;
    @FXML
    private Label lbcontenue;
    @FXML
    private Label lbcommentaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setLbidp(int m) {
        this.lbidp.setText(Integer.toString(m));
    }

    public void setLbidb(int j) {
        this.lbidb.setText(Integer.toString(j));
    }

    public void setLbidc(int k) {
        this.lbidc.setText(Integer.toString(k));
    }

    public void setLbcontenue(String str) {
        this.lbcontenue.setText(str);
    }

    public void setLbcommentaire(String str) {
        this.lbcommentaire.setText(str);
    }
    
}
