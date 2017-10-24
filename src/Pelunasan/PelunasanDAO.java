/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelunasan;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import penyewaan.Penyewaan;
import penyewaanitem.Penyewaanitem;

/**
 *
 * @author MurabbiProgrammer
 */
public interface PelunasanDAO {

    public DefaultTableModel Pelunasan();

    public DefaultTableModel selectAll(String key);

    public DefaultTableModel search(String key);

    public List<Penyewaanitem> loadPenyewaanItem(int id);

    public List<Penyewaan> loadPenyewaan();

    public void insertPelunasan(Pelunasan pelunasan);

    public DefaultTableModel viewItem(int id);

}
