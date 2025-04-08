package dk.easv.mohammadabd.ems.GUI.Model;

import dk.easv.mohammadabd.ems.BLL.LoginBL;

import java.sql.SQLException;

public class LoginML {
    LoginBL loginBL = new LoginBL();

    public boolean Login(String email, String password) throws SQLException {
        if(loginBL.login(email, password)){
            System.out.println("Login Successful");
            return true;
        }else{
            System.out.println("Login Failed");
            return false;
        }
    }
}
