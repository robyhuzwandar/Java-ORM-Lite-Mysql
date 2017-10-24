package menu;

import java.awt.event.*;

/**
 *
 * @author murabbiprogrammer
 */
public class Beranda extends javax.swing.JPanel {

    static String a, b, c;

    public Beranda() {
        initComponents();
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = jlJalan.getText();
                b = a.substring(0, 1);
                c = a.substring(1, a.length());
                jlJalan.setText(c + b);
            }
        };
        new javax.swing.Timer(300, al).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_gambar111 = new Kebutuhan.gambar.login_gambar11();
        jPanel1 = new javax.swing.JPanel();
        jlJalan = new javax.swing.JLabel();

        login_gambar111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(46, 80, 117));

        jlJalan.setFont(new java.awt.Font("URW Gothic L Book", 0, 18)); // NOI18N
        jlJalan.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jlJalan.setText("                                                                                                                                Selamat Datang, Silahkan Mengelola Aplikasi dengan Baik");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlJalan, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlJalan)
                .addGap(51, 51, 51))
        );

        login_gambar111.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_gambar111, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(login_gambar111, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlJalan;
    private Kebutuhan.gambar.login_gambar11 login_gambar111;
    // End of variables declaration//GEN-END:variables
}
