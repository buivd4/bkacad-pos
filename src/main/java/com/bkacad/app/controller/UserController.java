package com.bkacad.app.controller;

import com.bkacad.app.model.User;
import com.bkacad.app.model.UserManager;
import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.user.UserAddView;
import com.bkacad.app.view.user.UserListView;
import com.bkacad.app.view.menu.AdminMenu;

public class UserController {
    public static AbstractView process(UserAddView view){
        UserManager.addUser(new User(view.username, view.password, view.role));
        return new AdminMenu();
    }
    public static AbstractView list(){
        return new UserListView(UserManager.findUser());
    }
}
