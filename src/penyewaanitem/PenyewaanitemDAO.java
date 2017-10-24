/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penyewaanitem;

import alatlap.AlatLap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import penyewa.Penyewa;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
public interface PenyewaanitemDAO {

    public List<Penyewa> loadpenyewa();

    public List<AlatLap> loadALatLap(String key);

    public DefaultTableModel AllALatLAp(String key);

    public void addItem(Penyewaanitem penyewaitem);

    public void deleteItem(int index);

    public double refreshTotal();

    public DefaultTableModel viewItem();

    public void insertPenyewaan(Penyewaan penyewaan);

    public void reset();

    public DefaultTableModel pencariantf(String key);
}
