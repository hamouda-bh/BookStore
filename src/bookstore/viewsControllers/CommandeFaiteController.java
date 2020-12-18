
package bookstore.viewsControllers;

import bookstore.services.FactureService;
import bookstore.utils.JavamailUtil;
import bookstore.utils.PDFutil;
import bookstore.utils.TrayIconDemo;
import bookstore.views.ViewFactory;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfDocument;
import java.awt.SystemTray;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

public class CommandeFaiteController extends BaseController implements Initializable {

    public CommandeFaiteController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }
    @FXML
    private Button bt_envoi_id;

    @FXML
    private Button imprime_id_btn;

    @FXML
    private Button retour_btn_id;

    @FXML
    public void GeneratePDF() throws SQLException, IOException, FileNotFoundException {
        PDFutil pdf = new PDFutil();

        try {
            pdf.factPDF();
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeFaiteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }
    @FXML
    private void imprimer(ActionEvent event) throws FileNotFoundException, IOException, PrintException, PrinterException {
        System.out.println(" can I print?");
        
        

       FileInputStream psStream = null;
        try {
            psStream = new FileInputStream("C:/BookStore/facture.pdf");
            } catch (FileNotFoundException ffne) {
              ffne.printStackTrace();
            }
            if (psStream == null) {
                return;
            }
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);  
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);
         
        PrintService myPrinter = null;
        for (int i = 0; i < services.length; i++){
            String svcName = services[i].toString();           
            if (svcName.contains("printer closest to me")){
                myPrinter = services[i];
                System.out.println("my printer found: "+svcName);
                break;
            }
        }
         
        if (myPrinter != null) {            
            DocPrintJob job = myPrinter.createPrintJob();
            try {
            job.print(myDoc, aset);
            System.out.println("printed");
             
            } catch (Exception pe) {pe.printStackTrace();}
        } else {
            System.out.println("no printer services found");
        }
   
    }

    @FXML
    private void envoimail(ActionEvent event) {

        try {
            JavamailUtil mail = new JavamailUtil();
           
            mail.sendMail("nour.benhadjyahia@esprit.tn");
            System.out.println("email envoyé");
             if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTraymail();
            System.err.println("notiiiifff");
        } else {
            System.err.println("Erreur!!!!");
        }

        } catch (Exception ex) {
            Logger.getLogger(CommandeFaiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
@FXML
    void onCliqRetour(ActionEvent event) {
            vf.showPanier();
            Stage stage = (Stage) bt_envoi_id.getScene().getWindow();
	               	vf.closeStage(stage);
    }

}
