package Aplikasi.Admin;

import Aplikasi.Admin.FormMasuk;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *
 * @author Jie
 */
public class Splash extends JWindow {

    private Image image;
    private JLabel label;

    public Splash() {
        super();
        label = new JLabel();
        setLayout(new BorderLayout());
        add(label);

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        label.setIcon(new ImageIcon(image));
        pack();
    }

    public static void main(String[] usu) {
        new Thread(new Runnable() {

            public void run() {
                try {
                    final Splash window = new Splash();
                    window.setAlwaysOnTop(true);
                    window.setImage(new ImageIcon(getClass().getResource("/Resources/splash.png")).getImage());
                    window.setLocationRelativeTo(null);
                    
                    window.setVisible(true);

                    Thread.sleep(5000);
                    new FormMasuk().setVisible(true);

                    window.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
