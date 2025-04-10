package dk.easv.mohammadabd.ems.BLL;

import dk.easv.mohammadabd.ems.BE.Admin;
import dk.easv.mohammadabd.ems.DAL.DBAdmin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginBL {
    DBAdmin dbAdmin = new DBAdmin();
    List<Admin> admins = new ArrayList<Admin>();

    public boolean login(String username, String password) throws SQLException {
        admins = dbAdmin.getAllAdmins();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }

        return false;

    }
}
