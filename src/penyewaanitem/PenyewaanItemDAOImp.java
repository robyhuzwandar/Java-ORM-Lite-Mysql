package penyewaanitem;

import alatlap.AlatLap;
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
import penyewa.Penyewa;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
public class PenyewaanItemDAOImp implements PenyewaanitemDAO {

    Dao<AlatLap, Integer> daoAlatLap;
    private Dao<Penyewa, Integer> daoPenyewa;
    private Dao<Penyewaan, Integer> daoPenyewaan;
    private Dao<Penyewaanitem, Integer> daoPenyewaanItem;

    private List<Penyewaanitem> listItem = new ArrayList<>();

    public PenyewaanItemDAOImp() {
        try {
            daoPenyewa = DaoManager.createDao(Koneksi.cs(), Penyewa.class);
            daoPenyewaanItem = DaoManager.createDao(Koneksi.cs(), Penyewaanitem.class);
            daoPenyewaan = DaoManager.createDao(Koneksi.cs(), Penyewaan.class);
            daoAlatLap = DaoManager.createDao(Koneksi.cs(), AlatLap.class);
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Penyewa> loadpenyewa() {
        List<Penyewa> penyewas = null;
        try {
            penyewas = daoPenyewa.queryForAll();
        } catch (Exception e) {
            System.out.println("Kesalahan load " + e);
        }
        return penyewas;
    }

    @Override
    public DefaultTableModel AllALatLAp(String key) {
        DefaultTableModel dtm;
        String[] header = {"id", "Nama", "Jenis"};
        dtm = new DefaultTableModel(null, header);
        List<AlatLap> alatLaps = null;
        try {
            alatLaps = daoAlatLap.queryBuilder().where().eq("kategori", key).and().gt("stok", 0).query();
            for (AlatLap al : alatLaps) {
                Object[] o = new Object[3];
                o[0] = al.getId();
                o[1] = al.getNama();
                o[2] = al.getJenis();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Gagal di tampilan item : " + e);
        }
        return dtm;
    }

    @Override
    public void addItem(Penyewaanitem penyewaitem) {
        listItem.add(penyewaitem);
    }

    @Override
    public void deleteItem(int index) {
        listItem.remove(index);
    }

    @Override
    public double refreshTotal() {
        double total = 0;
        for (Penyewaanitem penyewaitem : listItem) {
            total += penyewaitem.getSubtotal();
        }
        return total;
    }

    @Override
    public DefaultTableModel viewItem() {
        DefaultTableModel dtm;
        String[] header = {"ID", "Nama", "Harga perjam", "Jumlah Jam ", "Qty ", "subtotal"};
        dtm = new DefaultTableModel(null, header);
        try {
            for (Penyewaanitem p : listItem) {
                Object[] o = new Object[6];
                o[0] = p.getAlatLap().getId();
                o[1] = p.getAlatLap().getNama();
                o[2] = p.getAlatLap().getHargaperjam();
                o[3] = p.getJumlahjam();
                o[4] = p.getQty();
                o[5] = p.getSubtotal();

                dtm.addRow(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenyewaanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public void insertPenyewaan(Penyewaan penyewaan) {

        try {
            daoPenyewaan.create(penyewaan);

            for (Penyewaanitem p : listItem) {
                Penyewaanitem penyewaanitem = new Penyewaanitem();
                //set penyewa
                penyewaanitem.setPenyewaan(penyewaan);
                penyewaanitem.setJumlahjam(p.getJumlahjam());
                penyewaanitem.setQty(p.getQty());
                penyewaanitem.setSubtotal(p.getSubtotal());

                //set alat dan lap
                penyewaanitem.setAlatLap(p.getAlatLap());
                System.out.println();
                daoPenyewaanItem.create(penyewaanitem);
            }
            JOptionPane.showMessageDialog(null, "Transaksi penyewaan telah tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void reset() {
        listItem.removeAll(listItem);
    }

    @Override
    public List<AlatLap> loadALatLap(String key) {
        List<AlatLap> alatLaps = null;
        try {
            alatLaps = daoAlatLap.queryBuilder().where().eq("kategori", key).and().gt("stok", 0).query();
        } catch (Exception e) {
            System.out.println("Kesalahan load " + e);
        }
        return alatLaps;

    }

    @Override
    public DefaultTableModel pencariantf(String key) {
        DefaultTableModel dtm;
        String[] header = {"ID", "Nama", "Jenis"};
        dtm = new DefaultTableModel(null, header);
        try {
            List<AlatLap> lista = daoAlatLap.queryBuilder().where().like("nama", "%" + key + "%").query();
            for (AlatLap al : lista) {
                Object[] o = new Object[3];
                o[0] = al.getId();
                o[1] = al.getNama();
                o[2] = al.getJenis();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("gagal menampilkan item : " + e);
        }
        return dtm;
    }
}
