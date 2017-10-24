package menu;

import Pelunasan.f_pelunasan;
import alatlap.f_alatlap;
import auth.Auth;
import auth.Form_auth;
import com.jtattoo.plaf.JTattooUtilities;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import kasir.f_kasir;
import penyewa.f_penyewa;
import penyewaan.f_penyewaan;

/**
 *
 * @author MurabbiProgrammer
 */
public class Form_main extends javax.swing.JFrame {
    
    private Beranda beranda;
    
    private Profil profil;
    private Developer developer;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    
    public Form_main() {
        super("Murabbi Futsal ");
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        jam();
        jlAdmin.setText(Auth.NAMA);
        jltgl.setText(dateFormat.format(date));

//      cardlayout
        beranda = new Beranda();
        panelDasar.add("beranda", beranda);
        
        profil = new Profil();
        panelDasar.add("profil", profil);
        
        developer = new Developer();
        panelDasar.add("developer", developer);
        
    }
    
    private void jam() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nol_bulan = "";
                String nol_hari = "";
                String nol_jam = "";
                String nol_menit = "";
                String nol_detik = "";
                Calendar dt = Calendar.getInstance();
                
                int nilai_jam = dt.get(Calendar.HOUR_OF_DAY);
                int nilai_menit = dt.get(Calendar.MINUTE);
                int nilai_detik = dt.get(Calendar.SECOND);
                
                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }
                
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                jamDigital.setText(jam + ":" + menit + ":" + detik);
                
            }
        };
        new javax.swing.Timer(1000, taskPerformer).start();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnPenyewa = new javax.swing.JButton();
        btnItem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        btnPembayaran = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        btnProfil = new javax.swing.JButton();
        btnKontak = new javax.swing.JButton();
        btnBantuan = new javax.swing.JButton();
        panelDasar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jamDigital = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jlAdmin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jltgl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Home_30px_2.png"))); // NOI18N
        jButton3.setText("Beranda");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Logout Rounded Left_30px.png"))); // NOI18N
        btnLogOut.setText("  Logout  ");
        btnLogOut.setFocusable(false);
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLogOut);

        jTabbedPane1.addTab("Beranda", jToolBar1);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnPenyewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Conference_30px_2.png"))); // NOI18N
        btnPenyewa.setText(" Penyewa");
        btnPenyewa.setFocusable(false);
        btnPenyewa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenyewa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenyewaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnPenyewa);

        btnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Product_30px.png"))); // NOI18N
        btnItem.setText("Alat & Lap");
        btnItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnItem.setFocusable(false);
        btnItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });
        jToolBar2.add(btnItem);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/School Director_30px.png"))); // NOI18N
        jButton1.setText("Kasir");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        jTabbedPane1.addTab("Master", jToolBar2);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Handshake_30px.png"))); // NOI18N
        jButton2.setText("Penyewaan");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton2);

        btnPembayaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Cash In Hand_30px.png"))); // NOI18N
        btnPembayaran.setText(" Pembayaran ");
        btnPembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPembayaran.setFocusable(false);
        btnPembayaran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPembayaran.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPembayaranMouseClicked(evt);
            }
        });
        btnPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembayaranActionPerformed(evt);
            }
        });
        jToolBar3.add(btnPembayaran);

        jTabbedPane1.addTab("Transaksi", jToolBar3);

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Apartment_30px_1.png"))); // NOI18N
        btnProfil.setText("Profil");
        btnProfil.setFocusable(false);
        btnProfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });
        jToolBar4.add(btnProfil);

        btnKontak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Work_30px.png"))); // NOI18N
        btnKontak.setText("Developer");
        btnKontak.setFocusable(false);
        btnKontak.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKontak.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKontakActionPerformed(evt);
            }
        });
        jToolBar4.add(btnKontak);

        btnBantuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baruicon/Help_30px_1.png"))); // NOI18N
        btnBantuan.setText("Bantuan");
        btnBantuan.setFocusable(false);
        btnBantuan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBantuan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(btnBantuan);

        jTabbedPane1.addTab("Tentang", jToolBar4);

        panelDasar.setBackground(new java.awt.Color(20, 143, 166));
        panelDasar.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(1, 59, 70));

        jamDigital.setBackground(new java.awt.Color(4, 100, 5));
        jamDigital.setFont(new java.awt.Font("Kalimati", 0, 24)); // NOI18N
        jamDigital.setForeground(new java.awt.Color(254, 254, 254));
        jamDigital.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jamDigital.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator1.setBackground(new java.awt.Color(7, 42, 103));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User_20px.png"))); // NOI18N

        jlAdmin.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jlAdmin.setText("Admin");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2/Tear Off Calendar_20px.png"))); // NOI18N

        jltgl.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jltgl.setText("Tanggal saat ini");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jamDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAdmin)))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jltgl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jamDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jlAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jltgl))
                .addContainerGap(380, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(1, 59, 70));

        jLabel1.setFont(new java.awt.Font("URW Gothic L Book", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Create by : Murabbi Programmer");

        jLabel2.setFont(new java.awt.Font("URW Gothic L Book", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Call : +62 8312 997 8394");

        jLabel3.setFont(new java.awt.Font("URW Gothic L Book", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Aplikasi Futsal Copy right @2017");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelDasar, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        new f_alatlap().setVisible(true);
    }//GEN-LAST:event_btnItemActionPerformed

    private void btnPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenyewaActionPerformed
        new f_penyewa().setVisible(true);
    }//GEN-LAST:event_btnPenyewaActionPerformed

    private void btnPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembayaranActionPerformed
        new f_pelunasan().setVisible(true);
    }//GEN-LAST:event_btnPembayaranActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new f_kasir().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new f_penyewaan().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPembayaranMouseClicked
        
    }//GEN-LAST:event_btnPembayaranMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panelDasar.setVisible(true);
        layout("beranda");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Form_auth().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        panelDasar.setVisible(true);
        layout("profil");
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnKontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKontakActionPerformed
        panelDasar.setVisible(true);
        layout("developer");
    }//GEN-LAST:event_btnKontakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(new Form_main());
                } catch (Exception e) {
                    System.out.println(e);
                }
                new Form_main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBantuan;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnKontak;
    public static javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPembayaran;
    private javax.swing.JButton btnPenyewa;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    public static javax.swing.JLabel jamDigital;
    private javax.swing.JLabel jlAdmin;
    private javax.swing.JLabel jltgl;
    public static javax.swing.JPanel panelDasar;
    // End of variables declaration//GEN-END:variables

    public void layout(String card) {
        CardLayout cl = (CardLayout) panelDasar.getLayout();
        cl.show(panelDasar, card);
    }
    
}
