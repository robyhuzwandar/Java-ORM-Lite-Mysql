package kasir;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "kasir")
public class Kasir {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String username;
    @DatabaseField
    private String password;

    @ForeignCollectionField
    ForeignCollection<Penyewaan> penyewaans;

    public ForeignCollection<Penyewaan> getPenyewaans() {
        return penyewaans;
    }

    public void setPenyewaans(ForeignCollection<Penyewaan> penyewaans) {
        this.penyewaans = penyewaans;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
