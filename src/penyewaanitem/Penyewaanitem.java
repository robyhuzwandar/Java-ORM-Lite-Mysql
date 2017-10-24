package penyewaanitem;

import alatlap.AlatLap;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Collection;
import penyewa.Penyewa;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "penyewaan_item")
public class Penyewaanitem {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int jumlahjam;
    @DatabaseField
    private int qty;
    @DatabaseField
    private double subtotal;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AlatLap alatLap;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Penyewaan penyewaan;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Penyewaan getPenyewaan() {
        return penyewaan;
    }

    public void setPenyewaan(Penyewaan penyewaan) {
        this.penyewaan = penyewaan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJumlahjam() {
        return jumlahjam;
    }

    public void setJumlahjam(int jumlahjam) {
        this.jumlahjam = jumlahjam;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public AlatLap getAlatLap() {
        return alatLap;
    }

    public void setAlatLap(AlatLap alatLap) {
        this.alatLap = alatLap;
    }

}
