
package bookstore.viewsControllers;

import bookstore.views.ViewFactory;


public abstract class BaseController {
        public float sum=0 ;
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