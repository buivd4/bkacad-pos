package com.bkacad.app;

import com.bkacad.app.model.UserManager;
import com.bkacad.app.view.error.ErrorView;
import com.bkacad.app.view.login.LoginView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            UserManager.init();
            LoginView lgv = new LoginView();
            lgv.render();
        }
        catch (Exception e){
            ErrorView err = new ErrorView(e);
            err.render();
        }
    }
}
