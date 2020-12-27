/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booklab.services;

import com.booklab.Utils.DataSource;
import com.booklab.models.Coupon;
import com.booklab.models.CouponAdmin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AdminCouponServices {

    Connection cnx = DataSource.getInstance().getCnx();

    public void add(CouponAdmin c) {
        try {
            String req = "INSERT INTO CouponAdmin (name, duration,percentOff) VALUES (?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, c.getName());
            st.setString(2, c.getDuration());
            st.setInt(3, c.getPercentOff());
         //   st.setInt(4, c.getDuration_in_months());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
            System.out.println("Added Coupon !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//
//    
    public void delete(CouponAdmin c) {
        try {
            String req = "DELETE FROM CouponAdmin  WHERE idCoupon=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, c.getIdCoupon());
            st.executeUpdate();
            System.out.println("Deleted Coupon !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void modify(CouponAdmin c) {
        try {
            String req = "UPDATE CouponAdmin SET name=? , duration=? , percentOff=?  WHERE idCoupon=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(4, c.getIdCoupon());
            st.setString(1, c.getName());
            st.setString(2, c.getDuration());
            st.setInt(3, c.getPercentOff());
            st.executeUpdate();
            System.out.println("Coupon modified !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public Coupon show(int couponId) {
//        Coupon coupon = null;
//
//        try {
//            String req = "SELECT * FROM coupon  WHERE couponId=?";
//            PreparedStatement st = cnx.prepareStatement(req);
//            st.setInt(1, couponId);
//            ResultSet res = st.executeQuery();
//            while (res.next()) {
//                coupon = new Coupon(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4));
//            }
//            System.out.println(coupon);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return coupon;
//    }

    public List<CouponAdmin> showAll() {
        List<CouponAdmin> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM CouponAdmin";
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                list.add(new CouponAdmin(res.getString(2), res.getString(3), res.getInt(4)));
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
//
//    public boolean checkCouponValidity(String code) {
//      
//        boolean isValid=false;
//        for (int i = 0; i < showAll().size(); i++) {
//            if (showAll().get(i).getCodeCoupon().equals(code)) {
//               isValid=true;
//            } else {
//               isValid=false;
//            }
//        }
//        return isValid;
//    }
    
public int  checkCouponValidity(String code) {

        int  valid=0;
        for (int i = 0; i < showAll().size(); i++) {
            if (showAll().get(i).getName().equals(code)) {
               valid= showAll().get(i).getPercentOff();
            } 
        }
        return valid;
    }
      
      

}
