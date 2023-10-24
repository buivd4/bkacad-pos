package com.bkacad.app.model;

import java.util.ArrayList;

import com.bkacad.app.model.User;
import com.bkacad.app.model.User.UserRole;
import com.bkacad.app.exception.UserNotFoundException;

public class UserManager {
    static ArrayList<User> users = new ArrayList<>(); //null

    public static void init(){
        users.add(new User("admin","pass",UserRole.ADMIN));
    }
    public static void addUser(User user){
        users.add(user);
    }

    public static void removeUser(String username){
        for (int i=0;i<users.size(); i++){
            if (users.get(i).username == username){
                users.remove(i);
                break;
            }
        }
    }
    public static User findUser(String username) throws UserNotFoundException{
        for (int i=0;i<users.size(); i++){
            if (users.get(i).username.equals(username)){
                return users.get(i);
            }
        }
        throw new UserNotFoundException(username);
    }
    
    public static ArrayList<User> findUser(){
        return users;
    }
}
