package com.bkacad.app.views.user;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.menu.AdminHomeView;
import com.bkacad.app.views.popup.AnnouncementView;

import lombok.Getter;

public class UserRemoveView extends AbstractView{
    Scanner input = App.getInput();
    @Getter
    User user;
    UserController userController=App.getUserController();

    public UserRemoveView(User user){
        this.user=user;
    }
    public void render() throws AbstractException{
        System.out.println("--[User Remove]--");
        System.out.print(String.format("Confirm to remove user %s [Y/N]:", user.username));
        String c = input.nextLine();
        switch (c) {
            case "Y":
                userController.process(this).display();
                break;
            case "N":
                new AnnouncementView<AdminHomeView>("[N] Cancel...", new AdminHomeView());
                break;
            default:
                new AnnouncementView<UserRemoveView>("Wrong input... Choose again", this);
                break;
        }
        userController.process(this).display();
    }
    
}
