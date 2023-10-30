package com.bkacad.app.views.login;
import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.controllers.LoginController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.views.AbstractView;

public class LoginView extends AbstractView {
    public String username;
    public String password;
    private Scanner input = App.getInput();
    LoginController loginController = App.getLoginController();

    public void render() throws AbstractException{
        System.out.print("Tên đăng nhập: ");
        this.username = input.nextLine();
        System.out.print("Mật khẩu: ");
        this.password = input.nextLine();
        loginController.process(this).render();
    }
}
