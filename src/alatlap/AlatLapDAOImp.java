package alatlap;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murabbiprogrammer
 */
public class AlatLapDAOImp implements AlatlapDaoService {

    Dao<AlatLap, Integer> dao;

    public AlatLapDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), AlatLap.class);
        } catch (Exception e) {
            System.out.println("Gagal KasirDao : " + e);
        }
    }

    @Override
    public void insert(AlatLap alatLap) {
        try {
            dao.create(alatLap);
        } catch (SQLException ex) {
            Logger.getLogger(AlatLapDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(AlatLap alatLap) {
        try {
            dao.update(alatLap);
        } catch (SQLException ex) {
            System.out.println("Gagal simpan : " + ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            System.out.println("Gagal simpan : " + ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        DefaultTableModel dtm;
        String[] header = {"id", "Nama", "Jenis",  "kategori", "Harga sewa perjam", "Stok"};
        dtm = new DefaultTableModel(null, header);

        try {
            List<AlatLap> lista = dao.queryForAll();
            for (AlatLap al : lista) {
                Object[] o = new Object[6];
                o[0] = al.getId();
                o[1] = al.getNama();
                o[2] = al.getJenis();
                o[3] = al.getKategory();
                o[4] = al.getHargaperjam();
                o[5] = al.getStok();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Gagal di tampilan : " + e);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
        DefaultTableModel dtm;
        String[] header = {"id", "Nama", "Jenis", "kategori", "Harga sewa perjam", "Stok"};
        dtm = new DefaultTableModel(null, header);

        try {
            List<AlatLap> lista = dao.queryBuilder().where().like("nama", "%" + key + "%").query();
            for (AlatLap al : lista) {
                Object[] o = new Object[6];
                o[0] = al.getId();
                o[1] = al.getNama();
                o[2] = al.getJenis();
                o[3] = al.getKategory();
                o[4] = al.getHargaperjam();
                o[5] = al.getStok();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Gagal di tampilan : " + e);
        }
        return dtm;
    }

}
