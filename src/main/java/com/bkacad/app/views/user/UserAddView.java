package com.bkacad.app.views.user;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exceptions.AbstractException;
import com.bkacad.app.models.entity.User.UserRole;
import com.bkacad.app.views.AbstractView;
import com.bkacad.app.views.error.ErrorView;

public class UserAddView extends AbstractView{
    Scanner input = App.getInput();

    public String username, password;
    public UserRole role;
    UserController userController=App.getUserController();

    public void render() throws AbstractException{
        System.out.println("--[Add User]--");
        System.out.print("- Username: ");
        this.username = input.nextLine();
        System.out.print("- Passworx: ");
        this.password = input.nextLine();
        System.out.print("- Role ([A] Admin/[S] Sale/[W] Warehouse): ");
        String roleSelection = input.nextLine();
        switch (roleSelection){
            case "A":
                this.role=UserRole.ADMIN;
                break;
            case "S":
                this.role=UserRole.SALE;
                break;
            case "W":
                this.role=UserRole.WAREHOUSE;
                break;
            default:
                new ErrorView("Wrong input role!!!").render();
        }
        this.userController.process(this).display();
    }
    
}
