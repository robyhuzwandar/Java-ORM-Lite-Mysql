/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelunasan;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import penyewaan.Penyewaan;
import penyewaan.PenyewaanDAOImp;
import penyewaanitem.Penyewaanitem;

/**
 *
 * @author MurabbiProgrammer
 */
public class PelunasanDAOImp implements PelunasanDAO {

    private Dao<Pelunasan, Integer> daoPelunasan;
//    private Dao<Pelunasan2, Integer> daoPelunasan2;
    private Dao<Penyewaan, Integer> daoPenyewaan;
    private Dao<Penyewaanitem, Integer> daoPenyewaanitems;
    private Dao<Pelunasan, Integer> daoPelunasan1;
    List<Penyewaanitem> penyewaanitem = new ArrayList<>();

    public PelunasanDAOImp() {
        try {
            daoPelunasan = DaoManager.createDao(Koneksi.cs(), Pelunasan.class);
            daoPenyewaan = DaoManager.createDao(Koneksi.cs(), Penyewaan.class);
            daoPelunasan1 = DaoManager.createDao(Koneksi.cs(), Pelunasan.class);
//            daoPelunasan2 = DaoManager.createDao(Koneksi.cs(), Pelunasan2.class);
            daoPenyewaanitems = DaoManager.createDao(Koneksi.cs(), Penyewaanitem.class);
            daoPenyewaan = DaoManager.createDao(Koneksi.cs(), Penyewaan.class);
        } catch (SQLException ex) {
            Logger.getLogger(PelunasanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public DefaultTableModel selectAll(String key) {
        DefaultTableModel dtm;
        String[] title = {"ID", "Nama Alat", "Qty"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Pelunasan> pelunasans = daoPelunasan.queryBuilder().where().eq("norental", key).query();
            for (Pelunasan p : pelunasans) {
                Object[] o = new Object[3];
                o[0] = p.getId();
                o[1] = p.getAlatLap().getNama();
                o[2] = p.getQty();

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelunasanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
        DefaultTableModel dtm;
        String[] title = {"ID", "No Bayar", "No Boking", "Team", "TotalBayar", "Uang bayar", "Uang kembali"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Pelunasan> pelunasans = daoPelunasan.queryBuilder().where().like("tglbayar", "%" + key + "%").query();
            for (Pelunasan p : pelunasans) {
                Object[] o = new Object[8];
                o[0] = p.getId();
                o[1] = p.getNorental();
                o[2] = p.getPenyewaan().getNoboking();
                o[3] = p.getPenyewaan().getPenyewa().getTeam();
                o[4] = p.getPenyewaan().getTotalbayar();
                o[5] = p.getUangpelunasan();
                o[6] = p.getUangkembali();

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelunasanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public DefaultTableModel Pelunasan() {
        DefaultTableModel dtm;
        String[] title = {"ID", "No Rental", "Kasir", "Tanggal Bayar", "Uang pelunasan", "Uang Kembali"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Pelunasan> pelunasan = daoPelunasan.queryBuilder().groupBy("norental").query();
            for (Pelunasan p : pelunasan) {
                Object[] o = new Object[6];
                o[0] = p.getId();
                o[1] = p.getNorental();
                o[2] = p.getKasir().getNama();
                o[3] = p.getTglbayar();
                o[4] = p.getUangpelunasan();
                o[5] = p.getUangkembali();

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public void insertPelunasan(Pelunasan pelunasan) {
        try {
            for (Penyewaanitem p : penyewaanitem) {
                pelunasan.setQty(p.getQty());
                pelunasan.setAlatLap(p.getAlatLap());
                daoPelunasan1.create(pelunasan);
            }
            JOptionPane.showMessageDialog(null, "Transaksi pelunasan telah tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PelunasanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Penyewaanitem> loadPenyewaanItem(int id) {
        try {
            penyewaanitem = daoPenyewaanitems.queryBuilder().where().eq("penyewaan_id", id).query();
        } catch (Exception e) {
            System.out.println("Kesalahan load " + e);
        }
        return penyewaanitem;
    }

    @Override
    public List<Penyewaan> loadPenyewaan() {
        List<Penyewaan> penyewaanss = null;
        try {
            penyewaanss = daoPenyewaan.queryBuilder().where().gt("sisabayar", 0.0).query();
        } catch (Exception e) {
            System.out.println("Kesalahan load " + e);
        }
        return penyewaanss;
    }

    public DefaultTableModel viewItem(int id) {
        DefaultTableModel dtm;
        String[] header = {"ID", "No Boking", "Nama", "Harga perjam", "Jumlah Jam ", "Qty ", "subtotal"};
        dtm = new DefaultTableModel(null, header);
        try {
            penyewaanitem = daoPenyewaanitems.queryBuilder().where().eq("penyewaan_id", id).query();
            for (Penyewaanitem p : penyewaanitem) {
                Object[] o = new Object[7];
                o[0] = p.getAlatLap().getId();
                o[0] = p.getPenyewaan().getNoboking();
                o[1] = p.getAlatLap().getNama();
                o[2] = p.getAlatLap().getHargaperjam();
                o[3] = p.getJumlahjam();
                o[4] = p.getQty();
                o[5] = p.getSubtotal();
                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("gagal menampilkan item : " + e);
        }
        return dtm;
    }

}
