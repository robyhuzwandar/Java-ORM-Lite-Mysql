package penyewa;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murabbiprogrammer
 */
public class PenyewaDAO implements DAO {

    Dao<Penyewa, Integer> dao;

    public PenyewaDAO() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Penyewa.class);
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object o) {
        try {
            dao.create((Penyewa) o);
        } catch (SQLException ex) {
            System.out.println("Gagal simpan : " + ex);
        }

    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Penyewa) o);
        } catch (SQLException ex) {
            System.out.println("Gagal Update : " + ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            System.out.println("Gagal Hapus : " + ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        DefaultTableModel dtm;
        String[] header = {"id", "Team", "Manager", "No Hp", "Status"};
        dtm = new DefaultTableModel(null, header);

        try {
            List<Penyewa> listp = dao.queryForAll();
            for (Penyewa p : listp) {
                Object[] o = new Object[5];
                o[0] = p.getId();
                o[1] = p.getTeam();
                o[2] = p.getManager();
                o[3] = p.getNohp();
                o[4] = p.getStatus();

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
        String[] header = {"id", "Team", "Manager", "No Hp", "Status"};
        dtm = new DefaultTableModel(null, header);
        try {
            List<Penyewa> listps = dao.queryBuilder().where().like("team", "%" + key + "%").query();
            for (Penyewa p : listps) {
                Object[] o = new Object[5];
                o[0] = p.getId();
                o[1] = p.getTeam();
                o[2] = p.getManager();
                o[3] = p.getNohp();
                o[4] = p.getStatus();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Pencarian eror : " + e);
        }

        return dtm;
    }

}
