package com.bkacad.app.view.menu;

import java.util.Scanner;

import com.bkacad.app.controller.UserController;
import com.bkacad.app.exception.WrongUserInputException;
import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.error.ErrorView;
import com.bkacad.app.view.user.UserAddView;
import com.bkacad.app.view.user.UserListView;

public class AdminMenu extends AbstractView{

    @Override
    public void render() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("Hãy lựa chọn tính năng...");
        System.out.println("[T] Thêm người dùng");
        System.out.println("[H] Hiển thị người dùng");
        System.out.print("Lựa chọn của bạn (T/H): ");
        String selection = scn.nextLine();
        switch (selection){
            case "T":
                UserAddView uav = new UserAddView();
                uav.render();
                break;
            case "H":
                UserController.list().render();;
                break;
            default:
                ErrorView ev = new ErrorView(new WrongUserInputException("Lựa chọn sai!!!!!"));
                ev.render();
        }

    }
    
}
