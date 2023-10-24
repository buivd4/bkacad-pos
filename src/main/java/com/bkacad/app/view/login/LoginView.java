package com.bkacad.app.view.login;
import java.util.Scanner;

import com.bkacad.app.view.AbstractView;
import com.bkacad.app.controller.LoginController;
import com.bkacad.app.exception.UnknownException;

public class LoginView extends AbstractView {
    public String username;
    public String password;

    public void render() throws Exception{
        Scanner scn = new Scanner(System.in);
        System.out.print("Tên đăng nhập: ");
        this.username = scn.nextLine();
        System.out.print("Mật khẩu: ");
        this.password = scn.nextLine();
        LoginController.process(this).render();
    }
}
