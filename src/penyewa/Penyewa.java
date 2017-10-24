package penyewa;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import penyewaan.Penyewaan;

/**
 *
 * @author murabbiprogrammer
 */
@DatabaseTable(tableName = "penyewa")
public class Penyewa {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String team;
    @DatabaseField
    private String manager;
    @DatabaseField
    private String nohp;
    @DatabaseField
    private String status;

    @ForeignCollectionField
    ForeignCollection<Penyewaan> penyewaans;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ForeignCollection<Penyewaan> getPenyewaans() {
        return penyewaans;
    }

    public void setPenyewaans(ForeignCollection<Penyewaan> penyewaans) {
        this.penyewaans = penyewaans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}
