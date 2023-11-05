package com.bkacad.app.views.popup;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.views.AbstractView;

public class AnnouncementView<i extends AbstractView> extends AbstractView{
    Scanner input = App.getInput();

    String msg;
    i returnedView;
    public AnnouncementView(String msg, i returnedView){
        this.msg = msg;
        this.returnedView = returnedView;
    }
    @Override
    public void render() throws AbstractException {
        System.out.println("--[Announcement]--");
        System.out.println(msg);
        System.out.println("Press any key to continue...");
        String x = input.nextLine();
        this.returnedView.display();
    }
    
}
