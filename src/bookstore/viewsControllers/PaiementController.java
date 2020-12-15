package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.services.FactureService;
import bookstore.utils.TrayIconDemo;
import bookstore.views.ViewFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import static com.stripe.param.checkout.SessionCreateParams.ShippingAddressCollection.AllowedCountry.SC;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PaiementController extends BaseController implements Initializable{
    public PaiementController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
@FXML
    private TextField cvc;

@FXML
    private TextField date_month;

    @FXML
    private TextField date_year;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField tel_id;

    @FXML
    private TextField prenom_id;

    @FXML
    private TextField adresse_id;

    @FXML
    private TextField code_id;

    @FXML
    private TextField num_compte_id;

    @FXML
    private Button payer_btn_id;

    @FXML
    private Button annuler_btn_id;

    @FXML
    private CheckBox check_bancaire_id;

    @FXML
    private CheckBox check_postale_id;

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
    private Button btn_panier;
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
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    
           }
    @FXML
    private void goBlog(ActionEvent event) {
        vf.showBlog();
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
    }

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void logOutAction(ActionEvent event) {

    }
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML
    void onCliqAnnuler(ActionEvent event) {
            vf.showPanier();
    }

   
  /*  void onCliqPayer(ActionEvent event) {
            vf.showCommandeFaite();
         //   FactureService f = new FactureService();
        //    f.ajouter(p, c);
    }*/
     @FXML
    private void onCliqPayer() throws AWTException {
        try{
            Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
            Customer a = Customer.retrieve("sk_test_4eC39HqLyjWDarjtT1zdp7dc");
            Map <String, Object> cardParam = new HashMap<String, Object>();
            if(!(num_compte_id.getText().equals("") || date_month.getText().equals("") || date_year.getText().equals("") || cvc.getText().equals(""))){
                cardParam.put("number", num_compte_id.getText());
                cardParam.put("exp_month", Integer.parseInt(date_month.getText()));
                cardParam.put("exp_year", Integer.parseInt(date_year.getText()));
                cardParam.put("cvc", cvc.getText());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please check your card information!");
                return;
            }
            Map <String, Object> tokenParam = new HashMap<String, Object>();
            tokenParam.put("card", cardParam);
            
            Token token = Token.create(tokenParam);
            
            Map<String, Object> source = new HashMap<String, Object>();
            source.put("source", token.getId());
            
            //a.getSources().create(source);
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(token));
            
            
            
            //Integer.parseInt(sum_total.getText().substring(0, sum_total.getText().length()-3))
            Map<String,Object> chargeParam = new HashMap<String, Object>();
            chargeParam.put("amount", 0.50);
            chargeParam.put("currency", "usd");
            chargeParam.put("source", token.getId());
             System.err.println("notiff 9ballllllllll ");
             
             if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTraypaie();
            System.err.println("notiff paie ");
        } else {
            System.err.println("Erreur!!!!");
        }
             
          Charge.create(chargeParam);
                      System.err.println("notiff 9ballll ");

          
          /* NotificationAPI.notifInfo("Payment", "Your payment was successful!");
            // Create Order
            ServicesOrder so = new ServicesOrder();
            
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            Order O = new Order(SC, true, date);
            createOrder();*/
            
        }catch(StripeException e){
            System.out.println(e.getMessage());   
        //    NotificationAPI.notif("Payment", "An error has occured with your Payment!");
        }
    }
}
