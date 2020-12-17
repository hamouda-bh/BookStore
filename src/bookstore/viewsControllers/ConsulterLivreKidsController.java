/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.CategorieKids;
import bookstore.entities.LivreKids;
import bookstore.services.CategorieKidsService;
import bookstore.services.LivreKidsService;
import bookstore.views.ViewFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class ConsulterLivreKidsController extends BaseController implements Initializable {
    public ConsulterLivreKidsController(ViewFactory vf, String fxmlName ){
        super(vf, fxmlName);
    }
    private int count =0;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button myAccountButton;
    @FXML
    private Button tflivre;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btn_panier;
    @FXML
    private Button goToEspaceKids;
    @FXML
    private Button logOut;
    @FXML
    private Button retourBtn;
    
    @FXML
    private TilePane tilepane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<LivreKids> livre_list = new ArrayList<>();
        LivreKidsService bs = new LivreKidsService();
        livre_list=bs.afficherLesLivresKids();
        System.out.println(livre_list);
        final int GAP = 10;
        tilepane.setHgap(GAP);
        tilepane.setVgap(GAP);
        createElements(livre_list);
        
        

    }    
    private void createElements(ArrayList<LivreKids> bookList) {
        
        tilepane.getChildren().clear();
        for (int j = 0; j < bookList.size(); j++) {
            tilepane.getChildren().add(createPage(count, bookList.get(j).getTitre(), bookList.get(j).getCat().getNomCategorie(), bookList.get(j).getDescription(), bookList.get(j).getImage()));
            count++;
        }
    }
    public VBox createPage(int index, String titre , String nom_categorie, String description , String  imageUrl  ) {
        ImageView imageView = new ImageView();
        try {
            InputStream stream = new FileInputStream(imageUrl);
            Image image = new Image(stream);
            System.out.println(imageUrl);
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
            }
        });
            
        } catch (IOException ex) {
        }
        Label titreLabel = new Label();
        titreLabel.setText(titre);
        /*
        Label label = new Label();
        Label detailsLabel = new Label();
        label.setText();
        detailsLabel.setText("Details");
        detailsLabel.getStyleClass().add("detailsLabel");
        label.getStyleClass().add("bookLabel");
        Label bookPrice = new Label();
        bookPrice.setText(price + " DT");
        bookPrice.setStyle("-fx-alignment:center;");
        ImageView addTocartBtn = new ImageView();
        ImageView bookDetailsBtn = new ImageView();
        ImageView ratingIcon = new ImageView();
        try {
            Image addToCartBtn = new Image(new FileInputStream("F:\\21655\\Documents\\NetBeansProjects\\booky\\src\\com\\booky\\views\\images\\addcart.png"));
            addTocartBtn.setImage(addToCartBtn);
            addTocartBtn.setFitWidth(35);
            addTocartBtn.setFitHeight(35);
            addTocartBtn.getStyleClass().add("add-to-cart");
            Glow glow = new Glow(0.5);
            addTocartBtn.setEffect(glow);
            Image detailsBtn = new Image(new FileInputStream("F:\\21655\\Documents\\NetBeansProjects\\booky\\src\\com\\booky\\views\\images\\details.png"));
            bookDetailsBtn.setImage(detailsBtn);
            bookDetailsBtn.setFitWidth(30);
            bookDetailsBtn.setFitHeight(30);
            bookDetailsBtn.getStyleClass().add("add-to-cart");
            bookDetailsBtn.setEffect(glow);
            Image ratingImage = new Image(new FileInputStream("F:\\21655\\Documents\\NetBeansProjects\\booky\\src\\com\\booky\\views\\images\\star.png"));
            ratingIcon.setImage(ratingImage);
            ratingIcon.setFitWidth(20);
            ratingIcon.setFitHeight(20);
            ratingIcon.setEffect(glow);
        } catch (IOException ex) {
        }
        // GET THE QUANTITY OF EACH BOOK FROM DATABASE 
        CartItemService cis = new CartItemService();
        int bookQuantity = cis.readCartItem(bookId);
        // TOTAL QUANTITIES IS THE TOTAL ITEMS OF CART 
        totalQuantities += bookQuantity;
        cartTotal += bookQuantity * price;
        bookQuantities.put(bookId, bookQuantity);
        cartItems.setText(totalQuantities + "");
        addTocartBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bookQuantities.put(bookId, bookQuantities.get(bookId) + 1);
                totalQuantities += 1;
                cartItems.setText(totalQuantities + "");
                if (bookQuantities.get(bookId) == 1) {
                    CartItem ci = new CartItem(new Book(bookId), 1, new Cart(1));
                    cis.createCartItem(ci);

                } else {
                    CartItem ci = new CartItem(new Book(bookId), bookQuantities.get(bookId), new Cart(1));
                    cis.updateCartItem(ci);
                }
                System.out.println(cartTotal);
                Cart c = new Cart(1, new Customer(1), null, cartTotal);
                CartService cs = new CartService();
                cs.updateCart(c);
                addedMessageLabel.setStyle("-fx-text-fill:#92fd9b");
                addedMessageLabel.setText("+ Added to cart");
                addedMessageLabel.setVisible(true);
                fadeIn.setNode(addedMessageLabel);
                fadeIn.setAutoReverse(false);
                fadeIn.setToValue(0);
                fadeIn.setFromValue(1);
                fadeIn.play();
            }
        });*
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(bookDetailsBtn);
        buttonBox.getChildren().add(detailsLabel);
        buttonBox.getChildren().add(addTocartBtn);
        buttonBox.setAlignment(Pos.CENTER);*/
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);
        pageBox.getChildren().add(titreLabel);
        /*
        //pageBox.getChildren().add(label);
        //pageBox.getChildren().add(buttonBox);
        HBox priceAndRating = new HBox();
        bookPrice.getStyleClass().add("priceLabel");
        priceAndRating.getChildren().add(bookPrice);
        Label ratingLabel = new Label();
        ratingLabel.setText(rating + "");
        ratingLabel.getStyleClass().add("ratingLabel");
        priceAndRating.getChildren().add(ratingLabel);
        priceAndRating.getChildren().add(ratingIcon);
        priceAndRating.setAlignment(Pos.CENTER);
        ratingLabel.getStyleClass().add("price-rating-container");
        pageBox.getChildren().add(priceAndRating);
        pageBox.getStyleClass().add("card");
        if (bookLabel.equals("Harry Potter and the Goblet of Fire")) {
            pageBox.setStyle("-fx-effect: dropshadow(three-pass-box, green, 10, 0, 0, 0);-fx-background-radius: 10;");
        }
        pageBox.setPrefWidth(ELEMENT_SIZE + 30);
        pageBox.getStyleClass().add("book-container");
        imageView = null;
        */
        return pageBox;
    }
    
    
    
    
    
    
    @FXML
    private void goBlog( ) {
        vf.showBlog();
    }

    @FXML
    private void goLivre( ) {
        vf.showLivre() ;
    }

    @FXML
    private void panier( ) {
        vf.showPanier();
    }

    @FXML
    private void ShowKidsSpace( ) {
        vf.showCategoriesKids();
    }

    @FXML
    private void logOutAction( ) {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showUI();
    }
    @FXML
    private void retourALivreKids(){
        vf.ShowLivreKids();
    }
}
