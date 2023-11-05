package com.bkacad.app.controllers;

import com.bkacad.app.App;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.exception.LoginFailedException;
import com.bkacad.app.exception.ServerErrorException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.models.facade.UserDAO;
import com.bkacad.app.views.login.LoginView;
import com.bkacad.app.views.menu.AdminHomeView;
import com.bkacad.app.views.menu.BaseHomeView;
import com.bkacad.app.views.menu.SaleHomeView;
import com.bkacad.app.views.menu.WarehouseHomeView;

public class LoginController {
    UserDAO userDAO;

    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void loggingIn(User user){
        App.loggedIn = user;
    }

    public BaseHomeView process(LoginView view) throws AbstractException{
        User user = userDAO.findUser(view.username);
        if (user.password.equals(view.password)){
            loggingIn(user);
            switch (user.role) {
                case ADMIN:
                    return new AdminHomeView();
                case SALE:
                    return new SaleHomeView();
                case WAREHOUSE:
                    return new WarehouseHomeView();
                default:
                    throw new ServerErrorException(String.format("Unknown `user.role` <%s> of `user` <%s>",user.role.toString(), user.username));
            }
        }
        throw new LoginFailedException(view.username);
    }
}
