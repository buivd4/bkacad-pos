package com.bkacad.app.views.menu;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.exception.WrongUserInputException;
import com.bkacad.app.views.error.ErrorView;
import com.bkacad.app.views.user.UserAddView;

public class AdminHomeView extends BaseHomeView{
    private Scanner input = App.getInput();

    @Override
    public void render() throws AbstractException{
        while (true){
            super.render();
            System.out.println("-------------------");
            System.out.println("Choose an action...");
            System.out.println("[L] List users");
            System.out.println("[V] View user");
            System.out.println("[C] Create user");
            System.out.println("[E] Edit user");
            System.out.println("[R] Remove user");
            System.out.println("[-] Exit");
            System.out.print("Your selection [L]/[V]/[C]/[E]/[R]/[-]: ");
            String selection = input.nextLine();
            switch (selection){
                case "L":
                    userController.process().render();;
                    break;
                case "V":
                    userController.process().render();;
                    break;

                case "C":
                    new UserAddView().render();;
                    break;
                case "-":
                    System.out.println("Good bye...");
                    return;
                default:
                    ErrorView ev = new ErrorView(new WrongUserInputException("Wrong selection!!!!!"));
                    ev.render();
            }
        }
    }
}
