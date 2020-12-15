/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booklab.models;

import java.util.Objects;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class CouponAdmin {

    private int idCoupon;
    private String name;

    private String duration;
    private int percentOff;
    private int duration_in_months;

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
    }

    public void setPercentOff(int percentOff) {
        this.percentOff = percentOff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIdCoupon() {
        return idCoupon;
    }

    public int getPercentOff() {
        return percentOff;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String Duration) {
        this.duration = Duration;
    }

    public int getDuration_in_months() {
        return duration_in_months;
    }

    public void setDuration_in_months(int duration_in_months) {
        this.duration_in_months = duration_in_months;
    }

    public CouponAdmin(String name, String duration, int percentOff) {
        this.name = name;
        this.duration = duration;
        this.percentOff = percentOff;
        this.duration_in_months = duration_in_months;

    }

    public CouponAdmin(int idCoupon, String name, String Duration, int percentOff) {
        this.name = name;
        this.idCoupon = idCoupon;
        this.duration = duration;
        this.percentOff = percentOff;
        this.duration_in_months = duration_in_months;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final CouponAdmin other = (CouponAdmin) obj;
        if (this.idCoupon != other.idCoupon) {
            return false;
        }
        if (this.percentOff != other.percentOff) {
            return false;
        }
        if (this.duration_in_months != other.duration_in_months) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CouponAdmin{" + "idCoupon=" + idCoupon + ", name=" + name + ", duration=" + duration + ", percentOff=" + percentOff + ", duration_in_months=" + duration_in_months + '}';
    }

    
}
