package alatlap;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MurabbiProgrammer
 */
public interface AlatlapDaoService {

    public void insert(AlatLap lap);

    public void update(AlatLap lap);

    public void delete(int id);

    public DefaultTableModel selectAll();

    public DefaultTableModel search(String key);

}
