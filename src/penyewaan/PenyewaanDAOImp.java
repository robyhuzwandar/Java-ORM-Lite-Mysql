package penyewaan;

import penyewaanitem.Penyewaanitem;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murabbiprogrammer
 */
public class PenyewaanDAOImp implements PenyewaanDAO {

    private Dao<Penyewaan, Integer> dao;
    private Dao<Penyewaanitem, Integer> daoItem;

    public PenyewaanDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Penyewaan.class);
            daoItem = DaoManager.createDao(Koneksi.cs(), Penyewaanitem.class);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        DefaultTableModel dtm;
        String[] title = {"ID", "No Boking", "Kasir", "Team", "Tgl Rental", "Tgl Main", "Jam Masuk", "Jam Keluar", "Total Bayar", "Uang Muka", "Sisa Bayar"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Penyewaan> penyewaan = dao.queryBuilder().orderBy("id", false).query();
            for (Penyewaan p : penyewaan) {
                Object[] o = new Object[11];
                o[0] = p.getId();
                o[1] = p.getNoboking();
                o[2] = p.getKasir().getNama();
                o[3] = p.getPenyewa().getTeam();
                o[4] = p.getTglSewa();
                o[5] = p.getTglMain();
                o[6] = p.getJmMasuk();
                o[7] = p.getJmKeluar();
                o[8] = p.getTotalbayar();
                o[9] = p.getUangmuka();
                o[10] = p.getSisabayar();

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
        DefaultTableModel dtm;
        String[] title = {"ID", "No Boking", "Kasir", "Team", "Tgl Rental", "Tgl Main", "Jam Masuk", "Jam Keluar", "Total Bayar", "Uang Muka", "Sisa Bayar"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Penyewaan> penyewaan = dao.queryBuilder().where().like("nama", "%" + key + "%").query();
            for (Penyewaan p : penyewaan) {
                Object[] o = new Object[11];
                o[0] = p.getId();
                o[1] = p.getNoboking();
                o[2] = p.getKasir().getNama();
                o[3] = p.getPenyewa().getTeam();
                o[4] = p.getTglSewa();
                o[5] = p.getTglMain();
                o[6] = p.getJmMasuk();
                o[7] = p.getJmKeluar();
                o[8] = p.getTotalbayar();
                o[9] = p.getUangmuka();
                o[10] = p.getSisabayar();
                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public DefaultTableModel detail(int id) {
        DefaultTableModel dtm;
        String[] title = {"ID", "Nama Barang", "Harga perjam", "Jumlah jam", "Qty", "Subtotal"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Penyewaanitem> penyewaanitems = daoItem.queryForEq("penyewaan_id", id);
            for (Penyewaanitem p : penyewaanitems) {
                Object[] o = new Object[6];
                o[0] = p.getId();
                o[1] = p.getAlatLap().getNama();
                o[2] = p.getAlatLap().getHargaperjam();
                o[3] = p.getJumlahjam();
                o[4] = p.getQty();
                o[5] = p.getSubtotal();

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

}
