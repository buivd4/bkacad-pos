package com.bkacad.app.views.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.menu.AdminHomeView;

public class UserListView extends AbstractView{
    ArrayList<User> users;
    UserController userController=App.getUserController();

    public UserListView(ArrayList<User> users){
        this.users = users;
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
    
    public void render() throws AbstractException {
        Scanner input = new Scanner(System.in);
        System.out.println("--[List Users]--");
        for (int i = 0; i<this.users.size();i++){
            System.out.printf("- [User] username: %s | role: %s \n", users.get(i).username, users.get(i).role.toString());
        }
        System.out.println("Press any key to continue...");
        input.nextLine();
        input.close();
        new AdminHomeView().render();
    }    
}
