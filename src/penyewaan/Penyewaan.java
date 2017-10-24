package penyewaan;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import kasir.Kasir;
import penyewa.Penyewa;
import penyewaanitem.Penyewaanitem;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "penyewaan")
public class Penyewaan {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String noboking;
    @DatabaseField(columnName = "tglrental")
    private String tglSewa;
    @DatabaseField(columnName = "tglmain")
    private String tglMain;
    @DatabaseField(columnName = "jammasuk")
    private String jmMasuk;
    @DatabaseField(columnName = "jamkeluar")
    private String jmKeluar;
    @DatabaseField
    private double totalbayar;
    @DatabaseField(columnName = "uangmuka")
    private double uangmuka;
    @DatabaseField(columnName = "sisabayar")
    private double sisabayar;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Penyewa penyewa;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Kasir kasir;
    @ForeignCollectionField
    private ForeignCollection<Penyewaanitem> penyewaanitems;

    public ForeignCollection<Penyewaanitem> getPenyewaanitems() {
        return penyewaanitems;
    }

    public void setPenyewaanitems(ForeignCollection<Penyewaanitem> penyewaanitems) {
        this.penyewaanitems = penyewaanitems;
    }

    public String getNoboking() {
        return noboking;
    }

    public void setNoboking(String noboking) {
        this.noboking = noboking;
    }

    public double getUangmuka() {
        return uangmuka;
    }

    public void setUangmuka(double uangmuka) {
        this.uangmuka = uangmuka;
    }

    public double getSisabayar() {
        return sisabayar;
    }

    public void setSisabayar(double sisabayar) {
        this.sisabayar = sisabayar;
    }

    public double getTotalbayar() {
        return totalbayar;
    }

    public void setTotalbayar(double totalbayar) {
        this.totalbayar = totalbayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getTglMain() {
        return tglMain;
    }

    public void setTglMain(String tglMain) {
        this.tglMain = tglMain;
    }

    public String getJmMasuk() {
        return jmMasuk;
    }

    public void setJmMasuk(String jmMasuk) {
        this.jmMasuk = jmMasuk;
    }

    public String getJmKeluar() {
        return jmKeluar;
    }

    public void setJmKeluar(String jmKeluar) {
        this.jmKeluar = jmKeluar;
    }

    public Penyewa getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(Penyewa penyewa) {
        this.penyewa = penyewa;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

}
