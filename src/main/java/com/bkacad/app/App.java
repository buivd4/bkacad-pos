package com.bkacad.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bkacad.app.controllers.LoginController;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.models.facade.UserDAOInterface;
import com.bkacad.app.models.impl.DBUserManager;
import com.bkacad.app.views.error.ErrorView;
import com.bkacad.app.views.login.LoginView;

import lombok.Getter;

/**
 * Hello world!
 *
 */
public class App 
{
    static final String TABLE_NAME = "users";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bkacad_pos?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "my-secret-pw";
    public static User loggedIn;

    @Getter
    private static UserController userController;

    @Getter
    private static LoginController loginController;

    @Getter
    private static UserDAOInterface userDAO;

    @Getter
    private static Scanner input;

    public static void init(){
        try {
            App.input = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            App.userDAO = new DBUserManager(conn);
            App.userController = new UserController(userDAO);
            App.loginController = new LoginController(userDAO);
        }
        catch (SQLException e){
            ErrorView err = new ErrorView("SQL: "+e.getMessage());
            err.render();
        }
    }
    public static void main( String[] args )
    {
        init();
        try {
            LoginView lgv = new LoginView();
            lgv.render();
        }
        catch (AbstractException e){
            ErrorView err = new ErrorView(e);
            err.render();
        }
    }
}
