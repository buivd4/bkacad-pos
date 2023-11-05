package com.bkacad.app.models.impl;

import java.util.ArrayList;
import java.sql.*;

import com.bkacad.app.exceptions.ServerErrorException;
import com.bkacad.app.exceptions.UserNotFoundException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.models.facade.UserDAO;

public class DBUserManager implements UserDAO{
    Connection conn;
    public DBUserManager(Connection conn){
        this.conn = conn;
    }

    public User findUser(String username) throws ServerErrorException,UserNotFoundException{
        try {
            // Sử dụng prepareStatement
            final String QUERY = "select * from users where users.username=?";
            PreparedStatement stm = conn.prepareStatement(QUERY);
            // Thay `username` vào dấu ? thứ nhất
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
            else {
                throw new UserNotFoundException(username);
            }
        }
        catch (SQLException e){
            throw new ServerErrorException("SQL: "+e.getMessage());
        }
    }
    
    public void addUser(User user) throws ServerErrorException{
        try {
            // Sử dụng prepareStatement
            final String QUERY = "insert into users(username, password, role) values (?,?,?)";
            PreparedStatement stm = conn.prepareStatement(QUERY);
            // Thay `username` vào dấu ? thứ nhất
            stm.setString(1, user.username);
            stm.setString(2, user.password);
            stm.setString(3, user.getRole());
            stm.executeUpdate();
        }
        catch (SQLException e){
            throw new ServerErrorException("SQL: "+e.getMessage());
        }

    }

    public void delUser(String username) throws ServerErrorException{
        try {
            // Sử dụng prepareStatement
            final String QUERY = "delete from users where username=?";
            PreparedStatement stm = conn.prepareStatement(QUERY);
            // Thay `username` vào dấu ? thứ nhất
            stm.setString(1, username);
            stm.executeUpdate();
        }
        catch (SQLException e){
            throw new ServerErrorException("SQL: "+ e.getMessage());
        }
    }

    public ArrayList<User> findUser() throws ServerErrorException{
        try {
            final String QUERY = "select * from users";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
            }
            return users;
        }
        catch (SQLException e){
            throw new ServerErrorException("SQL: "+ e.getMessage());
        }
    }

    @Override
    public void editUser(User user) throws ServerErrorException {
        try {
            // Sử dụng prepareStatement
            final String QUERY = "update users set password=?, role=? where username=?";
            PreparedStatement stm = conn.prepareStatement(QUERY);
            // Thay `password` vào dấu ? thứ nhất
            stm.setString(1, user.password);
            stm.setString(2, user.getRole());
            stm.setString(3, user.username);
            stm.executeUpdate();
        }
        catch (SQLException e){
            throw new ServerErrorException("SQL: "+e.getMessage());
        }
    }
}
