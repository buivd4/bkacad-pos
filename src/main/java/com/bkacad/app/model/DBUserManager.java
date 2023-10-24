package com.bkacad.app.model;

import java.util.ArrayList;
import java.sql.*;

import com.bkacad.app.model.User;
import com.bkacad.app.model.User.UserRole;
import com.bkacad.app.exception.UserNotFoundException;

public class DBUserManager {
    static final String TABLE_NAME = "users";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bkacad_pos?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "my-secret-pw";
    static Connection conn;
    public static void init() throws SQLException{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    public static void addUser(User user) throws SQLException{
        final String QUERY = "insert into users (username, password, role) values ('"+user.username+"', '"+user.password+"', '"+user.getRole()+"')";
        Statement stm = conn.createStatement();
        stm.executeUpdate(QUERY);
    }

    public static User findUser(String username) throws SQLException,UserNotFoundException{
        final String QUERY = "select * from users where users.username='"+username+"'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(QUERY);
        if (rs.next()){
            return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
        }
        else {
            throw new UserNotFoundException(username);
        }
    }
    
    public static ArrayList<User> findUser() throws SQLException{
        final String QUERY = "select * from users";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(QUERY);
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()){
            users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
        }
        return users;
    }
}
