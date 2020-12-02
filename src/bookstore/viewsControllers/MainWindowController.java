/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.viewsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import bookstore.views.ViewFactory;

/**
 *
 * @author PC-Hamouda
 */
public class MainWindowController extends BaseController {
     
	 public MainWindowController(ViewFactory vf, String fxmlName) {
		super(vf, fxmlName);
		// TODO Auto-generated constructor stub
	}
	
	
	@FXML
	    private TreeView<?> treeView;
	@FXML
    private MenuItem myAccountButton;
    
	@FXML
    void myAccountAction() {
        vf.showAccountWindow();
    }
}