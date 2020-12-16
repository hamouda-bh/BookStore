/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import bookstore.views.ViewFactory;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Mehdi
 */
public class ZayTestGUI extends Application {

	public static void main(String[] args) {
		launch(args);
                
	}

	@Override
	public void start(Stage stage)   {
		try {    
			ViewFactory vf = new ViewFactory();
                        vf.showAnnonces();
		}
                catch(Exception e) {			
			e.printStackTrace();
        }	
    }
}
