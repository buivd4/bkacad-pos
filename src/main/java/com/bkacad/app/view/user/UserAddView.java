package com.bkacad.app.view.user;

import java.util.Scanner;

import com.bkacad.app.controller.UserController;
import com.bkacad.app.exception.WrongUserInputException;
import com.bkacad.app.model.User;
import com.bkacad.app.model.User.UserRole;
import com.bkacad.app.view.AbstractView;

public class UserAddView extends AbstractView{
    public String username, password;
    public User.UserRole role;

    public void render() throws Exception{
        Scanner scn = new Scanner(System.in);
        System.out.println("----");
        System.out.print("- Tên đăng nhập: ");
        this.username = scn.nextLine();
        System.out.print("- Mật khẩu: ");
        this.password = scn.nextLine();
        System.out.print("- Vai trò ([A] Admin/[S] Sale/[W] Warehouse): ");
        String roleSelection = scn.nextLine();
        switch (roleSelection){
            case "A":
                this.role=UserRole.ADMIN;
                break;
            case "S":
                this.role=UserRole.SALE;
                break;
            case "W":
                this.role=UserRole.WAREHOUSE;
                break;
            default:
                throw new WrongUserInputException("Nhập sai vai trò!!!");
        }
        UserController.process(this).render();
    }
    
}
