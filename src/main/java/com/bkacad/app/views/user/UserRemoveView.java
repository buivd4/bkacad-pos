package com.bkacad.app.views.user;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.views.AbstractView;

public class UserRemoveView extends AbstractView{
    Scanner input = App.getInput();
    public String username;
    UserController userController=App.getUserController();

    public void render() throws AbstractException{
        System.out.println("--[User Remove]--");
        System.out.print("- Username: ");
        this.username = input.nextLine();
        userController.process(this).render();
    }
    
}
