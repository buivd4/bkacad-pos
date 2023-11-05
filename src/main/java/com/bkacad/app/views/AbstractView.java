package com.bkacad.app.views;

import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.utils.ViewHelper;

public abstract class AbstractView {    
    public abstract void render() throws AbstractException;
    public void display() throws AbstractException{
        ViewHelper.clearConsole();
        this.render();
    }
}
