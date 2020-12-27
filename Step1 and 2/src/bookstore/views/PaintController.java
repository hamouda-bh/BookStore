package bookstore.views;

import bookstore.views.ViewFactory;
import bookstore.viewsControllers.BaseController;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class PaintController extends BaseController {
    public PaintController (ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
    @FXML
    private TextField brushSize;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private CheckBox eraser;

    @FXML
    private Button Save;

    @FXML
    private Button retour;

    @FXML
    private Canvas canvas;
    
    
    
    final static int CANVAS_WIDTH = 1000;
    final static int CANVAS_HEIGHT = 800;
    GraphicsContext graphicsContext;
    ColorPicker ColorPicker;
    
    /*
    public void start (Stage primaryStage){
        try {
            Group root = new Group();
            Scene scene = new Scene(root, 1000,800);
            scene.getStylesheets().add(getClass().getResource("../style/style.css").toExternalForm());
            final Canvas canvas = new Canvas(CANVAS_WIDTH,CANVAS_HEIGHT);
            graphicsContext = canvas.getGraphicsContext2D();
            
            
            
            
            
            
            
            primaryStage.setScene(scene);
            primaryStage.show();
            
              
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initDraw(){
        
    }
    */
    public void initialize() {
        
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
        });
        
        
        
       
    }

    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("C:/Users/PC-Hamouda/Desktop/Paint/paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
        }
    }

    public void onRetour() {
        vf.ShowKidsSpace();
        Stage stage = (Stage) eraser.getScene().getWindow();
	vf.closeStage(stage);
        
    }
}