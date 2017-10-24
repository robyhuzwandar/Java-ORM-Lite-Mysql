package kasir;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murabbiprogrammer
 */
public class KasirDAO implements DAO {

    Dao<Kasir, Integer> dao;

    public KasirDAO() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Kasir.class);
        } catch (Exception e) {
            System.out.println("Gagal KasirDao : " + e);
        }
    }

    @Override
    public void insert(Object o) {
        try {
            dao.create((Kasir) o);
        } catch (SQLException ex) {
            System.out.println("Gagal simpan : " + ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Kasir) o);
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
        String[] header = {"id", "Nama", "Username"};
        dtm = new DefaultTableModel(null, header);

        try {
            List<Kasir> listk = dao.queryForAll();
            for (Kasir k : listk) {
                Object[] o = new Object[3];
                o[0] = k.getId();
                o[1] = k.getNama();
                o[2] = k.getUsername();
            
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
        String[] header = {"id", "Nama", "Username"};
        dtm = new DefaultTableModel(null, header);

        try {
            List<Kasir> listk = dao.queryBuilder().where().like("nama", "%" + key + "%").query();
            for (Kasir k : listk) {
                Object[] o = new Object[3];
                o[0] = k.getId();
                o[1] = k.getNama();
                o[2] = k.getUsername();

                dtm.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Gagal di tampilan : " + e);
        }
        return dtm;
    }

}
