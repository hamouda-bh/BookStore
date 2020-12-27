/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booklab.views;

import com.booklab.models.CouponAdmin;
import com.booklab.services.AdminCouponServices;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Coupon;
import static java.lang.String.format;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdminCouponViewController implements Initializable {
@FXML
    private TextField tfPercentOff;

    @FXML
    private TableColumn<CouponAdmin, String> col_coupon;

    @FXML
    private Button btn_useCoupon;

    @FXML
    private TableView<CouponAdmin> table_couponAdmin;

    @FXML
    private TableColumn<CouponAdmin, String> col_duration;

    @FXML
    private TextField tfCoupon;

    @FXML
    private TableColumn<CouponAdmin, Integer> col_percentOff;
    @FXML
    private TableColumn<CouponAdmin, Integer> col_duration_in_months;
  @FXML
    private ToggleGroup duration;
  
  
    @FXML
    private RadioButton once;

    @FXML
    private RadioButton repeating;
    
    @FXML
    private RadioButton forever;

    @FXML
    private TextField tf_duration_in_months;
      @FXML
    private Button btn_remove;

   
    /**
     * Initializes the controller class.
     */
    
    AdminCouponServices adminCouponServices = new AdminCouponServices();
     ObservableList<CouponAdmin> oList = FXCollections.observableArrayList(adminCouponServices.showAll());
    int index = -1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
          col_coupon.setCellValueFactory(new PropertyValueFactory<CouponAdmin, String>("name"));
              col_percentOff.setCellValueFactory(new PropertyValueFactory<CouponAdmin, Integer>("percentOff"));
          col_duration.setCellValueFactory(new PropertyValueFactory<CouponAdmin, String>("duration"));

        
        //load the data
          table_couponAdmin.setItems(oList);
          //update table to allow modification 
        table_couponAdmin.setEditable(true);
        col_coupon.setCellFactory(TextFieldTableCell.forTableColumn());
        col_percentOff.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_duration.setCellFactory(TextFieldTableCell.forTableColumn());

    }    
        @FXML
    void create(ActionEvent event) throws StripeException {
        Stripe.apiKey = "sk_test_51HwEFLJckn1j87GBtuYkBmynyuvX2Nu8UyGJJCDkePnFOJOhFullBolltHImMC6g82zFRq5FuCBxo4X9Oefvoq2F005eLidPd1";
         String durationSelected;
        if (once.isSelected() ){
                durationSelected = once.getText();
        }else if (repeating.isSelected()){
            durationSelected = repeating.getText();
        }else {
                durationSelected = forever.getText();
        }
        
        Map<String, Object> params = new HashMap<>();
        params.put("name", tfCoupon.getText());
        params.put("duration",durationSelected);//
        params.put("percent_off", tfPercentOff.getText());

        
        if (repeating.isSelected()){
        params.put("duration_in_months", tf_duration_in_months.getText());

        }
        Coupon  coupon = Coupon.create(params);

     CouponAdmin couponAdmin=new CouponAdmin(coupon.getName(), coupon.getDuration(),coupon.getPercentOff().intValue());
     adminCouponServices.add(couponAdmin);
                JOptionPane.showMessageDialog(null, "Coupon  Added");
                adminCouponServices.showAll();
                oList.add(couponAdmin);
                tfCoupon.clear();
                once.getProperties().clear();
                repeating.getProperties().clear();
                forever.getProperties().clear();

    }
    public void showCoupons(){
        index = table_couponAdmin.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        CouponAdmin couponAdminSelected = table_couponAdmin.getSelectionModel().getSelectedItem();
        col_coupon.setText(col_coupon.getCellData(index).toString());
        col_duration.setText(col_duration.getCellData(index).toString());
        col_percentOff.setText(col_percentOff.getCellData(index).toString());
        adminCouponServices.showAll();
        table_couponAdmin.setItems(oList);
    }
     @FXML
    private void removeCoupon(ActionEvent event) throws StripeException {
        CouponAdmin couponSelected = table_couponAdmin.getSelectionModel().getSelectedItem();
        if (couponSelected == null) {
            JOptionPane.showMessageDialog(null, "Select Row to Remove!");
        } else {
            adminCouponServices.delete(couponSelected);
            oList.remove(couponSelected);
        }
    }
    
     public void updateCouponName(TableColumn.CellEditEvent edittedCell) {
        CouponAdmin couponSelected = table_couponAdmin.getSelectionModel().getSelectedItem();
        couponSelected.setName(edittedCell.getNewValue().toString());
        adminCouponServices.modify(couponSelected);
    }

    public void updateCouponDuration(TableColumn.CellEditEvent edittedCell) {
        CouponAdmin couponSelected = table_couponAdmin.getSelectionModel().getSelectedItem();
        couponSelected.setDuration(edittedCell.getNewValue().toString());
        adminCouponServices.modify(couponSelected);
        
    }

    public void updateCouponPercentOff(TableColumn.CellEditEvent edittedCell) {
         CouponAdmin couponSelected = table_couponAdmin.getSelectionModel().getSelectedItem();
        couponSelected.setPercentOff((int) edittedCell.getNewValue());
        adminCouponServices.modify(couponSelected);
    }
}
