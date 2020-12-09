/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.viewsControllers;

import bookstore.views.ViewFactory;

/**
 *
 * @author PC-Hamouda
 */
public abstract class BaseController {
    protected ViewFactory vf;
    private String fxmlName;
    public BaseController(){
        
    }

    public BaseController(ViewFactory vf, String fxmlName) {
        this.vf = vf;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}