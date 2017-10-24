package alatlap;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import Pelunasan.Pelunasan;
import penyewaanitem.Penyewaanitem;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "alatlap")
public class AlatLap {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String jenis;
    @DatabaseField
    private int stok;
    @DatabaseField(columnName = "kategori")
    private String kategory;
    @DatabaseField
    private double hargaperjam;
//    @DatabaseField(columnDefinition = "LONGBLOB not null", dataType = DataType.BYTE_ARRAY)
//    private byte[] gambar;

    @ForeignCollectionField
    private ForeignCollection<Penyewaanitem> penyewaanitems;

    @ForeignCollectionField
    private ForeignCollection<Pelunasan> pelunasan2s;

    public String getKategory() {
        return kategory;
    }

    public void setKategory(String kategory) {
        this.kategory = kategory;
    }
//
//    public byte[] getGambar() {
//        return gambar;
//    }
//
//    public void setGambar(byte[] gambar) {
//        this.gambar = gambar;
//    }

    public ForeignCollection<Pelunasan> getPelunasan2s() {
        return pelunasan2s;
    }

    public void setPelunasan2s(ForeignCollection<Pelunasan> pelunasan2s) {
        this.pelunasan2s = pelunasan2s;
    }

    public ForeignCollection<Penyewaanitem> getPenyewaanitems() {
        return penyewaanitems;
    }

    public void setPenyewaanitems(ForeignCollection<Penyewaanitem> penyewaanitems) {
        this.penyewaanitems = penyewaanitems;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getHargaperjam() {
        return hargaperjam;
    }

    public void setHargaperjam(double hargaperjam) {
        this.hargaperjam = hargaperjam;
    }

}
