/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */


import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

public class LivreKidsController extends BaseController {

    public LivreKidsController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }
    @FXML
    private JFXButton vgvg;

    @FXML
    public void showCategoriesWindowFromLivre() {
        vf.showCategoriesWindowFromLivre();
    }
}

