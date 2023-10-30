package com.bkacad.app.views.menu;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.exception.WrongUserInputException;
import com.bkacad.app.views.error.ErrorView;

public class SaleHomeView extends BaseHomeView{
    private Scanner input = App.getInput();

    @Override
    public void render() throws AbstractException{
        while (true){
            super.render();
            System.out.println("-------------------");
            System.out.println("Choose an action...");
            System.out.println("[L] List invoices");
            System.out.println("[V] View invoice");
            System.out.println("[C] Create invoice");
            System.out.println("[X] Export invoice");
            System.out.println("[E] Edit invoice");
            System.out.println("[R] Remove invoice");
            System.out.println("[-] Exit");
            System.out.print("Your selection [L]/[V]/[C]/[X]/[E]/[R]: ");
            String selection = input.nextLine();
            switch (selection){
                case "A":
                    break;
                case "V":
                    break;
                case "E":
                    System.out.println("Good bye...");
                    return;
                default:
                    ErrorView ev = new ErrorView(new WrongUserInputException("Wrong selection!!!!!"));
                    ev.render();
            }
        }
    }
}
