package com.bkacad.app.views.menu;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exceptions.AbstractException;
import com.bkacad.app.exceptions.WrongUserInputException;
import com.bkacad.app.views.error.ErrorView;
import com.bkacad.app.views.error.NotImplementedYetView;

public class WarehouseHomeView extends BaseHomeView{
    private Scanner input = App.getInput();

    @Override
    public void render() throws AbstractException{
        while (true){
            super.render();
            System.out.println("-------------------");
            System.out.println("Choose an action...");
            System.out.println("[L] List products");
            System.out.println("[V] View product");
            System.out.println("[C] Create product");
            System.out.println("[E] Edit product");
            System.out.println("[R] Remove product");
            System.out.println("[-] Exit");
            System.out.print("Your selection [L]/[V]/[C]/[E]/[R]: ");
            String selection = input.nextLine();
            switch (selection){
                case "L":
                case "V":
                case "C":
                case "E":
                case "R":
                    new NotImplementedYetView().render();
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
