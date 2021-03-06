/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

/**
 *
 * @author Malek
 */
import bookstore.Testing.Cache;
import bookstore.Testing.MailApi;
import bookstore.services.ClientService;
import bookstore.views.ViewFactory;
import com.sun.security.ntlm.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class MailWindowController extends BaseController implements Initializable {
    public MailWindowController(ViewFactory vf , String FxmlName){
       super(vf,FxmlName);
    }

    private static String code = "";
    @FXML
    private TextField mailField;
    @FXML
    private Button sendButton;
     @FXML
    private Button cancelButton;
    
    @FXML
    private AnchorPane verifArchorPaness;
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
    private Button btn_panier;
    @FXML
    private Button logOut;
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
    private Button myAccountButton;
@FXML
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }
    /*
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
    */
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
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
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
     void sendButtonAction(ActionEvent event) throws Exception {
        this.code = randomcode();
        int count = 0;
        ClientService cs = new ClientService();
        count = cs.validateEmail(mailField.getText());
        if (count != 0) {
            MailApi.sendMail(mailField.getText(), this.code);
            System.out.println(this.code);
            
            VerificationController vc = new VerificationController();
            vc.setCode(this.code);
            //vf.showPasswordWindow();
            vf.showUI();
            Stage stage = (Stage) sendButton.getScene().getWindow();
   	    vf.closeStage(stage);
            
        } else {
            JOptionPane.showMessageDialog(null, "This email doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
     
     @FXML
    void cancelButton(ActionEvent event) {
      vf.showUI();
      Stage stage = (Stage) sendButton.getScene().getWindow();
   	    vf.closeStage(stage);
    }


    public static String randomcode() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    
}

