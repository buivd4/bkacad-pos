package com.bkacad.app.view.error;

import com.bkacad.app.view.AbstractView;

public class ErrorView extends AbstractView{
    Exception e;
    public ErrorView(Exception e){
        this.e = e;
    }
    public void render(){
        System.out.println(e.getMessage());
    }
}
