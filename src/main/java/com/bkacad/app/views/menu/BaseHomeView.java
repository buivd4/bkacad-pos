package com.bkacad.app.views.menu;

import com.bkacad.app.App;
import com.bkacad.app.controllers.UserController;
import com.bkacad.app.exceptions.AbstractException;
import com.bkacad.app.views.AbstractView;

public class BaseHomeView extends AbstractView{
    UserController userController = App.getUserController();
    @Override
    public void render() throws AbstractException{
        System.out.println("-------------------");
        System.out.println(String.format("Welcome back, %s ...", App.loggedIn.username));
    }
}
