package Pelunasan;

import alatlap.AlatLap;
import penyewaanitem.*;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.dao.ForeignCollection;
import kasir.Kasir;
import Pelunasan.Pelunasan;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "pelunasan1")
public class Pelunasan {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String norental;
    @DatabaseField()
    private String tglbayar;
    @DatabaseField()
    private double uangpelunasan;
    @DatabaseField(columnName = "qty")
    private int Qty;
    @DatabaseField()
    private double uangkembali;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Kasir kasir;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Penyewaan penyewaan;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AlatLap alatLap;

    public AlatLap getAlatLap() {
        return alatLap;
    }

    public void setAlatLap(AlatLap alatLap) {
        this.alatLap = alatLap;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    public Penyewaan getPenyewaan() {
        return penyewaan;
    }

    public void setPenyewaan(Penyewaan penyewaan) {
        this.penyewaan = penyewaan;
    }

    public double getUangpelunasan() {
        return uangpelunasan;
    }

    public void setUangpelunasan(double uangpelunasan) {
        this.uangpelunasan = uangpelunasan;
    }

    public String getNorental() {
        return norental;
    }

    public void setNorental(String norental) {
        this.norental = norental;
    }

    public String getTglbayar() {
        return tglbayar;
    }

    public void setTglbayar(String tglbayar) {
        this.tglbayar = tglbayar;
    }

    public double getUangkembali() {
        return uangkembali;
    }

    public void setUangkembali(double uangkembali) {
        this.uangkembali = uangkembali;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
