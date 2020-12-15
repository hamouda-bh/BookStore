/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booklab.models;

import com.stripe.model.CouponCollection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Coupon {

   

 
    private int couponID;
    private String codeCoupon;
      private String couponName;
    private Date expirationDate;
    
    public Coupon(int couponID, String codeCoupon,  String couponName,Date expirationDate ) {
        this.couponID = couponID;
        this.codeCoupon = codeCoupon;
        this.couponName = couponName;
        this.expirationDate=expirationDate;
    }

    public Coupon(String codeCoupon,String couponName,Date expirationDate) {
        this.codeCoupon = codeCoupon;
        this.couponName = couponName;
        this.expirationDate=expirationDate;
    }
   

    public int getCouponID() {
        return couponID;
    }

    public String getCodeCoupon() {
        return codeCoupon;
    }

  

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

   

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

//    public SimpleDateFormat getFormatter() {
//        return formatter;
//    }

    public String getCouponName() {
        return couponName;
    }

//    public void setFormatter(SimpleDateFormat formatter) {
//        this.formatter = formatter;
//    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coupon other = (Coupon) obj;
        if (this.couponID != other.couponID) {
            return false;
        }
        if (!Objects.equals(this.codeCoupon, other.codeCoupon)) {
            return false;
        }
        if (!Objects.equals(this.couponName, other.couponName)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coupon{" + "couponID=" + couponID + ", codeCoupon=" + codeCoupon + ", couponName=" + couponName + ", expirationDate=" + expirationDate + '}';
    }
 
 

}
