/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import kasir.Kasir;

/**
 *
 * @author murabbiprogrammer
 */
public class AuthDAOImp implements AuthDAO {

    private Dao<Kasir, Integer> dao;

    public AuthDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Kasir.class);
        } catch (Exception e) {
            System.out.println("Gagal Dao auth : " + e);
        }
    }

    @Override
    public void login(String username, String password) {
        try {
            Kasir kasir = dao.queryBuilder().where()
                    .eq("username", username)
                    .and()
                    .eq("password", password)
                    .queryForFirst();
            if (kasir != null) {
                Auth.ID = kasir.getId();
                Auth.NAMA = kasir.getNama();
                Auth.AUTH = true;
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan login : " + e);
        }
    }

    @Override
    public void logout() {
        Auth.ID = 0;
        Auth.NAMA = null;
        Auth.AUTH = false;
    }

}
