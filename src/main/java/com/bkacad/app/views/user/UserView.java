package com.bkacad.app.views.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.menu.AdminHomeView;

import lombok.Setter;

public class UserView extends AbstractView{
    @Setter
    private User user;

    Scanner input = App.getInput();
    UserController userController=App.getUserController();

    public UserView(User user){
        this.user = user;
    }
    
    public void render() throws AbstractException {
        System.out.println(String.format("--[User: %s]--",user.username));
        System.out.printf("- [User] username: %s | role: %s \n", user.username, user.role.toString());
        System.out.println("Press any key to continue...");
        input.nextLine();
        new AdminHomeView().display();
    }    
}
