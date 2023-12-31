package com.bkacad.app.views.user.prompt;

import java.util.ArrayList;
import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exceptions.AbstractException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.menu.AdminHomeView;

import lombok.Getter;
import lombok.Setter;

public class PromptUsernameForEditView extends AbstractView{
    @Getter
    public String username;
    Scanner input = App.getInput();
    
    UserController controller = App.getUserController();
    
    public void render() throws AbstractException {
        System.out.print("Specify username: ");
        this.username = input.nextLine();
        controller.process(this).display();
    }    
}
