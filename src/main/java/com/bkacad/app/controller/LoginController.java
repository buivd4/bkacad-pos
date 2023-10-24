package com.bkacad.app.controller;

import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.error.ErrorView;
import com.bkacad.app.view.login.LoginSuccess;
import com.bkacad.app.view.login.LoginView;
import com.bkacad.app.exception.LoginFailedException;
import com.bkacad.app.exception.UnknownException;
import com.bkacad.app.exception.UserNotFoundException;
import com.bkacad.app.model.User;
import com.bkacad.app.model.UserManager;

/**
 * LoginController
 */
public class LoginController {
    public static AbstractView process(LoginView view){
        try{
            User user = UserManager.findUser(view.username);
            if (user.password.equals(view.password)){
                return new LoginSuccess();
            }
            throw new LoginFailedException(view.username);
        }
        catch (UserNotFoundException e){
            return new ErrorView(e);
        }
        catch (LoginFailedException e){
            return new ErrorView(e);
        }
        catch (Exception e){
            return new ErrorView(new UnknownException());
        }
    }
}
