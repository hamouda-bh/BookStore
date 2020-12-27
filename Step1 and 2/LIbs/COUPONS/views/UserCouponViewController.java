/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booklab.views;

import com.booklab.models.Coupon;
import com.booklab.models.ShoppingCart;
import com.booklab.services.AdminCouponServices;
import com.booklab.services.ServicesShoppingCart;
import static com.booklab.views.UserloginController.idlogin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UserCouponViewController implements Initializable {

    @FXML
    private Label lbUseCouponTitle;
    @FXML
    private TextField tfUseCoupon;
    @FXML
    private Button btn_useCoupon;

    /**
     * Initializes the controller class.
     */
    AdminCouponServices adminCouponService = new AdminCouponServices();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   @FXML
    public void useCoupon(ActionEvent event) {
        String code = tfUseCoupon.getText();
       int discount= adminCouponService.checkCouponValidity(code);
        if (discount > 0) {
            ServicesShoppingCart sc=new ServicesShoppingCart();
            ShoppingCart a=new ShoppingCart(idlogin);
            a=sc.setActiveCart(a);
            sc.setDiscount(a,discount);
            JOptionPane.showMessageDialog(null, "Coupon Used");
        } else {
            JOptionPane.showMessageDialog(null, "Please add a valid coupon ");
        }

    }
    
}
