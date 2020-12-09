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
public class DetailsBlogController implements Initializable {

    @FXML
    private Label lbid;
    @FXML
    private Label lbidc;
    @FXML
    private Label lbcategorie;
    @FXML
    private Label lbdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public void setLbid( int n ) {
        this.lbid.setText(Integer.toString(n));
    }

    public void setLbidc(int i) {
        this.lbidc.setText(Integer.toString(i));
    }

    public void setLbcategorie(String str) {
        this.lbcategorie.setText(str);
    }

    public void setLbdescription(String str) {
        this.lbdescription.setText(str);
    }
    
    
}
