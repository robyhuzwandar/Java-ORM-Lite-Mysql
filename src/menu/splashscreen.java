package menu;

import auth.Form_auth;
import com.sun.javafx.applet.Splash;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author murabbiprogrammer
 */
public class splashscreen {

    public static void main(String[] args) {
        splash Splash = new splash();
        Splash.setVisible(true);

        Form_auth fa = new Form_auth();

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
                Splash.loadingnum.setText(Integer.toString(i) + "%");
                Splash.loadingbar.setValue(i);

                if (i == 100) {
                    fa.setVisible(true);
                    Splash.dispose();
                }

            }
        } catch (Exception e) {
        }
    }
}
