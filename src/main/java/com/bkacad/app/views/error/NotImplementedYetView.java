package com.bkacad.app.views.error;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.utils.ViewHelper;
import com.bkacad.app.views.AbstractView;

public class NotImplementedYetView extends AbstractView{
    Scanner input=App.getInput();
    public void render(){
        System.out.println("--[Error]--");
        System.out.println("Not implemented yet. Student, please implement this...");
        System.out.println("Press any key to continue...");
        input.nextLine();
        ViewHelper.clearConsole();
    }

}
