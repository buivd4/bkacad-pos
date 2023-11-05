package com.bkacad.app.views.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.menu.AdminHomeView;
import com.bkacad.app.views.user.prompt.PromptUsernameForReadView;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserEditView extends AbstractView{
    @Getter
    User user;
    UserController userController=App.getUserController();
    Scanner input = App.getInput();
    public UserEditView(User user){
        this.user = user;
    }

    public void render() throws AbstractException {
        System.out.println(String.format("--[Edit user %s]--",user.username));
        System.out.print(String.format("- password [current %s]: ", user.password));
        user.password = input.nextLine();
        System.out.print(String.format("- role [current %s]: ", user.getRole()));
        user.setRole(input.nextLine());
        this.userController.process(this).display();
    }    
}
