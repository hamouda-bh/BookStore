package bookstore.utils;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class TrayIconDemo {

   

    public void displayTraymail() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
       Image image = Toolkit.getDefaultToolkit().createImage("C:/Users/nour/Desktop/moi.jpg");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon");
        tray.add(trayIcon);

        trayIcon.displayMessage("ADMIN", "mail envoye", MessageType.INFO);
    }
    public void displayTraypdf() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("C:/Users/nour/Desktop/moi.jpg");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon");
        tray.add(trayIcon);

        trayIcon.displayMessage("ADMIN", "pdf success", MessageType.INFO);
    }
  
}