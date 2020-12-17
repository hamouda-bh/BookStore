package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import bookstore.services.ClientService;
import bookstore.views.ViewFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

public class LoginController extends BaseController{
    
    public LoginController(ViewFactory vf, String fxmlName) {
		super(vf, fxmlName);
		
	}
	@FXML
	private ImageView closeBtn;
	@FXML
	private Button signInBtn;
	@FXML
	private TextField userTextF;
	@FXML
	private PasswordField passTextF;
	@FXML
	private Label warnLabel;
	@FXML
	private Label warnLabelClose;
	@FXML
        private Button forgotBtn;
	@FXML
	private void closeBtnMouseEntered(MouseEvent e)
	{
		closeBtn.setCursor(Cursor.HAND);
	}
	@FXML
	private void closeBtnMouseClicked(MouseEvent e)
	{
		System.exit(0);
	}
	@FXML
	private void signInBtnAction(ActionEvent e ) throws IOException
	{
            if (userTextF.getText().isEmpty()==false && passTextF.getText().isEmpty() == false) {
       	    validateLogins();
            vf.showMainWindow();
        }else 
       	    System.out.println("error");
        }
		
	@FXML
	private void warnLabelCloseMouseEntered(MouseEvent e)
	{
		warnLabelClose.setCursor(Cursor.HAND);
	}
	@FXML
	private void warnLabelCloseMouseClicked(MouseEvent e)
	{
		warnLabelClose.setVisible(false);
		warnLabel.setVisible(false);
	}
	@FXML
	private void textFieldMouseClicked(MouseEvent e)
	{
		if( warnLabel.isVisible() )
		{
			warnLabel.setVisible(false);
			warnLabelClose.setVisible( false );
		}
	}
        public void validateLogins() {
	   	Connection cnx = DBConnection.getInstance().getCnx();
	   	ClientService cs = new ClientService();
	   	
	  if ( cs.authentification(userTextF.getText(), passTextF.getText())  ) {
	   	
	   	
	   	String verifyLogin = "SELECT * FROM client WHERE email = '"+userTextF.getText()+"'  "  ;   
	   	
	   	
	   	try {
                                Statement st = cnx.createStatement();			  
				ResultSet res = st.executeQuery(verifyLogin);
				
				if(res.next() ) {
					
				
	   		
	           	  
	               	System.out.println("succes"); 
	               	Cache.client =  new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("username"),res.getString("email"),res.getString("tel"),res.getString("password"),res.getString("adresse"));
	               	vf.showMainWindow();
	               	Stage stage = (Stage) userTextF.getScene().getWindow();
	               	vf.closeStage(stage);
	             
	             }else {
	                	System.out.println("error");
				}
	   	}catch(Exception e){
	   		e.printStackTrace();
	   		e.getCause();
	   	}
	   }
   }
         @FXML
    void forgotPassButton(ActionEvent event) {
                         vf.showMailWindow();
                         Stage stage = (Stage) userTextF.getScene().getWindow();
   	                 vf.closeStage(stage);
             }
    @FXML
   void registerButtonAction() {
   	vf.showRegisterWindow();
   	Stage stage = (Stage) userTextF.getScene().getWindow();
   	vf.closeStage(stage);
   }
}
