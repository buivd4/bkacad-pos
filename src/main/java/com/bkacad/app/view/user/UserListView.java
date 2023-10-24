package com.bkacad.app.view.user;

import java.util.ArrayList;

import com.bkacad.app.model.User;
import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.menu.AdminMenu;

public class UserListView extends AbstractView{
    ArrayList<User> users;
    public UserListView(ArrayList<User> users){
        this.users = users;
    }
    public void render() throws Exception {
        for (int i = 0; i<this.users.size();i++){
            System.out.printf("- [Người dùng] username: %s | role: %s \n", this.users.get(i).username, this.users.get(i).role.toString());
        }
        // Chuyển hướng về Admin menu
        AdminMenu am = new AdminMenu();
        am.render();
    }    
}
