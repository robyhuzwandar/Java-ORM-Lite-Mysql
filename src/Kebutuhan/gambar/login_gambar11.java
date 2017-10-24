package Kebutuhan.gambar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author MurabbiProgrammer
 */
public class login_gambar11 extends JPanel {

    private Image image; // membuat variable image

    public login_gambar11() {
        image = new ImageIcon(getClass().getResource("futsal.jpg")).getImage();
        //memanggil sumber daya gambar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics gd = (Graphics2D) g.create();

        gd.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        // menggambar image
        gd.dispose();
    }

}
