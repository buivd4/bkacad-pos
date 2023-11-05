package com.bkacad.app.views.error;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exceptions.AbstractException;
import com.bkacad.app.utils.ViewHelper;
import com.bkacad.app.views.AbstractView;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;

public class ErrorView extends AbstractView{
    String msg;
    Scanner input = App.getInput();
    public ErrorView(AbstractException e){
        this.msg = e.getMessage();
    }
    public ErrorView(String msg){
        this.msg = msg;
    }
    public void render(){
        System.out.println("--[Error]--");
        System.out.println(this.msg);
        System.out.println("Press any key to continue...");
        input.nextLine();
        ViewHelper.clearConsole();
    }
}
