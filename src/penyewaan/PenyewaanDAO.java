/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penyewaan;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murabbiprogrammer
 */
public interface PenyewaanDAO {

    public DefaultTableModel selectAll();

    public DefaultTableModel search(String key);

    public DefaultTableModel detail(int id);
}
