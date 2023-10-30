package com.bkacad.app.views.error;

import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.views.AbstractView;

public class ErrorView extends AbstractView{
    String msg;
    public ErrorView(AbstractException e){
        this.msg = e.getMessage();
    }
    public ErrorView(String msg){
        this.msg = msg;
    }
    public void render(){
        System.out.println("--[Error]--");
        System.out.println(this.msg);
    }
}
